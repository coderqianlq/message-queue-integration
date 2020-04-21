package com.qianlq.producer.scheduler;

import com.qianlq.producer.demo.ActiveProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-21
 */

@Component
public class ProducerScheduler {

    private static final String PATTERN = "yyyy-MM-dd hh:mm:ss";

    private ActiveProducer activeProducer;

    public ProducerScheduler(ActiveProducer activeProducer) {
        this.activeProducer = activeProducer;
    }

    @Scheduled(cron = "5 * * * * ?")
    public void produce() {
        activeProducer.send2Queue(LocalDateTime.now().format(DateTimeFormatter.ofPattern(PATTERN)));
    }
}
