package com.icho.base;

/**
 * @Author: icho
 * @Date: 2022/5/3 2:15
 * @Describe:
 */
public class InstanceCounter {
    private static int numInstances = 1;
    protected static int getCount() {
        return numInstances;
    }

    private static void addInstance() {
        numInstances++;
    }

    InstanceCounter() {
        InstanceCounter.addInstance();
    }

    public static void main(String[] arguments) {
        System.out.println("Starting with " +
                InstanceCounter.getCount() + " instances");
        for (int i = 0; i < 5; ++i){
            System.out.println("i = " + i);
            new InstanceCounter();
        }
        System.out.println("Created " +
                InstanceCounter.getCount() + " instances");
    }
}
