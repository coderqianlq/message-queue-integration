package com.qianlq.producer.config;

import com.qianlq.core.constant.ActiveConstant;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.util.Assert;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-20
 * @description activemq生产者配置
 */

@Configuration
@PropertySource(value = "classpath:application.yml", encoding = "utf-8")
public class ActiveProducerConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.user}")
    private String user;

    @Value("${spring.activemq.password}")
    private String password;

    @Value("${spring.activemq.close-timeout}")
    private Integer closeTimeout;

    @Value("${spring.activemq.send-timeout}")
    private Integer sendTimeout;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(ActiveConstant.QUEUE_NAME);
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(ActiveConstant.TOPIC_NAME);
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        Assert.notNull(brokerUrl, "brokerUrl is blank");
        Assert.notNull(user, "user is blank");
        Assert.notNull(password, "password is blank");

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, brokerUrl);
        connectionFactory.setCloseTimeout(closeTimeout);
        connectionFactory.setSendTimeout(sendTimeout);

        return connectionFactory;
    }
}
