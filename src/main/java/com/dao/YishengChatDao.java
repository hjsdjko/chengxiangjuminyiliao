package com.dao;

import com.entity.YishengChatEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YishengChatView;

/**
 * 医生咨询 Dao 接口
 *
 * @author 
 */
public interface YishengChatDao extends BaseMapper<YishengChatEntity> {

   List<YishengChatView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
