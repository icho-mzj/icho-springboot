package com.icho.springsource.factoryBeanTest;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: icho
 * @Date: 2022/6/14 20:20
 * @Describe:
 */
public class CarFactoryBean implements FactoryBean<Car> {

    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    // 指定类型
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    // 指定类型为单例
    @Override
    public boolean isSingleton() {
        return false;
    }
}
