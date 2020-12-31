package com.blackball.pssmall.order.dao;

import com.blackball.pssmall.order.entity.PaymentInfoEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 支付信息表
 * 
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-31 19:16:22
 */
@Mapper
public interface PaymentInfoDao extends BaseMapper<PaymentInfoEntity> {
	
}
