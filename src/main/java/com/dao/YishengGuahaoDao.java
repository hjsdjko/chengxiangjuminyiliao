package com.dao;

import com.entity.YishengGuahaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YishengGuahaoView;

/**
 * 医生挂号 Dao 接口
 *
 * @author 
 */
public interface YishengGuahaoDao extends BaseMapper<YishengGuahaoEntity> {

   List<YishengGuahaoView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
