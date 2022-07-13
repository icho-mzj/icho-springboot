package com.icho.springsource.calTest;

import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

/**
 * @Author: icho
 * @Date: 2022/6/20 19:32
 * @Describe:
 */
@Component
public class CalculateTest implements Calculate{

    @Override
    public int add(int numA, int numB) {
        System.out.println("执行目标方法:add");
        //System.out.println(1/0);
        return numA + numB;
    }

    @Override
    public int reduce(int numA, int numB) {
        System.out.println("执行目标方法:reduce");
        return numA - numB;
    }

    @Override
    public int div(int numA, int numB) {
        System.out.println("执行目标方法:div");
        return numA / numB;
    }

    @Override
    public int multi(int numA, int numB) {
        System.out.println("执行目标方法:multi");
        return numA * numB;
    }

    @Override
    public int mod(int numA, int numB) {
        System.out.println("执行目标方法:mod");
        //return numA % numB;

        //int retVal = ((Calculate) AopContext.currentProxy()).add(numA, numB); // 底层是一个缓存的threadlocal对象,缓存了当前的代理对象;代理对象调用
        //int retVal = this.add(numA, numB);

        return numA % numB;
    }
}
