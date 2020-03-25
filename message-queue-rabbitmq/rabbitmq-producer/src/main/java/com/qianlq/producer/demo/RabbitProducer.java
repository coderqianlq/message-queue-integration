package com.qianlq.producer.demo;

import com.qianlq.core.constant.RabbitConstant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-07
 * @description 消息发送
 */

@Component
public class RabbitProducer {

    private AmqpTemplate rabbitTemplate;

    public RabbitProducer(AmqpTemplate rabbitTemplate) {
        // spring boot 2.x版本推荐构造器注入 而不是属性注入
        this.rabbitTemplate = rabbitTemplate;
    }

    public void directSend(String message) {
        // 第一个参数为刚刚定义的队列名称
        this.rabbitTemplate.convertAndSend(RabbitConstant.DIRECT_EXCHANGE, "direct", message);
    }

    public void topicSend(String message) {
        // this.rabbitTemplate.convertAndSend(RabbitConfig.TOPIC_EXCHANGE, "topic.a", message);
        this.topicSend("topic.a", message);
    }

    public void topicSend(String routingKey, String message) {
        this.rabbitTemplate.convertAndSend(RabbitConstant.TOPIC_EXCHANGE, routingKey, message);
    }

    public void fanoutSend(String message) {
        // 注意 第一个参数是我们交换机的名称 第二个参数是routerKey(暂时先忽略) 第三个是你要发送的消息
        this.rabbitTemplate.convertAndSend(RabbitConstant.FANOUT_EXCHANGE, message);
    }

    public void headersSend(String content, Map<String, Object> map) {
        this.rabbitTemplate.convertAndSend(RabbitConstant.HEADERS_EXCHANGE, null, content, message -> {
            message.getMessageProperties().getHeaders().putAll(map);
            return message;
        });
    }
}
