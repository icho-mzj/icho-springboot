package com.icho.springsource.applicationlistenerTest;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Author: icho
 * @Date: 2022/6/15 19:16
 * @Describe:
 */
@Component
public class ApplicationListenerTest implements ApplicationListener { // 多波器,回调
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("ApplicationListenerTest接收到了一个事件" + event);
    }
}
