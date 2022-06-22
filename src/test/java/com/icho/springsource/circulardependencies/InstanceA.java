package com.icho.springsource.circulardependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: icho
 * @Date: 2022/6/19 22:01
 * @Describe:
 */
@Component
public class InstanceA {

    @Autowired
    private InstanceB instanceB;

    public InstanceB getInstanceB() {
        return instanceB;
    }

    @Autowired
    public void setInstanceB(InstanceB instanceB) {
        this.instanceB = instanceB;
    }
}
