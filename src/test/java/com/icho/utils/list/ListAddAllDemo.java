package com.icho.utils.list;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author: icho
 * @Date: 2021/10/20 21:57
 * @Describe:
 */
public class ListAddAllDemo {

    public static void main(String[] args) {
        ArrayList<Object> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5);
        System.out.println("list = " + list);
    }
}
