package com.icho.utils.transaction;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: icho
 * @Date: 2021/9/19 19:27
 * @Describe:
 */
public class PropagationDemo {

    /*
    * 事务的7种传播行为
    * */
    @Transactional(propagation = Propagation.REQUIRED)
    public void demo() {
    }
}
