package com.qianlq.producer.service;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author coderqian
 * @version v1.0
 * @date 2020-04-07
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    private String To;

    private String Subject;

    private String Content;

    {
        To = "1242202279@qq.com";
        Subject = "测试邮件标题";
        Content = "测试邮件内容";
    }

    @Autowired
    private MailService mailService;

    @BeforeClass
    public static void setUp() {
        System.out.println("do something before @Test.");
    }

    @Test
    public void testSendMail() {
        mailService.sendMail(To, Subject, Content);
    }
}
