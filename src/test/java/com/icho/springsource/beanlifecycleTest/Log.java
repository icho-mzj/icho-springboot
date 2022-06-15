package com.icho.springsource.beanlifecycleTest;

import org.springframework.beans.factory.InitializingBean;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:33
 * @Describe:
 */
public class Log implements InitializingBean { // 属性的校验or属性的拷贝
    public Log() {
        System.out.println("Log的构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Log的afterPropertiesSet方法");
    }

    public void init() {
        System.out.println("Log的初始化方法...init");
    }

    public void destroy() {
        System.out.println("Log的初始化方法...destroy");
    }
}
