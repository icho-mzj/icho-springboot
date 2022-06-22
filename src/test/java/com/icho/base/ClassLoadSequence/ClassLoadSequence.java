package com.icho.base.ClassLoadSequence;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @Author: icho
 * @Date: 2022/4/29 19:09
 * @Describe:
 */
public class ClassLoadSequence {

    // private final String str;
    private final String str = "111";
    private final Integer num1 = 1;

    public static void main(String[] args) {
        short a = 1;
        //System.out.println(a=a+1);
        a+=1;
        short a1 = a;
        System.out.println(a1);
    }

    private static void test04() {
        Subparent subparent = new Subparent();
        subparent.method1();
        subparent.method3();
    }

    private static void test01() {
        //Car_1 c = new Car_1();
        Car_1 c1 = new Car_1("红色", "福克斯");
        //System.out.println("c = " + c);
        System.out.println("c1 = " + c1);
    }

    /*
    父类静态代码块,静态变量 -> 子类静态代码块,静态变量 -> 父类代码块,成员变量 -> 父类构造方法 -> 子类代码块,成员变量 -> 子类构造方法
    */
    private static void test02() {
        Subtine subtine = new Subtine();
    }

    // 局部变量没有默认值,必须先初始化
    private static void test03() {
        /*short a;
        System.out.println("a = " + a);*/
    }


    private static int staticInt = 2; // 无论创建多少个实例对象,都只会分配一个静态变量
    private int random = 2; // 每创建一个实例对象,就会分配一个成员变量
    private ClassLoadSequence() {
        staticInt++;
        random++;
        System.out.println("staticInt = " + staticInt);
        System.out.println("random = " + random);
        System.out.println("--------------------");
    }


}

class A {
    public static  String  staticA ="A" ;
    //静态语句块修改值
    static{
        staticA ="A1";
        System.out.println("A1");
    }
    //构造器修改值
    public A (){
        staticA ="A2";
        System.out.println("A2");
    }
    //静态方法起作用

    public static void toChange(){
        staticA ="A3";
        System.out.println("A3");
    }
    public void toChange2(){
        staticA ="A4";
        System.out.println("A4");
    }

    public static void main(String[] args) {
        //System.out.println(A.staticA);
        /*A a = new A();
        System.out.println("a = " + a);*/
        A a = new A();
        a.toChange2();
        a.toChange();
    }
}

class B {
    public static final String  staticB ;  // 声明与赋值分离
    static{  staticB ="11111"; }

    public static void main(String[] args) {
        System.out.println(B.staticB);
    }
}
