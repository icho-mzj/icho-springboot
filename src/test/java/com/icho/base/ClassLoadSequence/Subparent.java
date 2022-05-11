package com.icho.base.ClassLoadSequence;

import lombok.Data;

/**
 * @Author: icho
 * @Date: 2022/4/29 21:31
 * @Describe:
 */
@Data
public class Subparent extends Parent {
    private static String color = "Subparent,绿色";
    private String brand;
    static {
        System.out.println("---Subparent,静态代码块初始化");
    }

    {
        System.out.println("---Subparent,代码块初始化");
    }

    Subparent() {
        System.out.println("---调用子类Subparent构造方法");
    }
}
