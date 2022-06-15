package com.icho.springsource.autowired;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;

/**
 * @Author: icho
 * @Date: 2022/6/15 9:53
 * @Describe:
 */
@ComponentScan(basePackages = {"com.icho.springsource.autowired"})
public class MainConfig {

    @Bean
    public DaoTest daoTest2() {
        DaoTest daoTest = new DaoTest();
        daoTest.setFlag(2);
        return daoTest;
    }

    //@Primary
    @Bean
    public DaoTest daoTest() {
        DaoTest daoTest = new DaoTest();
        daoTest.setFlag(1);
        return daoTest;
    }

    //@Bean(autowire = Autowire.BY_TYPE)
    @Bean(autowire = Autowire.BY_NAME)
    public ServiceTest serviceTest() {
        return new ServiceTest();
    }

}
