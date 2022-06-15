package com.icho.springsource.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @Author: icho
 * @Date: 2022/6/15 9:56
 * @Describe:
 */
@Service
public class BaiDuServiceTest {

    @Qualifier(value = "DaoTest")
    @Autowired(required = false) // 有就装配,无则不装配
    private DaoTest daoTest2;

    @Override
    public String toString() {
        return "BaiDuServiceTest{ daoTest2=" + daoTest2 + " }";
    }
}
