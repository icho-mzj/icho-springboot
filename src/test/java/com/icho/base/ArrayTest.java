package com.icho.base;

import java.util.Arrays;

/**
 * @Author: icho
 * @Date: 2022/5/3 23:40
 * @Describe:
 */
public class ArrayTest {

    public static void main(String[] args) {
        test04();
    }

    private static void test04() {
        String[] strs = {"1","4","2","6","3"};
        Arrays.sort(strs);
        System.out.println("strs = " + Arrays.toString(strs));
    }

    private static void test03() {
        String[] strs = new String[10];
        Arrays.fill(strs,"-");
        System.out.println(Arrays.toString(strs));
    }

    public static void test02() {
        String[] strs = {"1","2","3"};
        int i = Arrays.binarySearch(strs, "8");
        System.out.println("i = " + i);
    }

    public static void test01() {
        String[][] s = new String[2][];
        s[0] = new String[2];
        s[1] = new String[3];
        s[0][0] = new String("Good");
        s[0][1] = new String("Luck");
        s[1][0] = new String("to");
        s[1][1] = new String("you");
        s[1][2] = new String("!");
        System.out.println("s = " + Arrays.deepToString(s));
    }
}
