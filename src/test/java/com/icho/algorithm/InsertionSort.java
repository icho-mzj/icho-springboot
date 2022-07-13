package com.icho.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: icho
 * @Date: 2022/7/6 18:28
 * @Describe: 插入排序
 */
public class InsertionSort {

    /*
     平均时间复杂度: O(n2)
     最佳情况: T(n) = O(n)
     最坏情况: T(n) = O(n2)
     平均情况: T(n) = O(n2)
     空间复杂度: O(1)
    */
    public static void main(String[] args) {
        int[] arr = getRandomArr();
        System.out.println("arr = " + Arrays.toString(arr));
        //System.out.println(Arrays.toString(insertionSort(arr)));
        System.out.println(Arrays.toString(insertionSortDemo(arr)));
    }

    private static int[] insertionSortDemo(int[] arr) {
        int curr;
        for (int i = 0; i < arr.length - 1; i++) {
            curr = arr[i + 1];
            int pre = i;
            while (pre >= 0 && arr[pre] > curr) {
                arr[pre + 1] = arr[pre]; // 把大的值给后方
                pre--;
            }
            arr[pre + 1] = curr;
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

    private static int[] insertionSort(int[] arr) {
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }
        return arr;
    }


}
