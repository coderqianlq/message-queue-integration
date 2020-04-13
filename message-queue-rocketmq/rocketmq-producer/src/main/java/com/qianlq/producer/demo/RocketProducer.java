package com.qianlq.producer.demo;

import com.qianlq.core.constant.RocketConstant;
import com.qianlq.producer.config.RocketProducerConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;


/**
 * @author coderqian
 * @version v1.0
 * @date 2020-04-11
 */

@Component
public class RocketProducer {

    private static Logger logger = LogManager.getLogger(RocketProducer.class);

    private DefaultMQProducer defaultProducer;

    public RocketProducer(DefaultMQProducer defaultProducer) {
        this.defaultProducer = defaultProducer;
    }

    public void send(String str) throws UnsupportedEncodingException {
        Message message = new Message(RocketConstant.TOPIC_NAME, RocketConstant.TAG_NAME, str.getBytes(RemotingHelper.DEFAULT_CHARSET));
        try {
            defaultProducer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Send message error." + e.getMessage());
        }
    }

}
