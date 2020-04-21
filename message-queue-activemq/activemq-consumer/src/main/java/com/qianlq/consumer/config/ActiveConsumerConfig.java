package com.qianlq.consumer.config;

import com.qianlq.core.constant.ActiveConstant;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.util.Assert;

import javax.jms.Queue;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-20
 * @description activemq消费者配置类
 */

@Configuration
@PropertySource(value = "classpath:application.yml", encoding = "utf-8")
public class ActiveConsumerConfig {

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Value("${spring.activemq.user}")
    private String user;

    @Value("${spring.activemq.password}")
    private String password;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(ActiveConstant.OUT_QUEUE_NAME);
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        Assert.notNull(brokerUrl, "brokerUrl is blank");
        Assert.notNull(user, "user is blank");
        Assert.notNull(password, "password is blank");

        return new ActiveMQConnectionFactory(user, password, brokerUrl);
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
