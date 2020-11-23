package com.mashibing.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

/***********************
 * Description: 选择排序 <BR>
 * @author: zhao.song
 * @date: 2020/11/20 17:22
 * @version: 1.0
 ***********************/
public class Code01_SelectionSort {

    public static void main(String[] args) {
        Integer[] arr = {1, 8, 5, 5};
/*        Arrays.sort(arr, (o1,o2)->{
            if (o1 > o2) {
                return 1;
            }
            return -1;
        });*/
//        selectOrderSort(arr);
//        selectNoOrderSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //正序
    public static void selectOrderSort(Integer[] arr) {
        selectSort(arr,true);
    }

    //倒序
    public static void selectNoOrderSort(Integer[] arr) {
        selectSort(arr,false);
    }

    public static void selectSort(Integer[] arr, boolean isOrder) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //0-N-1
        //1-N-1
        //2-N-1
        //...
        for (int i = 0; i < arr.length; i++) {
            //最小值(或最小值)的下标
            int oSelectIndex = i;
            for (int j = i + 1; j < arr.length; j++) {//i-N-1位置上找最小值的下标
                oSelectIndex = (isOrder ? arr[oSelectIndex] > arr[j] : arr[oSelectIndex] < arr[j])
                        ? j
                        : oSelectIndex;
            }
            swap(arr, i, oSelectIndex);
        }
    }

    //交换位置
    private static void swap(Integer[] arr, int currPos, int tPos) {
        if (currPos == tPos) {
            return;
        }
        int tmp = arr[currPos];
        arr[currPos] = arr[tPos];
        arr[tPos] = tmp;
    }
}
