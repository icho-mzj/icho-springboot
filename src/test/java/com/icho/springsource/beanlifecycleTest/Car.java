package com.icho.springsource.beanlifecycleTest;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:33
 * @Describe:
 */
public class Car {
    public Car() {
        System.out.println("Car的构造方法");
    }

    public void init() {
        System.out.println("Car的初始化方法...init");
    }

    public void destroy() {
        System.out.println("Car的初始化方法...destroy");
    }
}
