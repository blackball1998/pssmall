package com.blackball.pssmall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blackball.common.utils.PageUtils;
import com.blackball.pssmall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author blackball
 * @email blackball@outlook.com
 * @date 2020-12-31 19:16:22
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);


    void sendMsg();
}

