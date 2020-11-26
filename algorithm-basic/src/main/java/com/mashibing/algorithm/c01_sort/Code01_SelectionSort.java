package com.mashibing.algorithm.c01_sort;

/***********************
 * Description: 选择排序 <BR>
 * @author: zhao.song
 * @date: 2020/11/20 17:22
 * @version: 1.0
 ***********************/
public class Code01_SelectionSort {

    public static void main(String[] args) {

        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] randomArray = ArraySortLogDetector.generateRandomArray(maxSize, maxValue);
            int[] testArray = ArraySortLogDetector.copyArray(randomArray);

            ArraySortLogDetector.comparator(randomArray);
            selectOrderSort(testArray);

            if(!ArraySortLogDetector.isEqual(randomArray, testArray)) {
                succeed = false;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

    }

    //正序
    public static void selectOrderSort(int[] arr) {
        selectSort(arr,true);
    }

    //倒序
    public static void selectNoOrderSort(int[] arr) {
        selectSort(arr,false);
    }

    public static void selectSort(int[] arr, boolean isOrder) {
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
    private static void swap(int[] arr, int currPos, int tPos) {
        if (currPos == tPos) {
            return;
        }
        int tmp = arr[currPos];
        arr[currPos] = arr[tPos];
        arr[tPos] = tmp;
    }
}
