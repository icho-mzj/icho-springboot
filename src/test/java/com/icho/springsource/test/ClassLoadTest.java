package com.icho.springsource.test;

/**
 * @Author: icho
 * @Date: 2022/6/16 9:27
 * @Describe:
 */
public class ClassLoadTest {

    public static void main(String[] args) {
        Son son = new Son();
    }
}

class Father {

    static {
        System.out.println("Father的静态代码块");
    }

    private String fatherName = "Icho";
    private static String fatherAge = "28";
    {
        System.out.println("Father的代码块");
    }

    private String fatherHobby;

    public Father() {
        System.out.println("Father的构造方法");
    }

    @Override
    public String toString() {
        return "Father{" +
                "fatherName='" + fatherName + '\'' +
                ", fatherHobby='" + fatherHobby + '\'' +
                '}';
    }
}

class Son extends Father {

    static {
        System.out.println("Son的静态代码块");
    }

    {
        System.out.println("Son的代码块");
    }

    private static String sonAge = "1";
    private String sonName = "Minna";
    private String sonHobby;
    public Son() {
        System.out.println("Son的构造方法");
    }

    @Override
    public String toString() {
        return "Son{" +
                "sonName='" + sonName + '\'' +
                ", sonHobby='" + sonHobby + '\'' +
                '}';
    }
}
