package com.icho.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;

/**
 * @Author: icho
 * @Date: 2022/5/6 17:21
 * @Describe: Serializable 用来标识当前类可以被 ObjectOutputStream 序列化，以及被 ObjectInputStream 反序列化。
 */
public class SerializableTest {

    public static void main(String[] args) {
        serialize();
        deSerialize();
    }

    // 序列化
    public static void serialize() {
        Student student = new Student();
        student.setAge(18);
        student.setName("icho");
        ObjectOutputStream ots = null;
        try {
            ots = new ObjectOutputStream(new FileOutputStream("E:/studentStream.txt"));
            ots.writeObject(student);
            System.out.println("success");
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (ots != null) {
                try {
                    ots.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 反序列化
    public static void deSerialize() {
        ObjectInputStream ips = null;
        try {
            ips = new ObjectInputStream(new FileInputStream("E:/studentStream.txt"));
            Student student = (Student) ips.readObject();
            System.out.println("student = " + student);
        }catch (IOException | ClassNotFoundException e) {
            if (ips != null) {
                try {
                    ips.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }

}

@Data
class Student implements Serializable {

    private String name;

    private int age;

}
