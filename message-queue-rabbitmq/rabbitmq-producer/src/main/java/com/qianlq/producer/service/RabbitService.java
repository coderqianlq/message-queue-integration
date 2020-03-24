package com.qianlq.producer.service;

/**
 * @author coderqian
 * @date 2019-09-22 20:25
 * @since v1.0
 */

public interface RabbitService {

    /**
     * 发送指定字符串到消息队列
     *
     * @param message 字符串
     */
    void send(String message);
}
