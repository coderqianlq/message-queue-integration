package com.qianlq.producer.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.StringUtils;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-03-30
 * @description rocketmq配置类
 */


@Configuration
@PropertySource(value = "classpath:application.yml", encoding = "utf-8")
public class RocketConfig {

    private static Logger logger = LogManager.getLogger(RocketConfig.class);

    @Value("${rocketmq.producer.name-server-addr}")
    private String nameServerAddr;

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
        if (StringUtils.isEmpty(groupName)) {
            throw new MQClientException(-1, "groupName is blank");
        }

        if (StringUtils.isEmpty(nameServerAddr)) {
            throw new MQClientException(-1, "nameServerAddr is blank");
        }
        DefaultMQProducer producer = new DefaultMQProducer(this.groupName);
        producer.setNamesrvAddr(nameServerAddr);
        // producer.setCreateTopicKey("AUTO_CREATE_TOPIC_KEY");
        // 如果需要同一个jvm中不同的producer往不同的mq集群发送消息，需要设置不同的instanceName
        // producer.setInstanceName(instanceName);
        producer.setMaxMessageSize(maxMessageSize);
        producer.setSendMsgTimeout(sendMessageTimeout);
        producer.setRetryTimesWhenSendFailed(retryTimesWhenSendFailed);

        try {
            producer.start();
            logger.info("producer is start ! groupName:{},nameServerAddr:{}", groupName, nameServerAddr);
        } catch (MQClientException ex) {
            logger.error("producer is error {}", ex.getMessage());
            throw ex;
        }
        return producer;
    }
}
