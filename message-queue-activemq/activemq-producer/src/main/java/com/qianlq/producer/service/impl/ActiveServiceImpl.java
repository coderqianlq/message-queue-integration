package com.qianlq.producer.service.impl;

import com.qianlq.core.constant.ActiveConstant;
import com.qianlq.core.model.dto.MessageDTO;
import com.qianlq.producer.service.ActiveService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-21
 */

@Service
public class ActiveServiceImpl implements ActiveService {

    private static Logger logger = LogManager.getLogger(ActiveServiceImpl.class);

    private JmsMessagingTemplate jms;

    public ActiveServiceImpl(JmsMessagingTemplate jms) {
        this.jms = jms;
    }

    @Override
    public void send2Queue(String title, String content) {
        MessageDTO dto = new MessageDTO();
        dto.setTitle(title);
        dto.setContent(content);
        jms.convertAndSend(ActiveConstant.OBJECT_QUEUE_NAME, dto);
        logger.info("[Queue]Send message: {}", dto.toString());
    }
}
