package com.blackball.pssmall.product.dao;

import com.blackball.pssmall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-30 21:24:39
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
