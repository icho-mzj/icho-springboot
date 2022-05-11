package com.icho.base.ClassLoadSequence;

/**
 * @Author: icho
 * @Date: 2022/5/3 16:18
 * @Describe:
 */
public class ContinueTest {

    public static void main(String[] args) {
        int [] numbers = {10, 20, 30, 40, 50};

        for(int x : numbers ) {
            if( x == 30 ) {
                continue;
            }
            System.out.print( x );
            System.out.print("\n");
        }
    }

}
