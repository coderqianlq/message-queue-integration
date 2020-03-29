package com.qianlq.producer.controller;

import com.qianlq.producer.model.vo.MailParamVO;
import com.qianlq.producer.service.MailService;
import com.qianlq.producer.service.RabbitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-22
 */

@RestController
@RequestMapping(value = "/test")
@Api(value = "发送消息", tags = {"发送消息模块"})
public class RabbitController {

    private MailService mailService;

    private RabbitService rabbitService;

    public RabbitController(MailService mailService, RabbitService rabbitService) {
        this.mailService = mailService;
        this.rabbitService = rabbitService;
    }

    @PostMapping(value = "/{message}")
    @ApiOperation(value = "发送指定字符串到direct队列", notes = "发送指定字符串到direct队列")
    public void sendString(@ApiParam(value = "message", required = true) @PathVariable String message) {
        rabbitService.send(message);
    }

    @PostMapping(value = "/mail")
    @ApiOperation(value = "异步发送邮件", notes = "异步发送邮件")
    public void sendMail(@RequestBody MailParamVO mpr) {
        mailService.sendMail(mpr.getTo(), mpr.getSubject(), mpr.getContent());
    }
}
