package com.qianlq.consumer.service;

import com.qianlq.core.constant.ActiveConstant;
import com.qianlq.core.model.dto.MessageDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-22
 */

@Service
public class MessageHandler {

    private static Logger logger = LogManager.getLogger(MessageHandler.class);

    @JmsListener(destination = ActiveConstant.OBJECT_QUEUE_NAME, containerFactory = "jmsListenerContainerQueue")
    public void received(ObjectMessage message) {
        try {
            MessageDTO dto = (MessageDTO) message.getObject();
            logger.info("Received message: {}", dto);
        } catch (JMSException e) {
            logger.error("Copy properties failed: {}", e.getMessage());
        }
    }
}
