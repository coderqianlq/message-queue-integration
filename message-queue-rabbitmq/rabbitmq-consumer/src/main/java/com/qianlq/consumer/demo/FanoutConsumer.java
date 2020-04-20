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
 * @date 2019-09-07
 */

@Component
@RabbitListener(queues = {RabbitConstant.FANOUT})
public class FanoutConsumer {

    private static Logger logger = LogManager.getLogger(FanoutConsumer.class);

    private AmqpTemplate rabbitmqTemplate;

    public FanoutConsumer(AmqpTemplate rabbitmqTemplate) {
        this.rabbitmqTemplate = rabbitmqTemplate;
    }

    /**
     * 消息消费
     */
    @RabbitHandler
    public void received(String msg) {
        logger.info("[fanout] received message:" + msg);
    }
}
