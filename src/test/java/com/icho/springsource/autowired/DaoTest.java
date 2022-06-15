package com.icho.springsource.autowired;

/**
 * @Author: icho
 * @Date: 2022/6/15 9:51
 * @Describe:
 */
public class DaoTest {
    private int flag = 1;
    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "DaoTest{ falg=" + flag + " }";
    }
}
