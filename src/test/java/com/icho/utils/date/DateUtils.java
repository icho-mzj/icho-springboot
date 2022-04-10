package com.icho.utils.date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @Author: icho
 * @Date: 2021/12/3 22:31
 * @Describe:
 */
public class DateUtils {


    // 获取{}年的全部月末日期
    public static List<String> getAllLastMonthDate(String year) {
        Calendar calendar = Calendar.getInstance();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 13; i++) {
            calendar.set(Calendar.YEAR,Integer.parseInt(year));
            calendar.set(Calendar.DAY_OF_MONTH, 0);
            calendar.set(Calendar.MONTH,i);
            String date = new SimpleDateFormat("yyyyMMdd").format(calendar.getTime());
            list.add(date);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getTime());
    }

    // LocalDateTime
    private static final DateTimeFormatter fullDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static String getTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(fullDate);
    }


}
