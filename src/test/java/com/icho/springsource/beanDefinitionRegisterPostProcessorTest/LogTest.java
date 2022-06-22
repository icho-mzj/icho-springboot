package com.icho.springsource.beanDefinitionRegisterPostProcessorTest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: icho
 * @Date: 2022/6/15 19:51
 * @Describe:
 */
@Component
public class LogTest {

    @Value("1")
    private int flag;

    public LogTest() {
        System.out.println("LogTest的构造方法");
    }

    @Override
    public String toString() {
        return "LogTest{" +
                "flag=" + flag +
                '}';
    }
}
