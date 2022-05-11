package com.icho.base;

/**
 * @Author: icho
 * @Date: 2022/5/3 2:25
 * @Describe:
 */
public class VolatileTest implements Runnable {

    private volatile boolean active; // 将变量声明为
    public void run()
    {
        active = true;
        while (active) // 第一行
        {
            // 代码
        }
    }
    public void stop()
    {
        active = false; // 第二行
    }
}
