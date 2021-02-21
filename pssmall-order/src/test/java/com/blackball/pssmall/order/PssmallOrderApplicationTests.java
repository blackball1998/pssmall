package com.blackball.pssmall.order;

import com.blackball.pssmall.order.entity.OrderEntity;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class PssmallOrderApplicationTests {

    @Autowired
    AmqpAdmin amqpAdmin;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void createExchange() {
        DirectExchange exchange = new DirectExchange("test.dir", true, false);
        amqpAdmin.declareExchange(exchange);
    }

    @Test
    void createQueue() {
        Queue queue = new Queue("test.queue", true, false, false);
        amqpAdmin.declareQueue(queue);
    }

    @Test
    void createBinding() {
        Binding binding = new Binding("test.queue", Binding.DestinationType.QUEUE, "test.dir", "test.queue", null);
        amqpAdmin.declareBinding(binding);
    }

//    @Test
//    void sendMsg() {
//        String msg = "hello world";
//        rabbitTemplate.convertAndSend("test.dir", "test.queue", msg);
//
//        OrderEntity entity = new OrderEntity();
//        entity.setId(1L);
//        entity.setCreateTime(new Date());
//        entity.setMemberUsername("wang");
//        rabbitTemplate.convertAndSend("test.dir", "test.queue", entity);
//    }
}
