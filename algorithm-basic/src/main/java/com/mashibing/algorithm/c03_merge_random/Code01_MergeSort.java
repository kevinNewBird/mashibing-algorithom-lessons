package com.mashibing.algorithm.c03_merge_random;

import com.sun.istack.internal.NotNull;

import javax.sound.midi.MidiChannel;
import java.util.Arrays;

/***********************
 * Description: 归并排序 <BR>
 * author: zhao.song
 * date: 2020/12/2 16:25
 * version: 1.0
 ***********************/
public class Code01_MergeSort {

    public static void main(String[] args) {

        int[] array = {1, 4, 24, 52, 1, 2, 56, 332};
//        mergeSortInRecursive(array, 0, array.length - 1);
        mergeSortNoRecursive(array);
        System.out.println(Arrays.toString(array));
    }


    //递归方式实现-归并排序
    public static void mergeSortInRecursive(int[] arr, int L, int R) {
        if (arr == null || arr.length < 2) {
            return;
        }

        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergeSortInRecursive(arr, L, mid);
        mergeSortInRecursive(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    //普通方式实现-归并排序
    //原则: 任何递归都可以用非递归实现
    public static void mergeSortNoRecursive(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        int mergeSize = 1;//合并,左组大小
        //复杂度:O(N * logN)
        while (mergeSize < N) {                                            //logN
            int L = 0;//左组的起始索引
            while (L < N) {                                                //N
                int M = L + mergeSize - 1;//中间位置
                if (M >= N) {
                    break;
                }
                int R = Math.min(M + mergeSize, N - 1);//右组的末位置
                merge(arr, L, M, R);
                L = R + 1;
            }
            //防止下面的位运算越界,发生未知的错误
            if (mergeSize > N / 2) {
                break;
            }
            //*2
            mergeSize <<= 1;
        }

    }

    //对左右分别排好序的数组进行处理
    private static void merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;//记录额外空间的指针位置
        int p1 = L;//左指针
        int p2 = M + 1;//右指针
        //1.当左右指针都未越界,比较两个值,满足条件的指针++,并使用再次比较
        while (p1 <= M && p2 <= R) {
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        //2.要么是左指针越界,要么是右指针越界
        while (p1 <= M) {
            help[i++] = arr[p1++];
        }

        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L++] = help[j];
        }

    }
}
