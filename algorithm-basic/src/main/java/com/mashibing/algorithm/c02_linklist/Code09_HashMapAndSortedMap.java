package com.mashibing.algorithm.c02_linklist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/***********************
 * Description: TODO <BR>
 * author: zhao.song
 * date: 2020/12/1 0:12
 * version: 1.0
 ***********************/
public class Code09_HashMapAndSortedMap {

    public static class Node {
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        //    key   value
        //在哈希表里 , 大类型(即包装类)一律按值传递
        //哈希表是不是总按值传递,答案否, 非基础类型
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "我是1");
        map.put(2, "我是2");
        map.put(3, "我是3");
        map.put(4, "我是4");
        map.put(5, "我是5");
        map.put(6, "我是6");

        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue("我是6"));
        System.out.println(map.containsValue("我是10"));
        System.out.println(map.remove(5));


        //       key
        HashSet<String> set = new HashSet<>();
        set.add("adb");
        set.contains("adb");
        System.out.println(set.remove("adb"));


        // 哈希表,增删改查,在使用时,复杂度都是O(1)


        // 基本类型,按值传递
        int a = 1_000;
        int b = 1_000;
        System.out.println(a == b);

        //非 -127~127范围内,大类型按 引用 传递
        Integer c = 1_000;
        Integer d = 1_000;
        System.out.println(c == d);
        System.out.println(c.equals(d));

        //-127~127范围内,大类型按值传递
        Integer e = 127;
        Integer f = 127;
        System.out.println(e == f);
        System.out.println(e.equals(f));


        System.out.println("=======================");

        //O(logN)
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "我是1");
        treeMap.put(3, "我是3");
        treeMap.put(7, "我是7");
        treeMap.put(5, "我是5");
        treeMap.put(2, "我是2");
        treeMap.put(4, "我是4");
        System.out.println(treeMap);
        System.out.println(treeMap.firstKey());//最小值
        System.out.println(treeMap.lastKey());//最大值
        //<=0返回小于等于给定键的最大键
        System.out.println(treeMap.floorKey(0));
        //<=6
        System.out.println(treeMap.floorKey(6));

    }
}
