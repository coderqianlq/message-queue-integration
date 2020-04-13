package com.qianlq.consumer.config;

import com.qianlq.core.constant.RocketConstant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.Assert;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-12
 * @description rocketmq消费者配置类
 */

@Configuration
@PropertySource(value = "classpath:application.yml", encoding = "utf-8")
public class RocketConsumerConfig {

    private static Logger logger = LogManager.getLogger(RocketConsumerConfig.class);

    @Value("${rocketmq.consumer.namesrv-addr}")
    private String namesrvAddr;

    @Value("${rocketmq.consumer.group-name}")
    private String groupName;

    @Bean
    public DefaultMQPushConsumer getRocketMQConsumer() throws MQClientException {
        Assert.notNull(namesrvAddr, "nameSrvAddr is blank");
        Assert.notNull(groupName, "groupName is blank");

        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(groupName);

        consumer.setNamesrvAddr(namesrvAddr);
        consumer.subscribe(RocketConstant.TOPIC_NAME, RocketConstant.TAG_NAME);

        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            for (MessageExt msg : msgs) {
                logger.info("Received message: " + new String(msg.getBody()));
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();

        return consumer;
    }
}
