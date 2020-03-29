package com.qianlq.producer.controller;

import com.qianlq.producer.service.KafkaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-03-24
 * @description kafka控制层
 */

@RestController
@RequestMapping(value = "/test")
@Api(value = "发送消息", tags = {"发送消息模块"})
public class KafkaController {

    private KafkaService kafkaService;

    public KafkaController(KafkaService kafkaService) {
        this.kafkaService = kafkaService;
    }

    @PostMapping(value = "/{message}")
    @ApiOperation(value = "发送字符串到topic-test", notes = "发送字符串到topic-test")
    public void sendString(@ApiParam(value = "message", required = true) @PathVariable String message) {
        kafkaService.send(message);
    }
}
