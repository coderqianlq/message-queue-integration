package com.qianlq.consumer.demo;

import com.qianlq.core.constant.ActiveConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-20
 */

@Component
public class QueueConsumer {

    private static Logger logger = LogManager.getLogger(QueueConsumer.class);

    @JmsListener(destination = ActiveConstant.QUEUE_NAME, containerFactory = "jmsListenerContainerQueue")
    @SendTo(value = ActiveConstant.OUT_QUEUE_NAME)
    public String received(String message) {
        logger.info("Received message: {}", message);
        return "I have received message: " + message;
    }
}
