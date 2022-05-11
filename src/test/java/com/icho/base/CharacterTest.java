package com.icho.base;

/**
 * @Author: icho
 * @Date: 2022/5/3 21:02
 * @Describe:
 */
public class CharacterTest {

    public static void main(String[] args) {
        test07();
    }

    public static void test01() {
        System.out.println(Character.isLetter('a'));
        System.out.println(Character.isLetter('1'));
    }

    public static void test02() {
        System.out.println(Character.isDigit('a'));
        System.out.println(Character.isDigit('1'));
    }

    public static void test03() {
        System.out.println(Character.isWhitespace('a'));
        System.out.println(Character.isWhitespace(' '));
        System.out.println(Character.isWhitespace('\n'));
        System.out.println(Character.isWhitespace('\t'));
    }

    public static void test04() {
        System.out.println(Character.isLowerCase('a'));
        System.out.println(Character.isLowerCase('1'));
        System.out.println(Character.isLowerCase('A'));
    }

    public static void test05() {
        System.out.println(Character.isUpperCase('a'));
        System.out.println(Character.isUpperCase('1'));
        System.out.println(Character.isUpperCase('A'));
    }

    public static void test06() {
        System.out.println(Character.toLowerCase('a'));
        System.out.println(Character.toLowerCase('1'));
        System.out.println(Character.toLowerCase('A'));
    }

    public static void test07() {
        System.out.println(Character.toUpperCase('a'));
        System.out.println(Character.toUpperCase('1'));
        System.out.println(Character.toUpperCase('A'));
    }

    public static void test08() {
        System.out.println(Character.toString('0'));
        System.out.println(Character.toString('A'));
    }
}
