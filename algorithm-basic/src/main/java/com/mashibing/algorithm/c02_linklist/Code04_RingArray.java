package com.mashibing.algorithm.c02_linklist;

/***********************
 * Description: 栈和队列的数组实现 <BR>
 * author: zhao.song
 * date: 2020/11/30 13:50
 * version: 1.0
 ***********************/
public class Code04_RingArray {


    public static class MyQueue {
        private int[] arrry;//数据存放数组
        private int polli = 0;//弹出位置
        private int pushi = 0;//插入位置
        private int size = 0;//队列数据大小
        private int limit = 0;//队列数据限制

        public MyQueue(int polli, int pushi, int limit) {
            this.arrry = new int[limit];
            this.polli = polli;
            this.pushi = pushi;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new ArrayIndexOutOfBoundsException("栈已满,不可再添加新元素!");
            }
            size++;
            arrry[pushi] = value;
            pushi = nextIndex(pushi);
        }

        public int pop() {
            if (isEmpty()) {
                throw new IllegalArgumentException("栈已空,不可再取出元素!");
            }
            size--;
            int popValue = arrry[polli];
            polli = nextIndex(polli);
            return popValue;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        // 如果现在的下标是i，返回下一个位置
        private int nextIndex(int currIndex) {
            return currIndex == limit - 1 ? 0 : currIndex + 1;
        }
    }
}
