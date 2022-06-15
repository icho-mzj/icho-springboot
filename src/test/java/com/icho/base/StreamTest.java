package com.icho.base;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: icho
 * @Date: 2022/6/8 20:56
 * @Describe:
 */
public class StreamTest {

    public static void main(String[] args) {
        test01();
    }

    private static void test01() {
        List<String> list = new ArrayList<String>();
        List<String> list1 = new ArrayList<>();
        list1.add("1");
        list1.add("2");
        list1.add("3");
        list1.add("4");

        List<String> list2 = new ArrayList<>();
        list2.add("A1");
        list2.add("2");
        list2.add("C3");
        list2.add("4");

        // 交集
        list = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println("交集 list = " + list);

        // 并集
        list1.addAll(list2);
        list = list1.stream().distinct().collect(Collectors.toList());
        System.out.println("并集 list = " + list);

        // 差
        // list1-list2
        list = list1.stream().filter(e -> !list2.contains(e)).collect(Collectors.toList());
        System.out.println("list1-list2 = " + list);

        // list2-list1
        list = list2.stream().filter(e -> !list1.contains(e)).collect(Collectors.toList());
        System.out.println("list2-list1 = " + list);
    }
}
