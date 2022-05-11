package com.icho.base;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: icho
 * @Date: 2022/5/5 19:52
 * @Describe:
 */
public class RegexTest {

    public static void main(String[] args) {
        test03();
    }

    /*
     matches要求整个序列都匹配
     lookingAt从第一个字符开始匹配
    */
    private static void test03() {
        String REGEX = "foo";
        String INPUT = "fooooooooooooooooo";
        String INPUT2 = "ooooofoooooooooooo";

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);
        Matcher matcher2 = pattern.matcher(INPUT2);

        System.out.println("Current REGEX is: "+REGEX);
        System.out.println("Current INPUT is: "+INPUT);
        System.out.println("Current INPUT2 is: "+INPUT2);


        System.out.println("lookingAt(): "+matcher.lookingAt());
        System.out.println("matches(): "+matcher.matches());
        System.out.println("lookingAt(): "+matcher2.lookingAt());
    }

    private static final String REGEX = "cat";
    private static final String INPUT = "cat cat cat cattie cat";
    /*
    public int end()
    返回最后匹配字符之后的偏移量。 +1
    */
    private static void test02() {
        Pattern p = Pattern.compile(REGEX);
        Matcher m = p.matcher(INPUT);

        int count = 0;
        while (m.find()) {
            count++;
            System.out.println("Match number "+count);
            System.out.println("start(): "+m.start());
            System.out.println("end(): "+m.end());
        }
    }

    private static void test01() {
        String s = "Hello World,it's icho's home.";
        String pattern = ".*it's icho.*";
        boolean b = Pattern.matches(pattern, s);
        System.out.println("b = " + b);
    }


}
