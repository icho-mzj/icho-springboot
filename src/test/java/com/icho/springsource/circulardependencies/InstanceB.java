package com.icho.springsource.circulardependencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: icho
 * @Date: 2022/6/19 22:01
 * @Describe:
 */
@Component
public class InstanceB {
    @Autowired
    private InstanceA instanceA;

    public InstanceA getInstanceA() {
        return instanceA;
    }

    @Autowired
    public void setInstanceA(InstanceA instanceA) {
        this.instanceA = instanceA;
    }
}
