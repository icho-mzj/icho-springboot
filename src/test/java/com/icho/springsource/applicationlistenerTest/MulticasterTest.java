package com.icho.springsource.applicationlistenerTest;

import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;

/**
 * @Author: icho
 * @Date: 2022/6/16 20:15
 * @Describe:
 */
@Component(value = "applicationEventMulticaster")
public class MulticasterTest extends SimpleApplicationEventMulticaster {

    public MulticasterTest() {
        setTaskExecutor(Executors.newSingleThreadExecutor());
    }

}
