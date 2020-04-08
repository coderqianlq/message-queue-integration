package com.qianlq.consumer.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qianlq.consumer.config.MailConfig;
import com.qianlq.core.model.dto.MailDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author coderqian
 * @date 2019-09-22 21:15
 * @since v1.0
 */

@Service
public class MailHandler {

    private Logger logger = LogManager.getLogger(MailHandler.class);


    private ObjectMapper mapper;

    private AmqpTemplate rabbitTemplate;

    private JavaMailSender mailSender;

    private MailConfig mailConfig;

    public MailHandler(ObjectMapper mapper, AmqpTemplate rabbitmqTemplate, JavaMailSender mailSender, MailConfig mailConfig) {
        this.mapper = mapper;
        this.rabbitTemplate = rabbitmqTemplate;
        this.mailSender = mailSender;
        this.mailConfig = mailConfig;
    }

    @RabbitListener(queues = {"mail"})
    public void received(Message message) {
        String msg = new String(message.getBody());
        MailDTO dto = null;
        try {
            dto = mapper.readValue(msg.getBytes(StandardCharsets.UTF_8), MailDTO.class);
            logger.info(dto);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.notNull(dto, "邮件传输实体不能为NULL");
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(mailConfig.getUsername());
        mailMessage.setTo(dto.getTo());
        mailMessage.setSubject(dto.getSubject());
        mailMessage.setText(dto.getContent());

        try {
            mailSender.send(mailMessage);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
