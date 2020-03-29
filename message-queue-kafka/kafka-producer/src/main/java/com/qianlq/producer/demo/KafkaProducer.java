package com.qianlq.producer.demo;

import com.qianlq.core.constant.KafkaConstant;
import com.qianlq.core.model.dto.MessageDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.UUID;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-24
 */

@Component
public class KafkaProducer {

    private static Logger logger = LogManager.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    @SuppressWarnings("unchecked")
    public KafkaProducer(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(String message) {
        MessageDTO dto = new MessageDTO();
        dto.setId(UUID.randomUUID().toString());
        dto.setMessage(message);
        kafkaTemplate.send(KafkaConstant.TOPIC_NAME, dto.toString()).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                // do something
                logger.error("Failed to send message.\n" + ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                // do something
            }
        });
    }
}
