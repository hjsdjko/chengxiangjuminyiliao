
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
 * 病人
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/bingren")
public class BingrenController {
    private static final Logger logger = LoggerFactory.getLogger(BingrenController.class);

    private static final String TABLE_NAME = "bingren";

    @Autowired
    private BingrenService bingrenService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private BingliService bingliService;//病例
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
    private YishengChatService yishengChatService;//医生咨询
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
        PageUtils page = bingrenService.queryPage(params);

        //字典表数据转换
        List<BingrenView> list =(List<BingrenView>)page.getList();
        for(BingrenView c:list){
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
        BingrenEntity bingren = bingrenService.selectById(id);
        if(bingren !=null){
            //entity转view
            BingrenView view = new BingrenView();
            BeanUtils.copyProperties( bingren , view );//把实体数据重构到view中
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(bingren.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
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
    public R save(@RequestBody BingrenEntity bingren, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,bingren:{}",this.getClass().getName(),bingren.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            bingren.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BingrenEntity> queryWrapper = new EntityWrapper<BingrenEntity>()
            .eq("yonghu_id", bingren.getYonghuId())
            .eq("kanhuren_name", bingren.getKanhurenName())
            .eq("kanhuren_phone", bingren.getKanhurenPhone())
            .eq("bingren_name", bingren.getBingrenName())
            .eq("bingren_phone", bingren.getBingrenPhone())
            .eq("bingren_id_number", bingren.getBingrenIdNumber())
            .eq("sex_types", bingren.getSexTypes())
            .eq("bingren_types", bingren.getBingrenTypes())
            .eq("age", bingren.getAge())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BingrenEntity bingrenEntity = bingrenService.selectOne(queryWrapper);
        if(bingrenEntity==null){
            bingren.setInsertTime(new Date());
            bingren.setCreateTime(new Date());
            bingrenService.insert(bingren);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BingrenEntity bingren, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,bingren:{}",this.getClass().getName(),bingren.toString());
        BingrenEntity oldBingrenEntity = bingrenService.selectById(bingren.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            bingren.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(bingren.getBingrenPhoto()) || "null".equals(bingren.getBingrenPhoto())){
                bingren.setBingrenPhoto(null);
        }

            bingrenService.updateById(bingren);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<BingrenEntity> oldBingrenList =bingrenService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        bingrenService.deleteBatchIds(Arrays.asList(ids));

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
            List<BingrenEntity> bingrenList = new ArrayList<>();//上传的东西
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
                            BingrenEntity bingrenEntity = new BingrenEntity();
//                            bingrenEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            bingrenEntity.setKanhurenName(data.get(0));                    //看护人姓名 要改的
//                            bingrenEntity.setKanhurenPhone(data.get(0));                    //看护人联系方式 要改的
//                            bingrenEntity.setBingrenName(data.get(0));                    //病人姓名 要改的
//                            bingrenEntity.setBingrenPhone(data.get(0));                    //病人手机号 要改的
//                            bingrenEntity.setBingrenIdNumber(data.get(0));                    //病人身份证号 要改的
//                            bingrenEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            bingrenEntity.setBingrenTypes(Integer.valueOf(data.get(0)));   //病人类型 要改的
//                            bingrenEntity.setAge(Integer.valueOf(data.get(0)));   //年龄 要改的
//                            bingrenEntity.setBingrenPhoto("");//详情和图片
//                            bingrenEntity.setBingrenContent("");//详情和图片
//                            bingrenEntity.setInsertTime(date);//时间
//                            bingrenEntity.setCreateTime(date);//时间
                            bingrenList.add(bingrenEntity);


                            //把要查询是否重复的字段放入map中
                                //病人手机号
                                if(seachFields.containsKey("bingrenPhone")){
                                    List<String> bingrenPhone = seachFields.get("bingrenPhone");
                                    bingrenPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> bingrenPhone = new ArrayList<>();
                                    bingrenPhone.add(data.get(0));//要改的
                                    seachFields.put("bingrenPhone",bingrenPhone);
                                }
                                //病人身份证号
                                if(seachFields.containsKey("bingrenIdNumber")){
                                    List<String> bingrenIdNumber = seachFields.get("bingrenIdNumber");
                                    bingrenIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> bingrenIdNumber = new ArrayList<>();
                                    bingrenIdNumber.add(data.get(0));//要改的
                                    seachFields.put("bingrenIdNumber",bingrenIdNumber);
                                }
                        }

                        //查询是否重复
                         //病人手机号
                        List<BingrenEntity> bingrenEntities_bingrenPhone = bingrenService.selectList(new EntityWrapper<BingrenEntity>().in("bingren_phone", seachFields.get("bingrenPhone")));
                        if(bingrenEntities_bingrenPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BingrenEntity s:bingrenEntities_bingrenPhone){
                                repeatFields.add(s.getBingrenPhone());
                            }
                            return R.error(511,"数据库的该表中的 [病人手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //病人身份证号
                        List<BingrenEntity> bingrenEntities_bingrenIdNumber = bingrenService.selectList(new EntityWrapper<BingrenEntity>().in("bingren_id_number", seachFields.get("bingrenIdNumber")));
                        if(bingrenEntities_bingrenIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(BingrenEntity s:bingrenEntities_bingrenIdNumber){
                                repeatFields.add(s.getBingrenIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [病人身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        bingrenService.insertBatch(bingrenList);
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
        PageUtils page = bingrenService.queryPage(params);

        //字典表数据转换
        List<BingrenView> list =(List<BingrenView>)page.getList();
        for(BingrenView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BingrenEntity bingren = bingrenService.selectById(id);
            if(bingren !=null){


                //entity转view
                BingrenView view = new BingrenView();
                BeanUtils.copyProperties( bingren , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(bingren.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
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
    public R add(@RequestBody BingrenEntity bingren, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,bingren:{}",this.getClass().getName(),bingren.toString());
        Wrapper<BingrenEntity> queryWrapper = new EntityWrapper<BingrenEntity>()
            .eq("yonghu_id", bingren.getYonghuId())
            .eq("kanhuren_name", bingren.getKanhurenName())
            .eq("kanhuren_phone", bingren.getKanhurenPhone())
            .eq("bingren_name", bingren.getBingrenName())
            .eq("bingren_phone", bingren.getBingrenPhone())
            .eq("bingren_id_number", bingren.getBingrenIdNumber())
            .eq("sex_types", bingren.getSexTypes())
            .eq("bingren_types", bingren.getBingrenTypes())
            .eq("age", bingren.getAge())
//            .notIn("bingren_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BingrenEntity bingrenEntity = bingrenService.selectOne(queryWrapper);
        if(bingrenEntity==null){
            bingren.setInsertTime(new Date());
            bingren.setCreateTime(new Date());
        bingrenService.insert(bingren);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

