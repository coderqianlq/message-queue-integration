package com.qianlq.consumer.demo;

import com.qianlq.core.constant.KafkaConstant;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-28
 */

@Component
public class KafkaConsumer {

    private static Logger logger = LogManager.getLogger(KafkaConsumer.class);

    @KafkaListener(id = "id0", topicPartitions = {@TopicPartition(topic = KafkaConstant.TOPIC_NAME, partitions = {"0"})})
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            logger.info("Received message={}", message);
        }
    }

    @KafkaListener(id = "id1-4", topicPartitions = {@TopicPartition(topic = KafkaConstant.TOPIC_NAME, partitions = {"1", "2", "3"})}, containerFactory = "batchFactory")
    public void listen(List<ConsumerRecord<?, ?>> records) {
        for (ConsumerRecord<?, ?> record : records) {
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());

            if (kafkaMessage.isPresent()) {
                Object message = record.value();
                logger.info("Received message={}", message);
            }
        }
    }
}
