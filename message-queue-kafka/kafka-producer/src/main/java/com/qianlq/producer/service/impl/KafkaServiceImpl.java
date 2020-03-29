package com.qianlq.producer.service.impl;

import com.qianlq.core.constant.KafkaConstant;
import com.qianlq.producer.service.KafkaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-24
 * @description 发送消息的服务
 */

@Service
public class KafkaServiceImpl implements KafkaService {

    private static Logger logger = LogManager.getLogger(KafkaServiceImpl.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    @SuppressWarnings("unchecked")
    public KafkaServiceImpl(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void send(String message) {
        kafkaTemplate.send(KafkaConstant.TOPIC_NAME, message)
                .addCallback(result -> {}, ex -> logger.error("Failed to send message.\n" + ex));
    }
}
