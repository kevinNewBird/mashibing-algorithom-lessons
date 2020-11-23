package com.mashibing.algorithm.sort;

import java.util.Arrays;

/***********************
 * Description: 冒泡排序 <BR>
 * @author: zhao.song
 * @date: 2020/11/20 18:14
 * @version: 1.0
 ***********************/
public class Code02_BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 8, 5, 5, 10, 3, 13};
        bubbleSort(arr, false);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr, boolean isOrder) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        //0-N-1
        //1-N-1
        //2-N-1
        //...
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (isOrder ? arr[j - 1] > arr[j] : arr[j - 1] < arr[j]) {
                    swap2(arr, j - 1, j);
                }
            }
        }
    }

    //交换位置
    private static void swap(int[] arr, int currPos, int tPos) {
        if (currPos == tPos) {
            return;
        }
        int tmp = arr[currPos];
        arr[currPos] = arr[tPos];
        arr[tPos] = tmp;
    }

    private static void swap2(int[] arr, int currPos, int tPos) {
        if (currPos == tPos) {
            return;
        }
        arr[currPos] = arr[currPos] ^ arr[tPos];
        arr[tPos] = arr[currPos] ^ arr[tPos];
        arr[currPos] = arr[currPos] ^ arr[tPos];
    }
}
