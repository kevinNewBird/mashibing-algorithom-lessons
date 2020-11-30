package com.mashibing.algorithm.c02_linklist;

import org.w3c.dom.Node;

import java.io.IOException;

/***********************
 * Description: TODO <BR>
 * author: zhao.song
 * date: 2020/11/26 23:04
 * version: 1.0
 ***********************/
public class Code01_ReverseList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static class DoubleNode {
        public int value;
        public DoubleNode last;//前一个节点
        public DoubleNode next;//后一个节点

        public DoubleNode(int value) {
            this.value = value;
        }
    }


    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node generateLinkedList(int len, int value) {
        int size = (int) ((len + 1) * Math.random());
        if (size == 0) {
            return null;
        }

        size--;
        Node head = new Node((int) ((value + 1) * Math.random()) - (int) (value * Math.random()));
        Node pre = head;
        while (size != 0) {
            Node cur = new Node((int) ((value + 1) * Math.random()) - (int) (value * Math.random()));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    public static DoubleNode generateDoubleList(int len, int value) {
        int size = (int) ((len + 1) * Math.random());
        if (size == 0) {
            return null;
        }

        size--;
        DoubleNode head = new DoubleNode((int) ((value + 1) * Math.random()) - (int) (value * Math.random()));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) ((value + 1) * Math.random()) - (int) (value * Math.random()));

            pre.next = cur;
            cur.last = head;
            pre = cur;
            size--;
        }
        return head;
    }

    public static void main(String[] args) throws IOException {
//        Node head = generateLinkedList(3, 10);
//        Node reverseNode = reverseLinkedList(head);

        DoubleNode dHead = generateDoubleList(3, 20);
        DoubleNode reverseDHead = reverseDoubleList(dHead);


        System.in.read();
    }
}
