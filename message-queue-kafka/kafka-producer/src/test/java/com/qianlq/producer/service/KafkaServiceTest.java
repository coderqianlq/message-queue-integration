package com.qianlq.producer.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-07
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class KafkaServiceTest {

    @Autowired
    private KafkaService kafkaService;

    @Test
    public void testSend() {
        kafkaService.send("Test case.");
    }
}
