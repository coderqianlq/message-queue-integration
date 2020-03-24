package com.qianlq.consumer.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-14
 * @description 通过ConfigurationProperties读取yml配置
 */

@Configuration
@ConfigurationProperties(prefix = "mail")
public class MailConstant {

    private String from;

    public void setFrom(String from) {
        this.from = from;
    }

    public String getFrom() {
        return from;
    }
}
