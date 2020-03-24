package com.qianlq.core.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author coderqian
 * @date 2019-09-22 20:10
 * @since v1.0
 */

@ApiModel("邮件传输实体")
public class MailDTO implements Serializable {

    private static final long serialVersionUID = 8888208961878772691L;

    @ApiModelProperty("邮件接收人")
    private String to;

    @ApiModelProperty("邮件主题")
    private String subject;

    @ApiModelProperty("邮件内容")
    private String content;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MailDTO{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
