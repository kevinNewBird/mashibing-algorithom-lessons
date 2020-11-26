package com.mashibing.algorithm.c01_sort;

/***********************
 * Description: 插入排序 <BR>
 * @author: zhao.song
 * @date: 2020/11/20 19:00
 * @version: 1.0
 ***********************/
public class Code03_InsertSort {


    public static void main(String[] args) {

        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] randomArray = ArraySortLogDetector.generateRandomArray(maxSize, maxValue);
            int[] testArray = ArraySortLogDetector.copyArray(randomArray);

            ArraySortLogDetector.comparator(randomArray);
            insertSort(testArray);

            if(!ArraySortLogDetector.isEqual(randomArray, testArray)) {
                succeed = false;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
/*        int[] arr = {1, 8, 5, 5, 10, 3, 2};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));*/
    }

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        //0-0   有序
        //0-1   有序
        //0-2   有序
        //...
        //0-n-1 有序
        for (int i = 0; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    //lPos和hPos是同一个位置的话,会报错
    private static void swap(int[] arr, int lPos, int hPos) {
        //异或
        arr[lPos] = arr[lPos] ^ arr[hPos];
        arr[hPos] = arr[lPos] ^ arr[hPos];
        arr[lPos] = arr[lPos] ^ arr[hPos];
    }
}
