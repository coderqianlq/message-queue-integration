package com.qianlq.consumer.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-20
 */

@Component
public class QueueConsumer {

    private static Logger logger = LogManager.getLogger(QueueConsumer.class);

    @JmsListener(destination = "queue0-test", containerFactory = "jmsListenerContainerQueue")
    public void received(String message) {
        logger.info("[Queue]Received message: {}", message);
    }
}
