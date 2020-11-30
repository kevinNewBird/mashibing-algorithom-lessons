package com.mashibing.algorithm.c02_linklist;

import java.util.Stack;

/***********************
 * Description: TODO <BR>
 * author: zhao.song
 * date: 2020/11/30 22:27
 * version: 1.0
 ***********************/
public class Code05_GetMinStack {


    public static class MyStack2{
        private Stack<Integer> stackData = new Stack<>();
        private Stack<Integer> stackMin = new Stack<>();


        public void push(int value) {
            if (stackMin.isEmpty()) {
                stackMin.push(value);
            } else if (stackMin.peek() > value) {
                stackMin.push(value);
            } else{
                stackMin.push(stackMin.peek());
            }
            stackData.push(value);
        }

        public int pop() {
            if (stackData.isEmpty()) {
                throw new IllegalArgumentException("the stack is empty!");
            }
            stackMin.pop();
            return stackData.pop();
        }

        public int getMin() {
            if (stackMin.isEmpty()) {
                throw new IllegalArgumentException("the stack is empty!");
            }
            return this.stackMin.peek();
        }
    }
}
