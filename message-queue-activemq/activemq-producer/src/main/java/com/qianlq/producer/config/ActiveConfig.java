package com.qianlq.producer.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
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
public class ActiveConfig {

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

    @Value("${queue.name}")
    private String queueName;

    @Value("${topic.name}")
    private String topicName;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(queueName);
    }

    @Bean
    public Topic topic() {
        return new ActiveMQTopic(topicName);
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

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        bean.setPubSubDomain(false);
        return bean;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        // 设置为发布订阅方式, 默认情况下使用的生产消费者方式
        bean.setPubSubDomain(true);
        return bean;
    }
}
