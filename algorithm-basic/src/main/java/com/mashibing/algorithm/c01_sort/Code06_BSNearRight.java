package com.mashibing.algorithm.c01_sort;

/***********************
 * Description: 认识二分树:
 *  案例三:在一个有序数组中,找<=某个数最右侧的位置
 *  <BR>
 * author: zhao.song
 * date: 2020/11/25 23:31
 * version: 1.0
 ***********************/
public class Code06_BSNearRight {

    //在arr上，找满足<=value的最右位置
    public static int nearestRight(int[] sortedArray, int num) {
//        if (sortedArray == null || sortedArray.length == 0) {
//            throw new RuntimeException("The Sorted Array is Empty!");
//        }

        int L = 0;
        int R = sortedArray.length - 1;
        int index = -1;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (sortedArray[mid] <= num) {
                index = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
//        int[] sortedArray = {1, 2, 2, 3, 4, 5, 7};
//        System.out.println(nearestRight(sortedArray, 2));

        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            //生成随机数组,并排好序
            int[] randomArray = ArraySortLogDetector.generateRandomArray(maxSize, maxValue);
            ArraySortLogDetector.comparator(randomArray);

            int v = (int) (maxValue * Math.random());

            if (nearestRight(randomArray, v) != test(randomArray, v)) {
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    private static int test(int[] randomArray, int v) {
        for (int i = randomArray.length - 1; i >= 0; i--) {
            if (randomArray[i] <= v) {
                return i;
            }
        }
        return -1;
    }
}
