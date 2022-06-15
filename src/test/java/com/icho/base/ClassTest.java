package com.icho.base;

import com.icho.bean.Users;
import lombok.SneakyThrows;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: icho
 * @Date: 2022/6/12 17:26
 * @Describe:
 */
public class ClassTest {

    public static void main(String[] args) throws Exception {
        test05();
    }

    // 反射获取成员方法
    private static void test05() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> clazz = Class.forName("com.icho.base.CollectionsTest");
        Method method = clazz.getDeclaredMethod("test07");
        method.setAccessible(true);
        Object o = method.invoke(clazz.newInstance());

    }

    // 反射获取成员变量
    private static void test04() throws Exception {
        Users user = new Users(1, "Icho", "123");

        Class<?> clazz = Class.forName("com.icho.bean.Users");

        // 根据变量名获取指定成员变量
        Field f = clazz.getDeclaredField("username");
        System.out.println("f = " + f);
        f.setAccessible(true);
        String s1 = (String) f.get(user);
        System.out.println("s1 = " + s1);

        f.set(user, "Minna");
        String s2 = (String) f.get(user);
        System.out.println("s2 = " + s2);
    }

    @SneakyThrows
    private static void test03() {
        // 反射获取构造函数
        Class clazz = Class.forName("java.io.File");
        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        System.out.println("constructor = " + constructor);
        File file = (File) constructor.newInstance("E:\\学习\\就业班\\JAVASE\\基础加强_反射&动态代理\\out.txt");
        System.out.println(file.getAbsolutePath());
    }

    private static void test02() {
        Class clazz1 = int.class;
        System.out.println("clazz1.getName() = " + clazz1.getName());
        System.out.println("clazz1.getSimpleName() = " + clazz1.getSimpleName());
    }

    @SneakyThrows
    private static void test01() {
        // 1.类名.class
        Class clazz1 = String.class;
        System.out.println("clazz1.getName() = " + clazz1.getName()); // 全名
        System.out.println("clazz1.getSimpleName() = " + clazz1.getSimpleName()); // 类名
        System.out.println();

        // 2.对象.Class()
        Class clazz2 = "Icho".getClass();
        System.out.println("clazz2.getName() = " + clazz2.getName());
        System.out.println("clazz2.getSimpleName() = " + clazz2.getSimpleName());
        System.out.println();

        // 3.Class.foeName()
        Class clazz3 = Class.forName("java.lang.String");
        System.out.println("clazz3.getName() = " + clazz3.getName());
        System.out.println("clazz3.getSimpleName() = " + clazz3.getSimpleName());
        System.out.println();

        System.out.println(clazz1 == clazz2);
        System.out.println(clazz1 == clazz3);
        System.out.println(clazz2 == clazz3);
    }


}
