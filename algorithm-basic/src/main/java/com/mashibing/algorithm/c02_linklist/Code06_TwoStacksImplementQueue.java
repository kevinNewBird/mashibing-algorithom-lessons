package com.mashibing.algorithm.c02_linklist;

import java.sql.Statement;
import java.util.Stack;

/***********************
 * Description: 使用栈实现队列:先进先出 <BR>
 * author: zhao.song
 * date: 2020/11/30 22:50
 * version: 1.0
 ***********************/
public class Code06_TwoStacksImplementQueue {

    public static class TwoStacksQueue{
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStacksQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }
        //遵循两大原则:1.倒入数据时,pop栈必须是空的;2.添加数据时,push栈必须有数据
        // push栈 向 pop栈倒入数据
        private void pushToPop() {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }

        public int poll() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new IllegalArgumentException("queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new IllegalArgumentException("queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }
    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }
}
