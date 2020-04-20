package com.qianlq.consumer.demo;

import com.qianlq.core.constant.RabbitConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
@RabbitListener(queues = {RabbitConstant.TOPIC_FIRST, RabbitConstant.TOPIC_SECOND})
public class TopicConsumer {

    private static Logger logger = LogManager.getLogger(TopicConsumer.class);

    private AmqpTemplate rabbitTemplate;

    public TopicConsumer(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    /**
     * 使用监听器RabbitListener处理消息
     */
    @RabbitHandler
    public void received(String msg) {
        logger.info("[topic] received message: " + msg);
    }
}
