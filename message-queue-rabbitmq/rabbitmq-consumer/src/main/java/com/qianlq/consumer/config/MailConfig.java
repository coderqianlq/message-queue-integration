package com.qianlq.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-14
 * @description 读取多层自定义yml配置
 */

@Configuration
@ConfigurationProperties(prefix = "spring.mail")
@PropertySource(value = "classpath:application.yml", encoding = "utf-8")
public class MailConfig implements ApplicationListener<ApplicationEvent> {

    @Value("${username}")
    private String username;

    public String getUsername() {
        return username;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        // do something
    }
}
