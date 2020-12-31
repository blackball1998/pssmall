package com.blackball.pssmall.coupon.dao;

import com.blackball.pssmall.coupon.entity.CouponHistoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券领取历史记录
 * 
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-31 19:22:00
 */
@Mapper
public interface CouponHistoryDao extends BaseMapper<CouponHistoryEntity> {
	
}
