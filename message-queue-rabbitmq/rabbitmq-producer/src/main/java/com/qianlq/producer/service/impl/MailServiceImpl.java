package com.qianlq.producer.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianlq.core.constant.RabbitConstant;
import com.qianlq.core.model.dto.MailDTO;
import com.qianlq.producer.service.MailService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

/**
 * @author coderqian
 * @date 2019-09-22 19:17
 * @since v1.0
 */

@Service
public class MailServiceImpl implements MailService {

    private AmqpTemplate rabbitTemplate;

    private ObjectMapper mapper;

    public MailServiceImpl(AmqpTemplate rabbitTemplate, ObjectMapper mapper) {
        this.rabbitTemplate = rabbitTemplate;
        this.mapper = mapper;
    }

    @Override
    public void sendMail(String to, String subject, String content) {
        MailDTO dto = new MailDTO();
        dto.setTo(to);
        dto.setSubject(subject);
        dto.setContent(content);
        try {
            rabbitTemplate.convertAndSend(RabbitConstant.MAIL, mapper.writeValueAsString(dto).getBytes());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
