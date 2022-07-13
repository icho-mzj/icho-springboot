package com.icho.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: icho
 * @Date: 2022/7/6 18:13
 * @Describe: 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = getRandomArr();
        System.out.println("arr = " + Arrays.toString(arr));
        //System.out.println(Arrays.toString(selectionSort(arr)));
        System.out.println(Arrays.toString(selectionSortDemo(arr)));
    }

    private static int[] selectionSortDemo(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
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

    /*
     平均时间复杂度: O(n2)
     最佳情况: T(n) = O(n)
     最差情况: T(n) = O(n2)
     平均情况: T(n) = O(n2)

     空间复杂度: O(1)
    */
    public static int[] selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) { // 找到最小数
                    minIndex = j; // 将最小数的索引保存
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

}
