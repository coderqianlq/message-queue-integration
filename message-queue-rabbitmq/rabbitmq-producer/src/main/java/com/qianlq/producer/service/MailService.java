package com.qianlq.producer.service;

/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-22
 */

public interface MailService {

    /**
     * 发送邮件
     *
     * @param to      邮件接收人
     * @param subject 邮件主题
     * @param content 邮件内容
     */
    void sendMail(String to, String subject, String content);
}
