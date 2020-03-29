package com.qianlq.producer.service;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-24
 */

public interface KafkaService {

    /**
     * 发送字符串
     *
     * @param message 消息内容
     */
    void send(String message);
}
