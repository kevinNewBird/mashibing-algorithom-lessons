package com.mashibing.algorithm.c03_merge_random;

import java.util.Arrays;

/***********************
 * Description: 归并排序-求小数和   求降数对 <BR>
 * author: zhao.song
 * date: 2020/12/2 21:41
 * version: 1.0
 ***********************/
public class Code02_SmallSum {

    public static void main(String[] args) {
//        int[] array = {1, 4, 24, 52, 1, 2, 56, 332};
        //(3,2)(3,2)(4,2)
        int[] array = {1, 3, 2, 4, 2};
        System.out.println(mergeSortInCalSmallSum(array, 0, array.length - 1));
        System.out.println(Arrays.toString(array));
    }

    public static int mergeSortInCalSmallSum(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        if (L == R) {
            return 0;
        }
        int mid = L + ((R - L) >> 1);
        return mergeSortInCalSmallSum(arr, L, mid)
                + mergeSortInCalSmallSum(arr, mid + 1, R)
                + merge2(arr, L, mid, R);
    }

    //小数和merge
    private static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;//记录help的指针
        int pl = L;
        int pr = M + 1;
        int smallSum = 0;
        while (pl <= M && pr <= R) {
            smallSum += arr[pl] < arr[pr] ? (R - pr + 1) * arr[pl] : 0;
            help[i++] = arr[pl] < arr[pr] ? arr[pl++] : arr[pr++];
        }
        while (pl <= M) {
            help[i++] = arr[pl++];
        }
        while (pr <= R) {
            help[i++] = arr[pr++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return smallSum;
    }

    //降序对
    private static int merge2(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;//记录help的指针
        int pl = L;
        int pr = M + 1;
        int minCount = 0;
        while (pl <= M && pr <= R) {
            minCount += arr[pl] > arr[pr] ? (pr - M) : 0;
            help[i++] = arr[pl] > arr[pr] ? arr[pr++] : arr[pl++];
        }
        while (pl <= M) {
            help[i++] = arr[pl++];
        }
        while (pr <= R) {
            help[i++] = arr[pr++];
        }
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return minCount;
    }


}
