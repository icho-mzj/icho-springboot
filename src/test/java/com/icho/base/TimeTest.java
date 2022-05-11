package com.icho.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: icho
 * @Date: 2022/5/5 19:09
 * @Describe:
 */
public class TimeTest {

    public static void main(String[] args) {
        test06();
    }

    private static void test06() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,2008);
        System.out.println("cal = " + cal);
        cal.add(Calendar.YEAR,-8);
        System.out.println("cal = " + cal);
        cal.add(Calendar.YEAR,22);
        System.out.println("cal = " + cal);

        System.out.println(cal.get(Calendar.MONTH)+1);
        System.out.println(cal.get(Calendar.DAY_OF_WEEK)-1); // 获得星期几（注意（这个与Date类是不同的）：1代表星期日、2代表星期1、3代表星期二，以此类推）
    }

    private static void test05() {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void test04() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date parse = format.parse("2022-05-05");
            System.out.println("parse = " + parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void test03() {
        Date date = new Date();
        System.out.printf("%tD%n",date);
        System.out.printf("%tF%n",date);
        System.out.printf("%tc%n",date);
    }

    private static void test02() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String s = format.format(new Date());
        System.out.println("s = " + s);
    }

    public static void test01() {
        Date date = new Date();
        System.out.println(date.before(new Date()));
        System.out.println(date.compareTo(new Date()));
    }
}
