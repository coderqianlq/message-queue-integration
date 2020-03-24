package com.qianlq.producer.scheduler;

import com.qianlq.producer.demo.RabbitProducer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-07
 */

@Component
public class ProducerScheduler {

    private static final String PATTERN = "YYYY-mm-DD hh:MM:ss";

    private RabbitProducer rabbitProducer;

    public ProducerScheduler(RabbitProducer rabbitProducer) {
        this.rabbitProducer = rabbitProducer;
    }

    @Scheduled(cron = "5 * * * * ?")
    public void produce() {
        rabbitProducer.directSend(new SimpleDateFormat(PATTERN).format(new Date()));
    }
}
