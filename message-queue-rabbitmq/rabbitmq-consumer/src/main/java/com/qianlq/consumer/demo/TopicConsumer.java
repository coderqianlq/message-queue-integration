package com.qianlq.consumer.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-16
 */

@Component
@RabbitListener(queues = {"topic.a", "topic.b"})
public class TopicConsumer {

    private AmqpTemplate rabbitmqTemplate;

    public TopicConsumer(AmqpTemplate rabbitmqTemplate) {
        this.rabbitmqTemplate = rabbitmqTemplate;
    }

    /**
     * 消息消费
     */
    @RabbitHandler
    public void received(String msg) {
        System.out.println("[topic] received message: " + msg);
    }
}
