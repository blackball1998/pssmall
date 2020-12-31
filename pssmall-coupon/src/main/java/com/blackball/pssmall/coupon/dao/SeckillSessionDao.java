package com.blackball.pssmall.coupon.dao;

import com.blackball.pssmall.coupon.entity.SeckillSessionEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 秒杀活动场次
 * 
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-31 19:21:59
 */
@Mapper
public interface SeckillSessionDao extends BaseMapper<SeckillSessionEntity> {
	
}
