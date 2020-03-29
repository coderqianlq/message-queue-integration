package com.qianlq.consumer.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-28
 */

@Component
public class KafkaConsumer {

    private static Logger logger = LogManager.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = {"topic-test"}, containerFactory = "batchFactory")
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info(message);
        }
    }
}
