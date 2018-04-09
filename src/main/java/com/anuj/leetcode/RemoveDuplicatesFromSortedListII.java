package com.anuj.leetcode;

public class RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prevDup = null;
        ListNode current = head;

        while (current != null) {
            if (current.next != null) {
                if (current.data == current.next.data) {
                    current = current.next;
                } else {
                    if (prevDup != null) {

                    } else {
                        prevDup = current;
                        current = current.next;
                    }
                }
            } else {
                if (prevDup != null) {

                }
            }
        }
    }
}
