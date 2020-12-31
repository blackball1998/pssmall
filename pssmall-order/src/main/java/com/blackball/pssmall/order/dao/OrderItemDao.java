package com.blackball.pssmall.order.dao;

import com.blackball.pssmall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 * 
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-31 19:16:22
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}
