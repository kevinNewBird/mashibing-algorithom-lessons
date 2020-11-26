package com.mashibing.algorithm.c01_sort;

import java.util.Arrays;

/***********************
 * Description: 数字排序对数器 <BR>
 * author: zhao.song
 * date: 2020/11/25 17:32
 * version: 1.0
 ***********************/
public class ArraySortLogDetector {


    /**
     * Description: 生成一个随机数组 <BR>
     *
     * @param maxSize:数组最大长度
     * @param maxValue:      数组最大值
     * @return {@link int[]}
     * @author zhao.song    2020/11/25 17:34
     */
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        //[0,N]
        int[] randomArray = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < randomArray.length; i++) {
            //[0,N]   [0,N-1]
            //[-(N-1),N]
            randomArray[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return randomArray;
    }

    /**
     * Description: 拷贝数组 <BR>
     *
     * @param source:
     * @return {@link int[]}
     * @author zhao.song    2020/11/25 17:40
     */
    public static int[] copyArray(int[] source) {
        final int[] copyArray = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            copyArray[i] = source[i];
        }
        return copyArray;
    }


    /**
     * Description: 默认必定正确的结果(对数器基准) <BR>
     *
     * @param source:
     * @return
     * @author zhao.song    2020/11/25 17:41
     */
    public static void comparator(int[] source) {
        Arrays.sort(source);
    }

    /**
     * Description: 比对结果 <BR>
     *
     * @author zhao.song    2020/11/25 17:47
     * @param source:
     * @param target:
     * @return {@link boolean}
     */
    public static boolean isEqual(int[] source, int[] target) {
        if (source == null && target == null) {
            return true;
        }

        if ((source == null && target != null) || (source != null && target == null)) {
            return false;
        }

        if (source.length != target.length) {
            return false;
        }

        for (int i = 0; i < source.length && source[i] != target[i]; i++) {
            return false;
        }

        return true;
    }
}
