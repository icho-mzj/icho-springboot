package com.icho.base;

import java.io.Console;
import java.util.Scanner;

/**
 * @Author: icho
 * @Date: 2022/5/6 20:12
 * @Describe:
 */
public class ScannerTest {

    public static void main(String[] args) {
        test02();
    }

    // nextLine()方法返回的是输入回车之前的所有字符
    private static void test02() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nextLine方式接收：");
        if (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            System.out.println("输入的数据为：" + nextLine);
        }
        scanner.close();
    }

    private static void test01() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("next方式接收：");
        if (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println("输入的数据为：" + next);
        }
        scanner.close();
    }

}
