package com.dao;

import com.entity.BingrenEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BingrenView;

/**
 * 病人 Dao 接口
 *
 * @author 
 */
public interface BingrenDao extends BaseMapper<BingrenEntity> {

   List<BingrenView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
