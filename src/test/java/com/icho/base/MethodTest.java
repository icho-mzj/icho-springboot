package com.icho.base;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: icho
 * @Date: 2022/5/5 20:17
 * @Describe:
 */
public class MethodTest {

    // 方法的参数范围涵盖整个方法。参数实际上是一个局部变量。

    public static void main(String[] args) { // 命令行参数
        test02();
        /*String[] places={"beijing","sahnghai","guanzhou"};
        MethodTest.main(places);*/
    }

    // // 引用类型指向相同地址值
    private static void test02() {
        List<String> list = Arrays.asList("1", "2", "3");
        System.out.println("list = " + list);
        System.out.println("start hashcode: "+list.hashCode());
        change(list);
        System.out.println("list = " + list);
        System.out.println("end hashcode: "+list.hashCode());
    }

    private static void change(List<String> list) {
        System.out.println("method hashcode start: "+list.hashCode());
        Collections.reverse(list);
        System.out.println("method hashcode end: "+list.hashCode());
    }

    // 方法被调用后，实参的值并没有改变。
    private static void test01() {
        int num1 = 1;
        int num2 = 2;

        System.out.println("交换前 num1 的值为：" +
                num1 + " ，num2 的值为：" + num2);

        // 调用swap方法
        swap(num1, num2);
        System.out.println("交换后 num1 的值为：" +
                num1 + " ，num2 的值为：" + num2);
    }

    /**
     * 交换两个变量的方法
     */
    public static void swap(int n1, int n2) {
        // 改变过后的参数只是swap方法里面的参数，并没有返回到main函数里
        // 局部变量作用域仅在方法中
        System.out.println("\t进入 swap 方法");
        System.out.println("\t\t交换前 n1 的值为：" + n1
                + "，n2 的值：" + n2);
        // 交换 n1 与 n2的值
        int temp = n1;
        n1 = n2;
        n2 = temp;

        System.out.println("\t\t交换后 n1 的值为 " + n1 + "，n2 的值：" + n2);
    }

    /*private static void test01(String s) {

    }

    private static void test01(String s) {

    }*/



    /**
     * 这两个test1方法不能重载，javac中编译也不行
     */
    public static void test1(List<Integer> list) {
        System.out.println("test1 Integer run");
    }

    /*public static void test1(List<String> list) {
        System.out.println("test1 String run");
    }*/

    /**
     * 这两个test2方法可以重载，只是jvm层面可以重载，但是IDEA或者EJC编译都会拒绝编译
     */
    public static Integer test2(List<Integer> list) {
        System.out.println("test1 Integer run");
        return 1;
    }

    /*public static String test2(List<String> list) {
        System.out.println("test1 String run");
        return "";
    }*/
}

class FinalizationDemo {
    public static void main(String[] args) {
        Cake c1 = new Cake(1);
        Cake c2 = new Cake(2);
        Cake c3 = new Cake(3);

        c1 = c2 = c3 = null;
        System.gc(); //调用Java垃圾收集器
    }
}

class Cake extends Object {
    private int id;
    public Cake(int id) {
        this.id = id;
        System.out.println("Cake Object " + id + "is created");
    }

    // 只保证方法会调用，但不保证方法里的任务会被执行完
    protected void finalize() throws java.lang.Throwable {
        super.finalize();
        System.out.println("Cake Object " + id + "is disposed");
    }
}
