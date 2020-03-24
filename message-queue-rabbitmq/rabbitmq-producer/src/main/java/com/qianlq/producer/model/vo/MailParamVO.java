package com.qianlq.producer.model.vo;

import com.qianlq.producer.constant.RegexConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Pattern;

/**
 * @author coderqian
 * @date 2019-09-22 19:10
 * @since v1.0
 */

@ApiModel("邮件参数实体")
public class MailParamVO {

    @ApiModelProperty("邮件接收人")
    @Pattern(regexp = RegexConstant.MAIL_FORMAT, message = RegexConstant.MAIL_FORMAT_ERROR)
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
        return "MailParamVO{" +
                "to='" + to + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
