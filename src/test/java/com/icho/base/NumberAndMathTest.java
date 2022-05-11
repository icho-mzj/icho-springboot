package com.icho.base;

/**
 * @Author: icho
 * @Date: 2022/5/3 17:25
 * @Describe:
 */
public class NumberAndMathTest {

    public static void main(String[] args) {
        test08();
    }

    /*
    非 new 生成的 Integer 变量指向的是 java 常量池中的对象，
    而 new Integer() 生成的变量指向堆中新建的对象，两者在内存中的地址不同。所以输出为 false
    */

    /*
    包装类 Integer 变量在与基本数据类型 int 变量比较时，
    Integer 会自动拆包装为 int，然后进行比较，实际上就是两个 int 变量进行比较，值相等，所以为 true
    */

    public static void test08() {
        // Java 会对 -128 ~ 127 的整数进行缓存，所以当定义两个变量初始化值位于 -128 ~ 127 之间时，两个变量使用了同一地址
        // 当两个 Integer 变量的数值超出 -128 ~ 127 范围时, 变量使用了不同地址
        // 128,130
        Integer i1 = 130;
        Integer i2 = 130; // 对象

        /*
        == 它比较的是对象的地址
        equals 比较的是对象的内容
        */
        if(i1==i2) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void test07() {
        Integer i1 = 128;  // 装箱，相当于 Integer.valueOf(128);
        int t = i1; //相当于 i1.intValue() 拆箱
        System.out.println(t);
    }

    // xxxValue()
    public static void test01() {
        Integer x = 5;
        System.out.println(x.byteValue());
        System.out.println(x.doubleValue());
        System.out.println(x.longValue());
    }


    /*
    compareTo()
    如果指定的数与参数相等返回 0。
    如果指定的数小于参数返回 -1。
    如果指定的数大于参数返回 1。
    * */
    public static void test02() {
        Integer x = 5;
        System.out.println(x.compareTo(3));
        System.out.println(x.compareTo(5));
        System.out.println(x.compareTo(8));
    }

    /*
    valueOf()
    返回给定参数的原生 Number 对象值
    */
    public static void test03() {
        Integer x =Integer.valueOf(9);
        Double c = Double.valueOf(5);
        Float a = Float.valueOf("80");

        Integer b = Integer.valueOf("444",16);   // 使用 16 进制

        System.out.println(x);
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
    }

    // toString
    public static void test04() {
        Integer x = 5;

        System.out.println(x.toString());
        System.out.println(Integer.toString(12));
    }

    // round()
    // Math.floor(x+0.5) ，即将原来的数字加上 0.5 后再向下取整
    public static void test05() {
        float c = -100.6f;
        double d = -100.675;
        double e = 100.500;
        float f = 100;
        float g = 90f;
        float h = 11.5f;
        float i = -11.5f;

        System.out.println(Math.round(c));
        System.out.println(Math.round(d));
        System.out.println(Math.round(e));
        System.out.println(Math.round(f));
        System.out.println(Math.round(g));
        System.out.println(Math.round(h));
        System.out.println(Math.round(i));
    }

    // Math 的 floor,round 和 ceil 方法实例比较
    /*
    Math.floor 是向下取整。
    Math.ceil 是向上取整。
    Math.round 是四舍五入取整 但是需要注意的是：
    1、参数的小数点后第一位小于 5，运算结果为参数整数部分。
    2、参数的小数点后第一位大于 5，运算结果为参数整数部分绝对值 +1，符号（即正负）不变。
    3、参数的小数点后第一位等于 5，正数运算结果为整数部分 +1，负数运算结果为整数部分。
    */
    public static void test06() {
        double[] nums = {1.4, 1.5, 1.6, -1.4, -1.5, -1.6};
        for (double num : nums) {
            System.out.println("Math.floor(" + num + ")=" + Math.floor(num)); // 返回小于等于（<=）给定参数的最大整数 。
            System.out.println("Math.round(" + num + ")=" + Math.round(num)); // 它表示四舍五入，算法为 Math.floor(x+0.5)，即将原来的数字加上 0.5 后再向下取整
            System.out.println("Math.ceil(" + num + ")=" + Math.ceil(num)); // 返回大于等于( >= )给定参数的的最小整数
        }
    }

}
