package com.qianlq.producer.demo;

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

    private JmsMessagingTemplate jms;

    private Queue queue;

    private Topic topic;

    public ActiveProducer(JmsMessagingTemplate jms, Queue queue, Topic topic) {
        this.jms = jms;
        this.queue = queue;
        this.topic = topic;
    }

    public void send(String message) {
        jms.convertAndSend(queue, "Send message: " + message);
    }
}
