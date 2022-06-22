package com.icho.springsource.createbeaninstanceTest;

/**
 * @Author: icho
 * @Date: 2022/6/19 21:35
 * @Describe:
 */
public class AspectTest {

    private LogTest logTest;

    public AspectTest(LogTest logTest) {
        this.logTest = logTest;
    }

    public AspectTest() {
    }

    public LogTest getLogTest() {
        return logTest;
    }

    public void setLogTest(LogTest logTest) {
        this.logTest = logTest;
    }
}
