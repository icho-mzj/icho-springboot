package com.icho.springsource.beanlifecycleTest;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:33
 * @Describe:
 */
//@Component
public class Person implements InitializingBean, DisposableBean { // 初始化和销毁方法

    public Person() {
        System.out.println("Person的构造方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Person的destroy()方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Person的afterPropertiesSet()方法");
    }
}
