package com.blackball.pssmall.order.service.impl;

import com.blackball.pssmall.order.entity.OrderItemEntity;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blackball.common.utils.PageUtils;
import com.blackball.common.utils.Query;

import com.blackball.pssmall.order.dao.OrderDao;
import com.blackball.pssmall.order.entity.OrderEntity;
import com.blackball.pssmall.order.service.OrderService;

@RabbitListener(queues = {"test.queue","release.order"})
@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<OrderEntity> page = this.page(
                new Query<OrderEntity>().getPage(params),
                new QueryWrapper<OrderEntity>()
        );

        return new PageUtils(page);
    }

    public void sendMsg() {
        for (int i = 0; i < 5; i++) {
//            if ((i & 1) == 0) {
            OrderEntity entity = new OrderEntity();
            entity.setId(1L);
            entity.setCreateTime(new Date());
            entity.setMemberUsername("wang");
//            rabbitTemplate.convertAndSend("test.dir", "test.queue", entity, new CorrelationData(UUID.randomUUID().toString()));
            rabbitTemplate.convertAndSend("delay.dir", "delay.order", entity, new CorrelationData(UUID.randomUUID().toString()));
//            } else {
//                OrderItemEntity entity = new OrderItemEntity();
//                entity.setId(1L);
//                entity.setOrderSn("123123");
////                rabbitTemplate.convertAndSend("test.dir", "test.queue", entity);
//                rabbitTemplate.convertAndSend("test.dir", "test2.queue", entity);
//            }
        }
    }

    @RabbitHandler
    public void receiveMsg1(Message message, OrderEntity entity, Channel channel) throws IOException {
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
//        if ((deliveryTag & 1) == 0) {
            System.out.println("deliveryTag:" + deliveryTag);
            System.out.println(new String(message.getBody()));
//        System.out.println(message.getMessageProperties());
            System.out.println(entity.getCreateTime());
            System.out.println(entity.getMemberUsername());
            channel.basicAck(deliveryTag, false);
//        } else {
//            System.out.println("nack:" + deliveryTag);
//            channel.basicNack(deliveryTag, false, true);
//        }
    }

    @RabbitHandler
    public void receiveMsg2(Message message, OrderItemEntity entity) {
        System.out.println(new String(message.getBody()));
//        System.out.println(message.getMessageProperties());
        System.out.println(entity.getId());
        System.out.println(entity.getOrderSn());
    }

}