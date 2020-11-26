package com.mashibing.algorithm.c01_sort;

/***********************
 * Description: 案例六:一个数组中有一种数出现了奇数次,
 * 其它数都出现了偶数次,怎么找到并打印这种数 <BR>
 * author: zhao.song
 * date: 2020/11/26 0:28
 * version: 1.0
 ***********************/
public class Code08_EvenTimesOddTimes {

    // arr中，只有一种数，出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    // arr中，有两种数，出现奇数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }

        // eor = a ^ b
        // eor != 0
        // eor必然有一个位置上是1
        // 0110010000
        // 0000010000
        int rightOne = eor & (~eor + 1); // 提取出最右的1
        int onlyOne = 0; // eor'
        for (int i = 0 ; i < arr.length;i++) {
            //  arr[1] =  111100011110000
            // rightOne=  000000000010000
            if ((arr[i] & rightOne) != 0) {
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }


    public static int bit1Counts(int N) {
        int counts = 0;

        while (N != 0) {
            //0011
            //1101
            //0011 & 1101 = 0001
            counts++;
            int rightOne = N & (~N + 1);
            N = N ^ rightOne;//N^=rightOne
        }
        return counts;
    }



    public static void main(String[] args) {
//        System.out.println(1 & 0);
        System.out.println(bit1Counts(7));
    }

}
