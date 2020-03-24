package com.qianlq.consumer.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-07
 */

@Component
@RabbitListener(queues = {"direct"})
public class DirectConsumer {

    private AmqpTemplate rabbitmqTemplate;

    public DirectConsumer(AmqpTemplate rabbitmqTemplate) {
        this.rabbitmqTemplate = rabbitmqTemplate;
    }

    /**
     * 消息消费
     */
    @RabbitHandler
    public void received(String msg) {
        System.out.println("[direct] received message: " + msg);
    }

}
