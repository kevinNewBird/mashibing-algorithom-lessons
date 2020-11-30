package com.mashibing.algorithm.c02_linklist;

/***********************
 * Description: 递归获取最大值 <BR>
 * author: zhao.song
 * date: 2020/11/30 23:32
 * version: 1.0
 ***********************/
public class Code08_GetMax {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 6, 7};
        final int max = process(arr, 0, arr.length - 1);
        System.out.println(max);
    }

    public static int process(int[] arr, int L, int R) {
        if (L == R) {
            return arr[L];
        }

        int mid = L + ((R - L) >> 1);
        final int leftMax = process(arr, L, mid);
        final int rightMax = process(arr, mid+1, R);
        return Math.max(leftMax, rightMax);
    }
}
