package com.icho.util.stream;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: icho
 * @Date: 2021/10/20 22:00
 * @Describe:
 */
public class StreamDemo {

    public static void main(String[] args) {
        // addEle(); // 添加元素

        // filterList(); // 过滤元素

        // distinctEle(); // 去重

        // TODO sortEle(); // 排序

        test1();
    }

    // 根据map中的k获取对应的v
    private static void test1() {
        HashMap<String,String> map1 = new HashMap<>();
        map1.put("01","icho1");
        HashMap<String,String> map2 = new HashMap<>();
        map2.put("02","icho2");
        HashMap<String,String> map3 = new HashMap<>();
        map3.put("03","icho3");

        List<Map<String,String>> list = Arrays.asList(map1,map2,map3);
        System.out.println("list = " + list);
    }

    // 去重
    private static void distinctEle() {
        List<String> list = Arrays.asList("1","3","4","1","3","1","2");
        System.out.println("list = " + list);

        List<String> list1 = list.stream().distinct().collect(Collectors.toList());
        System.out.println("list1 = " + list1);
    }

    // 添加元素
    private static void addEle() {
        ArrayList<Object> list1 = new ArrayList<>();
        Collections.addAll(list1, "a","b","c","d");
        System.out.println("list1 = " + list1);

        List<String> list2 = Arrays.asList("1","2","3","4");
        System.out.println("list2 = " + list2);
    }

    //过滤list
    public static void filterList() {
        List<Integer> list1 = Arrays.asList(1,2,3,4);
        List<Integer> list2 = list1.stream()
                .filter(e -> e > 2).collect(Collectors.toList());
        System.out.println("list2 = " + list2);
    }

}
