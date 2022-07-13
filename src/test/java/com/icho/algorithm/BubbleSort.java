package com.icho.algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * @Author: icho
 * @Date: 2022/7/6 17:30
 * @Describe: 冒泡算法
 */
public class BubbleSort {

    /*
     最佳情况: T(n) = O(n)
     最差情况: T(n) = O(n2)
     平均情况: T(n) = O(n2)
     平均空间复杂度O(1)
    */
    public static void main(String[] args) {
        int[] arr = getRandomArr();
        System.out.println("arr = " + Arrays.toString(arr));

        //System.out.println(Arrays.toString(bubbleSort(arr)));

        System.out.println(Arrays.toString(bubbleSortDemo(arr)));
    }

    private static int[] bubbleSortDemo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

    public static int[] getRandomArr() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        return arr;
    }

    public static int[] bubbleSort(int[] arr) {
        if (arr.length == 0) return arr;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                int numA = arr[j + 1];
                int numB = arr[j];
                if (numA < numB) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        return arr;
    }

}
