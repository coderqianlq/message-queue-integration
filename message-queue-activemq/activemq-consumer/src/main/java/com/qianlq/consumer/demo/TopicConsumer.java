package com.qianlq.consumer.demo;

import com.qianlq.core.constant.ActiveConstant;
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
public class TopicConsumer {

    private static Logger logger = LogManager.getLogger(TopicConsumer.class);

    @JmsListener(destination = ActiveConstant.TOPIC_NAME, containerFactory = "jmsListenerContainerTopic")
    public void received(String message) {
        logger.info("Received message: {}", message);
    }
}
