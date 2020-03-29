package com.qianlq.producer.kafka;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author qianliqing
 * @version v1.0
 * @date 2020-03-28
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaTest.class)
@EmbeddedKafka(count = 4, ports = {9092, 9093, 9094, 9095})
public class KafkaTest {

}
