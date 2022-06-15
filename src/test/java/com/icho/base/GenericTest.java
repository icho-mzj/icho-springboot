package com.icho.base;

import com.icho.bean.Users;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: icho
 * @Date: 2022/6/13 17:47
 * @Describe:
 */
public class GenericTest {

    public static void main(String[] args) {
        test03();
    }

    // 反序列化
    private static void test04() {
        try(
                FileInputStream fileInputStream = new FileInputStream("E:\\users.ser");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            Users users = (Users) objectInputStream.readObject();
            System.out.println("users = " + users);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 序列化
    static Users users = new Users(1, "icho", "123");
    private static void test03() {
        try (
                FileOutputStream fileOutputStream = new FileOutputStream("E:\\users.ser");
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        ) {
            objectOutputStream.writeObject(users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test02() {
        List<String> list = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

        try {
            ByteArrayOutputStream bop = new ByteArrayOutputStream();
            ObjectOutputStream oop = new ObjectOutputStream(bop);
            oop.writeObject(list);

            ObjectInputStream oip = new ObjectInputStream(new ByteArrayInputStream(bop.toByteArray()));
            List<String> copyList = (List<String>) oip.readObject();
            System.out.println("list = " + list);
            System.out.println("copyList = " + copyList);
            System.out.println();
            list.remove(0);
            list.remove(1);
            System.out.println("list = " + list);
            System.out.println("copyList = " + copyList);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    // list deep copy
    private static <T> List<T> deepCopy(List<T> list) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(list);
            ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            return (List<T>) objectInputStream.readObject();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    private static void test01() {
        List<Users> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Users(i, "ppp" + i, i + "---1"));
        }
        System.out.println("list = " + list);

        //List<Users> list1 = deepCopy(list);

        List<Users> list1 = new ArrayList<>();
        list.forEach(e -> {
            try {
                list1.add(e.clone());
            } catch (CloneNotSupportedException ex) {
                throw new RuntimeException(ex);
            }
        });

        list.remove(0);

        System.out.println("list = " + list);
        System.out.println("list1 = " + list1);
    }


}
