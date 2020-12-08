package com.mashibing.algorithm.c03_merge_random;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***********************
 * Description: 快排 <BR>
 * author: zhao.song
 * date: 2020/12/2 23:10
 * version: 1.0
 ***********************/
public class Code03_Partition {

    public static void main(String[] args) throws Exception {
//        int[] array = {8, 1, 2, 6, 4, 4, 3, 5};
//        int[] array = {4,5,3,1,2};
        int[] array = {4};
//        System.out.println(partition(array, 4));
//        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(netherlandsFlag(array, 4)));
        System.out.println(Arrays.toString(array));
    }

    /**
     * Description: partition问题--案例一 <BR>
     * 给定一个数组 arr , 何一个整数num . 请把小于等于num的数放在数组的左边 , 大于num的数放在数组的右边 (不要求有序)
     * . 要求额外空间复杂度O(1) , 时间复杂度O(N)
     *
     * @param expValue:期望值
     * @param arr:
     * @return {@link int}
     * @author zhao.song    2020/12/3 0:47
     */
    public static int partition(int[] arr, int expValue) {
        //小于区域索引
        int lessEqual = -1;
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int lPos = 0, rPos = arr.length - 1;
        //[lPos]小于等于num,lPos
        // [i]<=num,当前位置[i++]和小于[++lessEqual]交换位置(即当前数和小于等于区域的下一个数交换,然后小于等于区向右扩一个一个位置,当前数跳下一个)
        // [i]>num, 当前数跳下一个[i++]
        while (lPos <= rPos) {
            if (arr[lPos] <= expValue) {
                swap(arr, lPos, ++lessEqual);
            }

            lPos++;
        }

        return lessEqual;
    }

    // array[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    //  <array[R]  ==array[R]  > array[R]
    public static int[] netherlandsFlag(int[] array, int expValue) throws Exception {
        if (array == null || array.length < 1) {
            return new int[]{-1, -1};
        }
        //1.定义常量/中间变量
        //数组的左指针
        int lPos = 0;
        //数组右指针
        int rPos = array.length - 1;
        //小于区域
        int lessEqual = -1;
        //大于区域
        int greatEqual = array.length;
        //三种情况:
        //[i]==num , 当前数跳下一个
        //[i]<num , 当前数与小于区域下一个位置交换,小于区域右扩,当前数前移(i++)
        //[i]>num , 当前数与大于区域下一个数交换,大于区域左扩,当前数不动
        while (lPos < greatEqual) {
            if (array[lPos] == expValue) {
                lPos++;
            } else if (array[lPos] < expValue) {
                swap(array, lPos++, ++lessEqual);
            } else {
                swap(array, lPos, --greatEqual);
            }
        }
        return new int[]{lessEqual, greatEqual};
    }


    private static void swap(int[] arr, int pos1, int pos2) {

        //用一个内存地址的异或操作无法做到位置交换,会导致结果为0
        if (pos1 == pos2) {
            return;
        }
        arr[pos1] = arr[pos1] ^ arr[pos2];
        arr[pos2] = arr[pos1] ^ arr[pos2];
        arr[pos1] = arr[pos1] ^ arr[pos2];
/*        int tmp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = tmp;*/
    }
}
