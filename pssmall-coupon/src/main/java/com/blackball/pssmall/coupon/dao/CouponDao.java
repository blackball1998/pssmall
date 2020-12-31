package com.blackball.pssmall.coupon.dao;

import com.blackball.pssmall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-31 19:22:00
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
