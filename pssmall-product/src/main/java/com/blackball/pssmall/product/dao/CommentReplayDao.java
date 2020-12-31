package com.blackball.pssmall.product.dao;

import com.blackball.pssmall.product.entity.CommentReplayEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品评价回复关系
 * 
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-30 21:24:38
 */
@Mapper
public interface CommentReplayDao extends BaseMapper<CommentReplayEntity> {
	
}
