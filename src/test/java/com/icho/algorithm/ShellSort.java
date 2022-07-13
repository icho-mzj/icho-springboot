package com.icho.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: icho
 * @Date: 2022/7/6 18:48
 * @Describe: 希尔排序/缩小增量排序
 */
public class ShellSort {

    /*
     平均时间复杂度: O(nlogn)
     最佳情况: O(nlog2n)
     最差情况 O(nlog2n)
     空间复杂度: O(1)
     */
    public static void main(String[] args) {
        int[] arr = getRandomArr();
        System.out.println("arr = " + Arrays.toString(arr));

        System.out.println(Arrays.toString(shellSort(arr)));

        System.out.println(Arrays.toString(shellSortDemo(arr)));
    }

    public static int[] getRandomArr() {
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100);
        }
        return arr;
    }

    private static int[] shellSort(int[] arr) {
        int len = arr.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i]; //gap
                int preIndex = i - gap;
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }

        return arr;
    }

    public static int[] shellSortDemo(int[] arr) {
        int len = arr.length;
        int gap = len / 2;
        int temp;
        int pre = gap;

        for (int i = gap; i < arr.length; i++) {
            int numA,numB;
            numA = arr[gap];
            numB = arr[gap-pre];

            while (pre >= 0 && numA > numB) {
                temp = numA;
                numA = numB;
                numB = temp;
                pre -= gap;
            }
            gap = gap / 2;
        }

        return arr;
    }

}
