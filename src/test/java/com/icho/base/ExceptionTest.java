package com.icho.base;

import java.io.*;
import java.util.Scanner;

/**
 * @Author: icho
 * @Date: 2022/5/6 20:32
 * @Describe:
 */
public class ExceptionTest {

    public static void main(String[] args) {
        System.out.println(test02());
    }

    private static int test02() {
        try{
            //待捕获代码
            int i = 1 / 0;
        }catch(Exception e){
            System.out.println("catch is begin");
            return 1 ;
        }finally{
            System.out.println("finally is begin");
            return 2 ;
        }
        //return 3;
    }

    // try with catch
    // 编译时生成finally close资源
    // 声明的资源需实现AutoCloseable
    // 以相反的顺序关闭这些资源
    private static void test01() {
        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        }catch (Exception e) {
            System.out.println("Exception in finally block =>"+e.getMessage());
        }
    }
}

//自定义异常类，继承Exception类
class InsufficientFundsException extends Exception
{
    //此处的amount用来储存当出现异常（取出钱多于余额时）所缺乏的钱
    private double amount;
    public InsufficientFundsException(double amount)
    {
        this.amount = amount;
    }
    public double getAmount()
    {
        return amount;
    }
}
