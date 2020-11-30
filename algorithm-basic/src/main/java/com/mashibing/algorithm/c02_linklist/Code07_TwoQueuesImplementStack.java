package com.mashibing.algorithm.c02_linklist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***********************
 * Description: 使用队列实现栈:先进后出 <BR>
 * author: zhao.song
 * date: 2020/11/30 23:04
 * version: 1.0
 ***********************/
public class Code07_TwoQueuesImplementStack {

    public static class TwoQueuesStack<T>{
        private Queue<T> queueData;
        private Queue<T> queueHelp;

        public TwoQueuesStack() {
            this.queueData = new LinkedList<>();
            this.queueHelp = new LinkedList<>();
        }

        public void push(T newNum) {
            queueData.offer(newNum);
        }

        public T poll() {
            while (queueData.size() > 1) {
                queueHelp.offer(queueData.poll());
            }
            T ans = queueData.poll();
            Queue<T> tmp = queueData;
            queueData = queueHelp;
            queueHelp = tmp;
            return ans;
        }

        public T peek() {
            while (queueData.size() > 1) {
                queueHelp.offer(queueData.poll());
            }
            T ans = queueData.poll();
            queueHelp.offer(ans);
            Queue<T> tmp = queueData;
            queueData = queueHelp;
            queueHelp = tmp;
            return ans;
        }

        public boolean isEmpty() {
            return queueData.isEmpty();
        }
    }

    public static void main(String[] args) {
        System.out.println("test begin");
        TwoQueuesStack<Integer> myStack = new TwoQueuesStack<>();
        Stack<Integer> test = new Stack<>();
        int testTime = 1000000;
        int max = 1000000;
        for (int i = 0; i < testTime; i++) {
            if (myStack.isEmpty()) {
                if (!test.isEmpty()) {
                    System.out.println("Oops");
                }
                int num = (int) (Math.random() * max);
                myStack.push(num);
                test.push(num);
            } else {
                if (Math.random() < 0.25) {
                    int num = (int) (Math.random() * max);
                    myStack.push(num);
                    test.push(num);
                } else if (Math.random() < 0.5) {
                    if (!myStack.peek().equals(test.peek())) {
                        System.out.println("Oops");
                    }
                } else if (Math.random() < 0.75) {
                    if (!myStack.poll().equals(test.pop())) {
                        System.out.println("Oops");
                    }
                } else {
                    if (myStack.isEmpty() != test.isEmpty()) {
                        System.out.println("Oops");
                    }
                }
            }
        }

        System.out.println("test finish!");
    }
}
