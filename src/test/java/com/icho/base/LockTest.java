package com.icho.base;

import io.netty.channel.Channel;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author: icho
 * @Date: 2022/6/4 23:20
 * @Describe:
 */
public class LockTest {

    public static void main(String[] args) {
        test02();
    }

    private static void test02() {

    }

    // unsafe
    volatile long state = 0;// 变量
    static Unsafe unsafe;
    static long stateOffset;// 记录变量state在类UnSafeDemo类中的偏移值
    static {
        try {
            Field field;
            // 使用反射获取unsafe类的成员变量
            field = Unsafe.class.getDeclaredField("theUnsafe");
            // 设置为可存取
            field.setAccessible(true);
            // 设置该变量的值
            unsafe = (Unsafe) field.get(null);
            // 获取state在UnsafeDemo中的偏移量
            stateOffset = unsafe.objectFieldOffset(LockTest.class.getDeclaredField("state"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private static void test01() {
        int i = 0;
        int j = 1;
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        LockTest l = new LockTest();
        System.out.println("before CAS:" + l.state);

        // 读取传入对象在内存中偏移量为offset位置的值与期望值expected作比较。
        boolean b = unsafe.compareAndSwapInt(
                l, // object: 将要修改的值的对象
                stateOffset, // 要修改的数据的值在内存中的偏移量
                i, // 期望内存中的值
                j // 修改后的值
        );

        System.out.println("b = " + b);
        System.out.println("after CAS:"+l.state);
        System.out.println("i = " + i);
        System.out.println("j = " + j);
    }
}
