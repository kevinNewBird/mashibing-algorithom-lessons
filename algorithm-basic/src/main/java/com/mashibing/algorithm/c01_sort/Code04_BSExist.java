package com.mashibing.algorithm.c01_sort;

/***********************
 * Description: 认识二分法:
 * 案例一:在一个有序数组中,找某个数是否存在
 * <BR>
 * author: zhao.song
 * date: 2020/11/25 18:51
 * version: 1.0
 ***********************/
public class Code04_BSExist {

    /**
     * Description: 使用二分法,判断有序数组中某个数是否存在 <BR>
     *
     * @param sortedArray:
     * @param num:
     * @return {@link boolean}
     * @author zhao.song    2020/11/25 22:29
     */
    public static boolean exist(int[] sortedArray, int num) {
        if (sortedArray == null || sortedArray.length == 0) {
            return false;
        }

        int L = 0;
        int R = sortedArray.length - 1;
        int mid = 0;
        while (L < R) {
            // mid = (L+R) / 2;
            // L 10亿  R 18亿
            // mid = L + (R - L) / 2
            // N / 2    N >> 1
            //这样处理的好处,可以防止越界(超过int类型的大小限制)
            mid = L + ((R - L) >> 1);//mid=(L+R)/2
            if (sortedArray[mid] == num) {
                return true;
            } else if (sortedArray[mid] < num) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return sortedArray[L] == num;
    }

    public static void main(String[] args) {
//        int[] sortedArray = {1, 2, 3, 4, 5, 7};
//        System.out.println(exist(sortedArray, 9));
        int testTime = 500_000;
        int maxSize = 100;
        int maxValue = 100;

        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            //生成随机数组,并排好序
            int[] randomArray = ArraySortLogDetector.generateRandomArray(maxSize, maxValue);
            ArraySortLogDetector.comparator(randomArray);

            int v = (int) (maxValue * Math.random());
            if (!(exist(randomArray, v) == test(randomArray, v))) {
                succeed = false;
            }
        }

        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    public static boolean test(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return true;
            }
        }
        return false;
    }
}
