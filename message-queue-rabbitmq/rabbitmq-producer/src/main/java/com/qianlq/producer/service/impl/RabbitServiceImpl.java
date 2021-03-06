package com.qianlq.producer.service.impl;

import com.qianlq.core.constant.RabbitConstant;
import com.qianlq.producer.service.RabbitService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-22
 */

@Service
public class RabbitServiceImpl implements RabbitService {

    private AmqpTemplate rabbitTemplate;

    public RabbitServiceImpl(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void send(String message) {
        rabbitTemplate.convertAndSend(RabbitConstant.DIRECT, message);
    }
}
