package com.anuj;

public class MergeTwoSortedLinkedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head = null;
        ListNode temp = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    temp = l1;
                    l1 = l1.next;
                    continue;
                }
                temp.next = l1;
                l1 = l1.next;
            } else {
                if (head == null) {
                    head = l2;
                    temp = l2;
                    l2 = l2.next;
                    continue;
                }
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null) {
            temp.next = l1;
        } else if(l2 != null) {
            temp.next = l2;
        } else {
            temp.next = null;
        }

        return head;
    }
}
