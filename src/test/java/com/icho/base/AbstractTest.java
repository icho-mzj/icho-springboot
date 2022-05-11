package com.icho.base;

/**
 * @Author: icho
 * @Date: 2022/5/3 2:21
 * @Describe:
 */
public class AbstractTest {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {

    }
}

interface Alarm {
    void alarm();
}

abstract class Door {
    abstract void open();
    abstract void close();
}

class AlarmDoor extends Door implements Alarm {

    @Override
    void open() {
    }

    @Override
    void close() {
    }

    @Override
    public void alarm() {
    }
}