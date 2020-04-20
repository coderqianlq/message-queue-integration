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
 * @date 2020-03-24
 */

@Component
@RabbitListener(queues = {RabbitConstant.HEADERS})
public class HeadersConsumer {

    private static Logger logger = LogManager.getLogger(HeadersConsumer.class);

    private AmqpTemplate rabbitmqTemplate;

    public HeadersConsumer(AmqpTemplate rabbitmqTemplate) {
        this.rabbitmqTemplate = rabbitmqTemplate;
    }

    /**
     * 消息消费
     */
    @RabbitHandler
    public void received(String msg) {
        logger.info("[headers] received message:" + msg);
    }
}
