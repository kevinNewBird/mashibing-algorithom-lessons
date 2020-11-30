package com.mashibing.algorithm.c02_linklist;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***********************
 * Description: 栈和队列的双向链表实现 <BR>
 * author: zhao.song
 * date: 2020/11/30 10:38
 * version: 1.0
 ***********************/
public class Code03_DoubleEndsQueueToStackAndQueue {

    public static class Node<T> {
        T value;
        Node<T> last;//上一个元节点
        Node<T> next;//下一个节点

        public Node(T value) {
            this.value = value;
        }
    }

    public static class DoubleEndsQueue<T> {
        //记录链表的头指针
        Node<T> head;
        //记录链表的尾指针
        Node<T> tail;

        public void addFromHead(T value) {
            Node<T> cur = new Node<T>(value);
            if (this.head == null) {
                this.head = cur;
                this.tail = cur;
            } else {
                cur.next = head;
                head.last = cur;
                head = cur;
            }
        }

        public void addFromTail(T value) {
            Node<T> cur = new Node<>(value);
            if (tail == null) {
                this.tail = cur;
                this.head = cur;
            } else {
                cur.last = tail;
                tail.next = cur;
                tail = cur;
            }
        }


        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
                cur.next = null;
                head.last = null;
            }
            return cur.value;
        }


        public T popFromTail() {
            if (tail == null) {
                return null;
            }
            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
                cur.last = null;
            }
            return cur.value;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }


    //栈:先进后出
    public static class MyStack<T> {
        private DoubleEndsQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        //了解队列的结构, 从头部加入,为保证先入后出应获取头部的元素
        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    //队列:先进先出
    public static class MyQueue<T> {
        private DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        //了解队列的结构, 从头部加入,为保证先入先出应获取尾部的元素
        public T poll() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }


    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return false;
        }
        if (o1 != null && o2 == null) {
            return false;
        }
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1.equals(o2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (!isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }

                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (!isEqual(myQueue.poll(), queue.poll())) {
                            System.out.println("oops!");
                        }
                    }
                }
            }
        }
        System.out.println("finish!");
    }


}
