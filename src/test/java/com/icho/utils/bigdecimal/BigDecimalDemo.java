package com.icho.utils.bigdecimal;

import java.math.BigDecimal;

/**
 * @Author: icho
 * @Date: 2021/10/19 18:53
 * @Describe:
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal bigDecimal = getNegativeVal(new BigDecimal("123.456"));
        System.out.println(bigDecimal);
        if (bigDecimal.compareTo(new BigDecimal("0")) == 1) {
            System.out.println(bigDecimal+" > 0");
        }else if (bigDecimal.compareTo(new BigDecimal("0")) == -1){
            System.out.println(bigDecimal+" < 0");
        }
    }

    // 获取传入值的负值
    public static BigDecimal getNegativeVal(BigDecimal b) {
        return new BigDecimal("-"+b);
    }

}
