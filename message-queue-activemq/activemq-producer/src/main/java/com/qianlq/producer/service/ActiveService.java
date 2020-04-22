package com.qianlq.producer.service;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-21
 */

public interface ActiveService {

    /**
     * 发送消息到队列
     *
     * @param title   消息标题
     * @param content 消息内容
     */
    void send2Queue(String title, String content);
}
