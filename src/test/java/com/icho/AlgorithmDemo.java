package com.icho;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author: icho
 * @Date: 2022/5/18 20:03
 * @Describe:
 */
public class AlgorithmDemo {

    public static void main(String[] args) {
        // 冒泡算法 System.out.println(Arrays.toString(bubbleSort(new int[]{3, 2, 4, 5})));
        // 选择排序 System.out.println(Arrays.toString(selectionSort(new int[] {4,2,3,5})));
    }

    // 选择排序
    private static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) { // 找到最小数
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }

        return array;
    }

    // 冒泡排序
    private static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) { // 决定比较几轮
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("i = " + i);
        }

        return array;
    }

    // 冒泡排序


}
