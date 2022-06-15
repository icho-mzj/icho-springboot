package com.icho.base;

/**
 * @Author: icho
 * @Date: 2022/6/12 16:38
 * @Describe:
 */
public class RegexRest {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        String str = "15632649612";
        String regex = "1[345678][0-9]{9}";
        System.out.println(str.matches(regex));
    }

}
