package com.qianlq.producer.config.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;


/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-07
 * @description rabbitmq配置类
 */

@Configuration
public class RabbitConfig {

    public static final String DIRECT = "direct";
    private static final String TOPIC_FIRST = "topic.a";
    private static final String TOPIC_SECOND = "topic.b";
    private static final String FANOUT = "fanout";
    private static final String HEADERS = "headers";

    public static final String DIRECT_EXCHANGE = "direct-exchange";
    public static final String FANOUT_EXCHANGE = "fanout-exchange";
    public static final String TOPIC_EXCHANGE = "topic-exchange";
    public static final String HEADERS_EXCHANGE = "headers-exchange";

    public static final String MAIL = "mail";

    @Bean
    public Queue directQueue() {
        return new Queue(DIRECT);
    }

    @Bean
    public Queue topicFirstQueue() {
        return new Queue(TOPIC_FIRST);
    }

    @Bean
    public Queue topicSecondQueue() {
        return new Queue(TOPIC_SECOND);
    }

    @Bean
    public Queue fanoutQueue() {
        return new Queue(FANOUT);
    }

    @Bean
    public Queue headersQueue() {
        return new Queue(HEADERS);
    }

    @Bean
    public Queue mailQueue() {
        return new Queue(MAIL);
    }

    @Bean
    DirectExchange directExchange() {
        // 声明一个名为direct的direct交换器
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Binding bindingDirect() {
        // 将队列与directExchange交换机绑定
        return BindingBuilder.bind(directQueue()).to(directExchange()).with("direct");
    }

    @Bean
    TopicExchange topicExchange() {
        // 声明一个名为topic的topic交换器
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding bindingTopicA() {
        // 将队列与topicExchange交换机绑定
        return BindingBuilder.bind(topicFirstQueue()).to(topicExchange()).with("topic.a.#");
    }

    @Bean
    public Binding bindingTopicB() {
        // 将队列与topicExchange交换机绑定
        return BindingBuilder.bind(topicSecondQueue()).to(topicExchange()).with("topic.b.#");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        // 声明一个名为fanout的fanout交换器
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Binding bindingFanout() {
        // 将队列与fanoutExchange交换机绑定
        return BindingBuilder.bind(fanoutQueue()).to(fanoutExchange());
    }

    @Bean
    HeadersExchange headersExchange() {
        return new HeadersExchange(HEADERS_EXCHANGE);
    }

    @Bean
    Binding bindingHeaders() {
        // 将队列与headers交换机进行绑定
        Map<String, Object> map = new HashMap<>(4);
        map.put("First", "A");
        map.put("Fourth", "D");
        // whereAny表示部分匹配，whereAll表示全部匹配
        return BindingBuilder.bind(headersQueue()).to(headersExchange()).whereAny(map).match();
    }
}
