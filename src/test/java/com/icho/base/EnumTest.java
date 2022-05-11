package com.icho.base;

/**
 * @Author: icho
 * @Date: 2022/5/11 19:06
 * @Describe:
 */
public class EnumTest {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        System.out.println(Color.valueOf("RED")); // 返回指定字符串值的枚举常量
        for (Color value : Color.values()) {
            System.out.println(value + " at index " +value.ordinal()); // 找到每个枚举常量的索引
        }
    }
}

enum Color {
    RED, GREEN, BLUE;
}
