package com.icho.base;

/**
 * @Author: icho
 * @Date: 2022/5/11 18:44
 * @Describe:
 */
public class InterFaceTest1 implements InterfaceTest {

    /*@Override
    public void test01() {
        System.out.println("interface default method");
    }*/

    public static void main(String[] args) {
        InterFaceTest1 interFaceTest = new InterFaceTest1();
        interFaceTest.test01();
    }


}

interface InterfaceTest{
    default void test01() {
        System.out.println("interface default method");
    }

    static void test02() {
        System.out.println("interface default static method");
    }
}
