package com.qianlq.producer.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.MixAll;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.Assert;

/**
 * @author coderqian
 * @version v1.1
 * @date 2020-03-30
 * @description rocketmq生产者配置类
 */


@Configuration
@PropertySource(value = "classpath:application.yml", encoding = "utf-8")
public class RocketProducerConfig {

    private static Logger logger = LogManager.getLogger(RocketProducerConfig.class);

    @Value("${rocketmq.producer.namesrv-addr}")
    private String namesrvAddr;

    @Value("${rocketmq.producer.group-name}")
    private String groupName;

    @Value("${rocketmq.producer.max-message-size}")
    private Integer maxMessageSize;

    @Value("${rocketmq.producer.send-message-timeout}")
    private Integer sendMessageTimeout;

    @Value("${rocketmq.producer.retry-times-when-send-failed}")
    private Integer retryTimesWhenSendFailed;

    @Bean
    public DefaultMQProducer getRocketMQProducer() throws MQClientException {
        Assert.notNull(namesrvAddr, "nameSrvAddr is blank");
        Assert.notNull(groupName, "groupName is blank");

        DefaultMQProducer producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(namesrvAddr);
        producer.setCreateTopicKey(MixAll.AUTO_CREATE_TOPIC_KEY_TOPIC);
        // 如果需要同一个jvm中不同的producer往不同的mq集群发送消息，需要设置不同的instanceName
        // producer.setInstanceName(instanceName);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setSendMsgTimeout(sendMessageTimeout);
        producer.setRetryTimesWhenSendFailed(retryTimesWhenSendFailed);

        try {
            producer.start();
            logger.info("producer is start ! groupName: {},nameSrvAddr: {}", groupName, namesrvAddr);
        } catch (MQClientException ex) {
            logger.error("producer is error: {}", ex.getMessage());
            throw ex;
        }
        return producer;
    }
}
