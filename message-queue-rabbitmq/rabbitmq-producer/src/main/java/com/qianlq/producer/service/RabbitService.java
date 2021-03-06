package com.qianlq.producer.service;

/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-22
 */

public interface RabbitService {

    /**
     * 发送指定字符串到消息队列
     *
     * @param message 字符串
     */
    void send(String message);
}
