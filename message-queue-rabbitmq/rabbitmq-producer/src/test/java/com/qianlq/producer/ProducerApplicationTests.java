package com.qianlq.producer;

import com.qianlq.producer.demo.RabbitProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author coderqian
 * @version v1.0
 * @date 2019-09-07
 */

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerApplicationTests {

    private static final String PATTERN = "YYYY-mm-DD hh:MM:ss";

    private String message;

    @Autowired
    private RabbitProducer producer;

    {
        Date date = new Date();
        message = new SimpleDateFormat(PATTERN).format(date);
    }

    @Test
    public void testDirectSend() {
        for (int i = 0; i < 10; i++) {
            producer.directSend(message);
        }
    }

    @Test
    public void testTopicSend() {
        producer.topicSend(message);

        producer.topicSend("topic.a", "[topic.a] send message: " + message);

        producer.topicSend("topic.b", "[topic.b] send message: " + message);
    }

    @Test
    public void testFanoutSend() {
        producer.fanoutSend(message);
    }

    @Test
    public void testHeadersSend() {
        Map<String, Object> map = new HashMap<>();
        map.put("First", "A");
        producer.headersSend("hello world!", map);

        map.clear();
        map.put("Second", "B");
        producer.headersSend("sorry!", map);
    }
}
