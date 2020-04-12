package com.qianlq.producer;

import com.qianlq.producer.demo.RocketProducer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-04-12
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerApplicationTests {

    @Autowired
    private RocketProducer rocketProducer;

    @Test
    public void test() {
        try {
            rocketProducer.send("Send Message.");
        } catch (UnsupportedEncodingException ue) {
            ue.printStackTrace();
        }
    }

}
