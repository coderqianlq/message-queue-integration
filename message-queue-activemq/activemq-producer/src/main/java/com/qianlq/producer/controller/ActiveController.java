package com.qianlq.producer.controller;

import com.qianlq.producer.service.ActiveService;
import org.springframework.web.bind.annotation.*;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-21
 */

@RestController
@RequestMapping(value = "/test")
public class ActiveController {

    private ActiveService activeService;

    public ActiveController(ActiveService activeService) {
        this.activeService = activeService;
    }

    @PostMapping(value = "/send")
    public void send2Queue(@RequestParam(value = "title") String title, @RequestParam(value = "content") String content) {
        activeService.send2Queue(title, content);
    }

}
