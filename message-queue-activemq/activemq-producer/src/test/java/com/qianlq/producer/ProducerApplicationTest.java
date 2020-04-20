package com.qianlq.producer;

import com.qianlq.producer.demo.ActiveProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-04-20
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerApplicationTest {

    @Autowired
    private ActiveProducer activeProducer;

    @Test
    public void testSend2Queue() {
        activeProducer.send2Queue(LocalDate.now().toString());
    }

    @Test
    public void testSend2Topic() {
        activeProducer.send2Topic(LocalDate.now().toString());
    }
}
