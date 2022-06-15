package com.icho.springsource.autowired;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: icho
 * @Date: 2022/6/15 9:59
 * @Describe:
 */
public class ServiceTest {

    private DaoTest daoTest;

    public DaoTest getDaoTest() {
        return daoTest;
    }

    public void setDaoTest(DaoTest daoTest) {
        this.daoTest = daoTest;
    }

    @Override
    public String toString() {
        return "ServiceTest{ daoTest=" + daoTest + " }";
    }
}
