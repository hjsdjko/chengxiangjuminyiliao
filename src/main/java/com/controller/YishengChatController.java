
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 医生咨询
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yishengChat")
public class YishengChatController {
    private static final Logger logger = LoggerFactory.getLogger(YishengChatController.class);

    private static final String TABLE_NAME = "yishengChat";

    @Autowired
    private YishengChatService yishengChatService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BingliService bingliService;//病例
    @Autowired
    private BingrenService bingrenService;//病人
    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//医院资讯
    @Autowired
    private YaopinService yaopinService;//药品
    @Autowired
    private YaopinrukuService yaopinrukuService;//药品入库
    @Autowired
    private YaopinshiyongService yaopinshiyongService;//药品使用
    @Autowired
    private YishengService yishengService;//医生
    @Autowired
    private YishengGuahaoService yishengGuahaoService;//医生挂号
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = yishengChatService.queryPage(params);

        //字典表数据转换
        List<YishengChatView> list =(List<YishengChatView>)page.getList();
        for(YishengChatView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YishengChatEntity yishengChat = yishengChatService.selectById(id);
        if(yishengChat !=null){
            //entity转view
            YishengChatView view = new YishengChatView();
            BeanUtils.copyProperties( yishengChat , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(yishengChat.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yishengId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 医生
            //级联表
            YishengEntity yisheng = yishengService.selectById(yishengChat.getYishengId());
            if(yisheng != null){
            BeanUtils.copyProperties( yisheng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yishengId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYishengId(yisheng.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody YishengChatEntity yishengChat, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yishengChat:{}",this.getClass().getName(),yishengChat.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("医生".equals(role))
            yishengChat.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用户".equals(role))
            yishengChat.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<YishengChatEntity> queryWrapper = new EntityWrapper<YishengChatEntity>()
            .eq("yonghu_id", yishengChat.getYonghuId())
            .eq("yisheng_id", yishengChat.getYishengId())
            .eq("zhuangtai_types", yishengChat.getZhuangtaiTypes())
            .eq("yisheng_chat_types", yishengChat.getYishengChatTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengChatEntity yishengChatEntity = yishengChatService.selectOne(queryWrapper);
        if(yishengChatEntity==null){
            yishengChat.setInsertTime(new Date());
            yishengChat.setCreateTime(new Date());
            yishengChatService.insert(yishengChat);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YishengChatEntity yishengChat, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,yishengChat:{}",this.getClass().getName(),yishengChat.toString());
        YishengChatEntity oldYishengChatEntity = yishengChatService.selectById(yishengChat.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("医生".equals(role))
//            yishengChat.setYishengId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            yishengChat.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            yishengChatService.updateById(yishengChat);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<YishengChatEntity> oldYishengChatList =yishengChatService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        yishengChatService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<YishengChatEntity> yishengChatList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            YishengChatEntity yishengChatEntity = new YishengChatEntity();
//                            yishengChatEntity.setYonghuId(Integer.valueOf(data.get(0)));   //提问人 要改的
//                            yishengChatEntity.setYishengId(Integer.valueOf(data.get(0)));   //回答人 要改的
//                            yishengChatEntity.setYishengChatIssueText(data.get(0));                    //问题 要改的
//                            yishengChatEntity.setIssueTime(sdf.parse(data.get(0)));          //问题时间 要改的
//                            yishengChatEntity.setYishengChatReplyText(data.get(0));                    //回复 要改的
//                            yishengChatEntity.setReplyTime(sdf.parse(data.get(0)));          //回复时间 要改的
//                            yishengChatEntity.setZhuangtaiTypes(Integer.valueOf(data.get(0)));   //状态 要改的
//                            yishengChatEntity.setYishengChatTypes(Integer.valueOf(data.get(0)));   //数据类型 要改的
//                            yishengChatEntity.setInsertTime(date);//时间
//                            yishengChatEntity.setCreateTime(date);//时间
                            yishengChatList.add(yishengChatEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        yishengChatService.insertBatch(yishengChatList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = yishengChatService.queryPage(params);

        //字典表数据转换
        List<YishengChatView> list =(List<YishengChatView>)page.getList();
        for(YishengChatView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        YishengChatEntity yishengChat = yishengChatService.selectById(id);
            if(yishengChat !=null){


                //entity转view
                YishengChatView view = new YishengChatView();
                BeanUtils.copyProperties( yishengChat , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(yishengChat.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    YishengEntity yisheng = yishengService.selectById(yishengChat.getYishengId());
                if(yisheng != null){
                    BeanUtils.copyProperties( yisheng , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYishengId(yisheng.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody YishengChatEntity yishengChat, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,yishengChat:{}",this.getClass().getName(),yishengChat.toString());
        Wrapper<YishengChatEntity> queryWrapper = new EntityWrapper<YishengChatEntity>()
            .eq("yonghu_id", yishengChat.getYonghuId())
            .eq("yisheng_id", yishengChat.getYishengId())
            .eq("yisheng_chat_issue_text", yishengChat.getYishengChatIssueText())
            .eq("yisheng_chat_reply_text", yishengChat.getYishengChatReplyText())
            .eq("zhuangtai_types", yishengChat.getZhuangtaiTypes())
            .eq("yisheng_chat_types", yishengChat.getYishengChatTypes())
//            .notIn("yisheng_chat_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YishengChatEntity yishengChatEntity = yishengChatService.selectOne(queryWrapper);
        if(yishengChatEntity==null){
            yishengChat.setInsertTime(new Date());
            yishengChat.setCreateTime(new Date());
        yishengChatService.insert(yishengChat);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

