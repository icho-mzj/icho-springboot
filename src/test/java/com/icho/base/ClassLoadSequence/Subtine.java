package com.icho.base.ClassLoadSequence;

/**
 * @Author: icho
 * @Date: 2022/4/29 21:32
 * @Describe:
 */
public class Subtine extends Subparent {
    private static String color = "Subtine,绿色";
    private String brand;
    static {
        System.out.println("---Subtine,静态代码块初始化");
    }

    {
        System.out.println("---Subtine,代码块初始化");
    }
    Subtine() {
        System.out.println("---调用子类Subtine构造方法");
    }
}
