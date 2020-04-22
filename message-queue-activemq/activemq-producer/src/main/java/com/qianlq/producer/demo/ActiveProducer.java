package com.qianlq.producer.demo;

import com.qianlq.core.constant.ActiveConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-20
 */

@Component
public class ActiveProducer {

    private static Logger logger = LogManager.getLogger(ActiveProducer.class);

    private JmsMessagingTemplate jms;

    private Topic topic;

    public ActiveProducer(JmsMessagingTemplate jms, Topic topic) {
        this.jms = jms;
        this.topic = topic;
    }

    public void send2Queue(String message) {
        jms.convertAndSend(ActiveConstant.QUEUE_NAME, "[Queue]Send message: " + message);
        logger.info("[Queue]Send message: {}", message);
    }

    public void send2Topic(String message) {
        jms.convertAndSend(topic, "[Topic]Send Message: " + message);
        logger.info("[Topic]Send message: {}", message);
    }

    @JmsListener(destination = ActiveConstant.OUT_QUEUE_NAME)
    public void received(String message) {
        logger.info("Received message from consumer: {}", message);
    }
}
