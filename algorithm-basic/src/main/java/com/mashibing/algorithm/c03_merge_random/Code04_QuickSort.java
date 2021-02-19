package com.mashibing.algorithm.c03_merge_random;

import java.util.Arrays;

/***********************
 * Description: TODO <BR>
 * author: zhao.song
 * date: 2020/12/7 16:54
 * version: 1.0
 ***********************/
public class Code04_QuickSort {
    public static void main(String[] args) {
//        int[] array = {3, 46, 6, 5, 5};
//        System.out.println(partition(array, 0, array.length - 1));
//        System.out.println(Arrays.toString(nearNeitherFlag(array, 0, array.length - 1)));
//        quickSort1(array);
//        quickSort2(array);
//        quickSort3(array);
//        System.out.println(Arrays.toString(array));

    }

    public static void quickSort1(int array[]) {
        if (array == null || array.length < 2) {
            return;
        }
        process1(array, 0, array.length - 1);
    }

    public static void process1(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int M = partition(array, L, R);
        process1(array, L, M - 1);
        process1(array, M + 1, R);
    }

    public static void quickSort2(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process2(array, 0, array.length - 1);
    }

    public static void quickSort3(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        process3(array, 0, array.length - 1);
    }

    private static void process3(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(array, (L + (int) (Math.random() * (R - L + 1))), R);
        int[] equalZone = nearNeitherFlag(array, L, R);
        process3(array, L, equalZone[0] - 1);
        process3(array, equalZone[1] + 1, R);
    }

    private static void process2(int[] array, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalZone = nearNeitherFlag(array, 0, array.length - 1);
        process2(array, L, equalZone[0] - 1);
        process2(array, equalZone[1] + 1, R);
    }

    /**
     * Description: partition问题:以数组的最后一个数作为期望数,分隔数组,返回等于区域的索引位置 <BR>
     *
     * @param array:
     * @param L:
     * @param R:
     * @return {@link null}
     * @author zhao.song    2020/12/8 21:38
     */
    public static int partition(int[] array, int L, int R) {
        if (array == null) {
            return -1;
        }
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        //以array[R]作为期望值
        //[index]<=array[R],当前位置和小于区域交换,小于等于区域右移,当前位置前移
        //[index]>array[R],当前位置前移,小于等于区域不变
        while (index < R) {
            if (array[index] <= array[R]) {
                swap(array, ++lessEqual, index);
            }
            index++;
        }
        swap(array, ++lessEqual, R);
        return lessEqual;
    }

    /**
     * Description: 荷兰国旗问题 <BR>
     *
     * @param array:
     * @param L:
     * @param R:
     * @return {@link int[]}
     * @author zhao.song    2020/12/8 23:57
     */
    public static int[] nearNeitherFlag(int array[], int L, int R) {
        if (array == null || array.length < 1 || L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int lessEqual = L - 1;
        int greatEqual = R;
        int index = L;
        //[index]<array[R],小于区域右扩,当前位置和小于区域下一个交换,当前位置增加;
        //[index]=array[R],不变,当前位置增加;
        //[index]>array[R],大于区域左扩,当前位置不变,当前位置和大于区域下一位置交换
        while (index < greatEqual) {
            if (array[index] < array[R]) {
                swap(array, index++, ++lessEqual);
            } else if (array[index] == array[R]) {
                index++;
            } else {
                swap(array, index, --greatEqual);
            }
        }
        swap(array, greatEqual, R);
        return new int[]{lessEqual + 1, greatEqual};
    }

    /**
     * Description: 交换索引位置的值<BR>
     *
     * @param array:数组
     * @param p1:位置p1
     * @param p2:位置p2
     * @return
     * @author zhao.song    2020/12/8 21:26
     */
    public static void swap(int array[], int p1, int p2) {
        if (array == null || array.length < 2 || p1 == p2) {
            return;
        }
        array[p1] = array[p1] ^ array[p2];
        array[p2] = array[p1] ^ array[p2];
        array[p1] = array[p1] ^ array[p2];
    }
}
