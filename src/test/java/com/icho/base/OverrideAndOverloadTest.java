package com.icho.base;

import java.util.regex.Matcher;

/**
 * @Author: icho
 * @Date: 2022/5/9 17:56
 * @Describe:
 */
public class OverrideAndOverloadTest {

    // 重载(overloading) 是在一个类里面，方法名字相同，而参数不同。返回类型可以相同也可以不同。
    // 运行时多态: 重写
    // 编译时多态: 重载
    public static void main(String[] args) {
        test03();
    }

    // TODO
    private static void test03() {
        System.out.println("Polymorghpic Test");
        Animal2 a = new Dog2();
        Animal2 b = new Dog2("smith", 5);
        Dog2 c = new Dog2();
        // 子类的非静态方法与变量覆盖父类
        a.getInfo(); //
        // 子类通过super调用父类的非静态成员方法和变量
        a.getSuperInfo();
        // 子类的静态方法被父类隐藏
        a.hello();
        b.getInfo();
        b.hello();
        c.hello();
    }

    // TODO
    private static void test02() {
        Human human = new Human();
        Human up = new Up();
        Up up1 = new Up();
        human.bark();
        up.bark();
        up1.bark();
        System.out.println(human.level);
        System.out.println(up.level);
        System.out.println(up1.level); // 子类优先使用父类成员变量

        Human.eat();
        Up.eat();
    }

    // 父类变量指向子类实例时可以使用强制类型转换访问父类没有的子类成员。
    private static void test01() {
        Human human = new Human();
        Human up = new Up();
        human.bark();
        up.bark();
        System.out.println(((Up)up).level);
    }

    // overload compareTo
    class Match implements Comparable{
        @Override
        public int compareTo(Object o) {
            // 自定义比较方法体
            Match tgt = (Match) o;
            return 0;
        }
    }

}
class Animal2 {
    String name;
    int age;
    public Animal2() {
        name = "alex";
        age = 1;
    }
    public Animal2(String nm, int ag) {
        name = nm;
        age = ag;
    }
    public void getInfo() {
        System.out.print(name + "'s age is " + age + '\n');
    }
    public void getSuperInfo() {}
    public static void hello() {
        System.out.println("Greeting from Animal");
    }
}
class Dog2 extends Animal2 {
    String name;
    int age;
    public Dog2() {
        name = "prter";
        age = 3;
    }
    public Dog2(String nm, int ag) {
        super(nm, ag);
    }
    public void getInfo() {
        System.out.print(name + "'s age is " + age + '\n');
    }
    // 通过super显式调用父类的非静态成员方法
    public void getSuperInfo() {
        super.getInfo();
    }
    public static void hello() {
        System.out.println("Greeting from Dog");
    }
}




class Human{
    public String level = "Human";

    public static void eat() {
        System.out.println("Human eat...");
    }
    public void bark(){
        System.out.println("human bark!");
    }
}

class Up extends Human{
    public String level = "Up";
    public static void eat() {
        System.out.println("Up eat...");
    }
    public Up(/*int lv*/){
        /*level=lv;*/
    }

    // 重写不可修改方法返回值
    public void bark(){
        // super.bark();
        System.out.println("up bark!");
    }
}

