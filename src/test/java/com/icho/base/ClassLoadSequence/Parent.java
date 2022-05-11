package com.icho.base.ClassLoadSequence;

import lombok.Data;

/**
 * @Author: icho
 * @Date: 2022/4/29 21:29
 * @Describe:
 */
@Data
public class Parent {
    private static String color = "Parent,绿色";
    private String brand1;
    private String parentString;
    static {
        System.out.println("---Parent,静态代码块初始化");
    }

    {
        System.out.println("---Parent,代码块初始化");
    }

    Parent() {
        System.out.println("---调用父类Parent构造方法");
    }

    public void method1() {
        System.out.println("method1 is running");
    }

    private void method2() {
        System.out.println("method2 is running");
    }

    protected void method3() {
        System.out.println("method3 is running");
    }
}
