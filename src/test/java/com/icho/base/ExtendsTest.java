package com.icho.base;

import com.sun.deploy.uitoolkit.impl.fx.AppletStageManager;

import java.io.IOException;

/**
 * @Author: icho
 * @Date: 2022/5/8 20:49
 * @Describe:
 */
public class ExtendsTest {

    public static void main(String[] args) {
        //test03();
        Animal animal = new Animal();
        Animal dog = new Dog();
        Dog dog1 = (Dog) dog;
        System.out.println("dog1 = " + dog1);
    }

    private static void test03() {
        Animal a = new Dog();
    }

    private static void test02() {
        /*System.out.println("------SubClass 类继承------");
        SubClass sc1 = new SubClass();
        SubClass sc2 = new SubClass(100);
        System.out.println("------SubClass2 类继承------");
        SubClass2 sc3 = new SubClass2();
        SubClass2 sc4 = new SubClass2(200);*/

        SubClass subClass = new SubClass();
        subClass.method1();
    }

    private static void test01() {
        Dog dog = new Dog();
        dog.eat();
    }
}

/* 02 */
class SuperClass {
    private int n;
    SuperClass(){
        System.out.println("SuperClass()");
    }
    SuperClass(int n) {
        System.out.println("SuperClass(int n)");
        this.n = n;
    }

    public void method1() {
        System.out.println("this is method1");
    }
}
// SubClass 类继承
class SubClass extends SuperClass{
    private int n;

    SubClass(){ // 自动调用父类的无参数构造器
        System.out.println("SubClass");
    }

    public SubClass(int n){
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass(int n):"+n);
        this.n = n;
    }

    /*public void method1() {
        System.out.println("this is method1 by SubClass");
    }*/
}
// SubClass2 类继承
class SubClass2 extends SuperClass {
    private int n;

    SubClass2() {
        super(300);  // 调用父类中带有参数的构造器
        System.out.println("SubClass2");
    }

    public SubClass2(int n) { // 自动调用父类的无参数构造器
        System.out.println("SubClass2(int n):" + n);
        this.n = n;
    }
}


/*
01
子类不可抛出超出父类异常范围的异常
*/
class Animal {
    public String name = "动物";
    void eat() throws IOException {
        System.out.println("animal : eat");
    }

    static void bark() {
        System.out.println("animal : bark");
    }
}

class Dog extends Animal {
    void eat() /*throws Exception*/ {
        System.out.println(super.name);
        System.out.println("dog : eat");
    }
    void eatTest() {
        this.eat();   // this 调用自己的方法
        //super.eat();  // super 调用父类方法
    }

    // 无法重写父类的static,final方法
    /*void bark() {
        System.out.println("animal : bark");
    }*/
}