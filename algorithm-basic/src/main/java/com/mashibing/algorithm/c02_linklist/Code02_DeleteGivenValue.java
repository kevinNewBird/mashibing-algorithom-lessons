package com.mashibing.algorithm.c02_linklist;

import java.io.IOException;

/***********************
 * Description: TODO <BR>
 * author: zhao.song
 * date: 2020/11/27 0:27
 * version: 1.0
 ***********************/
public class Code02_DeleteGivenValue {

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node deleteGivenValue(Node head, int value) {

        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }

        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) throws IOException {
        Node head = new Node(1);
        Node link1 = new Node(2);
        head.next = link1;
        Node link2 = new Node(3);
        link1.next = link2;

        final Node node = deleteGivenValue(head, 1);
        System.in.read();

    }
}
