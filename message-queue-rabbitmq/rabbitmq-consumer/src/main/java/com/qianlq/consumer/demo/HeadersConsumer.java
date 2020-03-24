package com.qianlq.consumer.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-24
 */

@Component
@RabbitListener(queues = {"headers"})
public class HeadersConsumer {

    private AmqpTemplate rabbitmqTemplate;

    public HeadersConsumer(AmqpTemplate rabbitmqTemplate) {
        this.rabbitmqTemplate = rabbitmqTemplate;
    }

    /**
     * 消息消费
     */
    @RabbitHandler
    public void received(String msg) {
        System.out.println("[headers] received message:" + msg);
    }
}
