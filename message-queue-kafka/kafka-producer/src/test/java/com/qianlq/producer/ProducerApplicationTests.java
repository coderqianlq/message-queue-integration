package com.qianlq.producer;

import com.qianlq.producer.demo.KafkaProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-07
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProducerApplicationTests.class)
public class ProducerApplicationTests {

    private static final String PATTERN = "YYYY-mm-DD hh:MM:ss";

    private String message;

    @Autowired
    private KafkaProducer producer;

    {
        Date date = new Date();
        message = new SimpleDateFormat(PATTERN).format(date);
    }

    @Test
    public void testSend() {
        producer.send(message);
    }
}
