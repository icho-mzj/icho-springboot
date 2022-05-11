package com.icho.base.ClassLoadSequence;

/**
 * @Author: icho
 * @Date: 2022/5/3 21:14
 * @Describe:
 */
public class StringBufferAndStringBuilder {

    public static void main(String[] args) {
        // java 中常量优化机制，编译时 s1 已经成为 abc 在常量池中查找创建，s2 不需要再创建.
        /*String s1="a"+"b"+"c";
        String s2="abc";
        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));*/

        /*String s1="ab";
        String s2="abc";
        String s3=s1+"c";
        System.out.println(s3==s2);         // false
        System.out.println(s3.equals(s2));  // true*/

        String a = "a";
        String b = "b";
        String c = a + b;


        /*
        "a" + "b"

        a = "a"
        a + "b" -> new StringBuilder().append()
        */
    }

    /*
     StringBuilder 的方法不是线程安全的（不能同步访问）
     StringBuffer  的方法是线程安全的

     从 jdk1.5 开始,java 编译器会隐式的替换成 stringbuilder; 但在有循环的情况下，编译器没法做到足够智能的替换
    */

    public static void test02() {
        StringBuilder sb = new StringBuilder("Java");
        System.out.println(sb.reverse());
        System.out.println(sb.delete(0, 1));
        System.out.println(sb.insert(0,"a"));
        System.out.println(sb.replace(0,1,"b"));
    }

    public static void test01() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("Runoob..");
        System.out.println(sb);
        sb.append("!");
        System.out.println(sb);
        sb.insert(8, "Java");
        System.out.println(sb);
        sb.delete(5,8);
        System.out.println(sb);
    }
}
