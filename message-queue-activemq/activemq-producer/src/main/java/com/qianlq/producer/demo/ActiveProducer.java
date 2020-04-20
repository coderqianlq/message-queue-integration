package com.qianlq.producer.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private Queue queue;

    private Topic topic;

    public ActiveProducer(JmsMessagingTemplate jms, Queue queue, Topic topic) {
        this.jms = jms;
        this.queue = queue;
        this.topic = topic;
    }

    public void send2Queue(String message) {
        logger.info("[Queue]Send message: {}", message);
        jms.convertAndSend(queue, "[Queue]Send message: " + message);
    }

    public void send2Topic(String message) {
        logger.info("[Topic]Send message: {}", message);
        jms.convertAndSend(topic, "[Topic]Send Message: " + message);
    }
}
