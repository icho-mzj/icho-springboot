package com.icho.utils.rabbitMQDemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: icho
 * @Date: 2021/9/19 18:22
 * @Describe:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MqDemo {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void testSend() throws InterruptedException {
        String msg = "Hello,SpringBoot AMQP!";
        amqpTemplate.convertAndSend("icho.exchange", "a.b", msg);
        Thread.sleep(10000);
    }
}
