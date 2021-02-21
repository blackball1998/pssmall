package com.blackball.pssmall.order.config;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@Configuration
public class RabbitConfig {

    private static final Logger logger = LoggerFactory.getLogger("callback");

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @PostConstruct
    public void initTemplate() {
        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
            logger.info("{}", correlationData);
            logger.info("{}", ack);
            logger.info("{}", cause);
        });
        rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText, String exchange, String routingKey) -> {
            System.out.println(message);
            System.out.println(replyCode);
            System.out.println(replyText);
        });
    }

    @Bean
    public Exchange delayExchange() {
        return new TopicExchange("delay.dir", true, false);
    }

    @Bean
    public Queue delayQueue() {
        HashMap<String, Object> arguments = new HashMap<>();
        arguments.put("x-dead-letter-exchange", "delay.dir");
        arguments.put("x-dead-letter-routing-key", "release.order");
        arguments.put("x-message-ttl", 10000);
        return new Queue("delay.order", true, false, false, arguments);
    }

    @Bean
    public Queue releaseQueue() {
        return new Queue("release.order", true, false, false);
    }

    @Bean
    public Binding delayQueueBinding() {
        return new Binding("delay.order", Binding.DestinationType.QUEUE, "delay.dir", "delay.order", null);
    }

    @Bean
    public Binding releaseQueueBinding() {
        return new Binding("release.order", Binding.DestinationType.QUEUE, "delay.dir", "release.order", null);
    }
}
