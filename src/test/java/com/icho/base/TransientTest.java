package com.icho.base;

import java.io.*;

/**
 * @Author: icho
 * @Date: 2022/5/3 14:59
 * @Describe:
 */
public class TransientTest {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        People a = new People("李雷",30);
        System.out.println(a); //打印对象的值
        ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("e://people.txt"));
        os.writeObject(a);//写入文件(序列化)
        os.close();
        ObjectInputStream is = new ObjectInputStream(new FileInputStream("e://people.txt"));
        a = (People)is.readObject();//将文件数据转换为对象（反序列化）
        System.out.println(a); // 年龄 数据未定义
        is.close();
    }
}

//定义一个需要序列化的类

class People implements Serializable {
    String name; //姓名
    transient Integer age; //年龄
    public People(String name,int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "姓名 = "+name+" ,年龄 = "+age;
    }

}