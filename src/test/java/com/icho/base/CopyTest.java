package com.icho.base;

import java.io.*;

/**
 * @Author: icho
 * @Date: 2022/5/24 18:09
 * @Describe:
 */
public class CopyTest {

    public static void main(String[] args) {
        test02();
    }

    /*
    * 序列化
    */
    private static void test02() {
        try {
            School_CopyTest2 s1 = new School_CopyTest2();
            s1.setSchoolName("实验小学");
            s1.setStuNums(100);
            Student_CopyTest2 stu1 = new Student_CopyTest2();
            stu1.setAge(20);
            stu1.setName("zhangsan");
            stu1.setSex(new StringBuffer("男"));
            s1.setStu(stu1);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(s1);
            oos.flush();
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
            School_CopyTest2 s2 = (School_CopyTest2) ois.readObject();
            System.out.println("s1 = " + s1);
            System.out.println("s2 = " + s2);
            stu1.setName("lisi");
            System.out.println("change s1 = " + s1);
            System.out.println("change s2 = " + s2);
            ois.close();
            oos.close();
            bos.close();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /*
    * 重写每层clone
    */
    private static void test01() {
        School_CopyTest1 s1 = new School_CopyTest1();
        s1.setSchoolName("实验小学");
        s1.setStuNums(100);
        Student_CopyTest1 stu1 = new Student_CopyTest1();
        stu1.setAge(20);
        stu1.setName("zhangsan");
        stu1.setSex(new StringBuffer("男"));
        s1.setStu(stu1);
        System.out.println("s1: "+s1+" s1的hashcode:"+s1.hashCode()+"  s1中stu1的hashcode:"+s1.getStu().hashCode());
        try {
            School_CopyTest1 s2 = s1.clone();
            System.out.println("s2: "+s2+" s2的hashcode:"+s2.hashCode()+" s2中stu1的hashcode:"+s2.getStu().hashCode());

            System.out.println(s1 == s2);
            stu1.setName("lisi");

            System.out.println("s1 = " + s1);
            System.out.println("s2 = " + s2);
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}


class Student_CopyTest1 implements Cloneable {
    private String name;   //姓名
    private int age;       //年龄
    private StringBuffer sex;  //性别
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public StringBuffer getSex() {
        return sex;
    }
    public void setSex(StringBuffer sex) {
        this.sex = sex;
    }

    @Override
    protected Student_CopyTest1 clone() throws CloneNotSupportedException {
        return (Student_CopyTest1)super.clone(); // 重写clone方法
    }

    @Override
    public String toString() {
        return "Student_CopyTest1 [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }
}

class School_CopyTest1 implements Cloneable{
    private String schoolName;   //学校名称
    private int stuNums;         //学校人数
    private Student_CopyTest1 stu;         //一个学生
    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public int getStuNums() {
        return stuNums;
    }
    public void setStuNums(int stuNums) {
        this.stuNums = stuNums;
    }
    public Student_CopyTest1 getStu() {
        return stu;
    }
    public void setStu(Student_CopyTest1 stu) {
        this.stu = stu;
    }
    @Override
    protected School_CopyTest1 clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        School_CopyTest1 s = null;
        s = (School_CopyTest1) super.clone();
        s.stu = stu.clone();
        return s;
    }
    @Override
    public String toString() {
        return "School_CopyTest1 [schoolName=" + schoolName + ", stuNums=" + stuNums + ", stu=" + stu + "]";
    }
}


class Student_CopyTest2 implements Serializable {
    private String name;   //姓名
    private int age;       //年龄
    private StringBuffer sex;  //性别
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public StringBuffer getSex() {
        return sex;
    }
    public void setSex(StringBuffer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Student_CopyTest2 [name=" + name + ", age=" + age + ", sex=" + sex + "]";
    }
}

class School_CopyTest2 implements Serializable{
    private String schoolName;   //学校名称
    private int stuNums;         //学校人数
    private Student_CopyTest2 stu;         //一个学生
    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public int getStuNums() {
        return stuNums;
    }
    public void setStuNums(int stuNums) {
        this.stuNums = stuNums;
    }
    public Student_CopyTest2 getStu() {
        return stu;
    }
    public void setStu(Student_CopyTest2 stu) {
        this.stu = stu;
    }
    @Override
    public String toString() {
        return "School_CopyTest2 [schoolName=" + schoolName + ", stuNums=" + stuNums + ", stu=" + stu + "]";
    }
}