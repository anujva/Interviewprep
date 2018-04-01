package com.anuj.leetcode;

public class RotateListRight {

    public static void main(String[] args) {

    }

    public static ListNode rotateRight(ListNode head, int k) {
        //find the length of the list
        //find the k'th element from the end, thats the new head.
        //find the k+1th element from the end, that's the new tail
        //the last element needs to point to old head.

        ListNode tail = head;
        int length = 0;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }
        length++;

        if (k >= length) {
            k = k % length;
        }

        ListNode temp = head;
        ListNode temp1 = null;
        ListNode temp2 = null;
        int count = 0;
        while (temp != null) {
            temp = temp.next;
            if (count == k) {
                temp1 = head;
            }
            if (count == k + 1) {
                temp2 = head;
            }
            if (temp1 != null) {
                temp1 = temp1.next;
            }

            if (temp2 != null) {
                temp2 = temp2.next;
            }
        }

        //after this loop ends..
        temp2.next = null;
        tail.next = head;
        head = temp1;

        return head;
    }
}
