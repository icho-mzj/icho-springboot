package com.icho.base.ClassLoadSequence;

/**
 * @Author: icho
 * @Date: 2022/4/29 19:10
 * @Describe:
 */
public class Car_1 {
    private static String color = "绿色";
    private String brand;

     static {
         System.out.println("---静态代码块初始化");
    }

    {
        System.out.println("---代码块初始化");
    }

    private static String name;

    public Car_1() {
        System.out.println("---构造函数初始化");
        this.color = "黑色";
        this.brand = "奥迪";
    }

    public Car_1(String color, String brand) {
        this.color = color;
        this.brand = brand;
    }

    public String getColor() {
        return this.color;
    }

    public String getBrand() {
        return this.brand;
    }
}
