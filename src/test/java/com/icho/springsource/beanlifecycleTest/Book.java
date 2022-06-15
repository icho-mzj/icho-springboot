package com.icho.springsource.beanlifecycleTest;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:32
 * @Describe:
 */
//@Component
public class Book { // 初始化和销毁方法 JSR250规范
    public Book() {
        System.out.println("Book的构造方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("Book的PostConstruct方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Book的PreDestroy方法");
    }
}
