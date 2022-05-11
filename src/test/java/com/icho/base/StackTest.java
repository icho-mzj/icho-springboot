package com.icho.base;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @Author: icho
 * @Date: 2022/5/11 19:49
 * @Describe:
 */
public class StackTest {

    static void showpush(Stack<Integer> st, int a) {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showpop(Stack<Integer> st) {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    private static void test01() {
        Stack<Integer> st = new Stack<Integer>();
        System.out.println("stack: " + st);
        showpush(st, 42);
        showpush(st, 66);
        showpush(st, 99);
        showpop(st);
        showpop(st);
        showpop(st);
        try {
            showpop(st);
        } catch (EmptyStackException e) {
            System.out.println("empty stack");
        }
    }


    public static void main(String args[]) {
        test02();
    }

    private static void test02() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("stack = " + stack);
        while (!stack.empty()) {
            Integer p = stack.pop();
            System.out.println(p);
        }
    }


}
