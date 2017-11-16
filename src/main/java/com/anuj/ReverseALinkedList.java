package com.anuj;

public class ReverseALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        head = reverseList(head);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode current = null;
        ListNode next = head;
        ListNode nextNextTemp = head.next;

        while (next != null) {
            nextNextTemp = next.next;
            next.next = current;
            current = next;
            next = nextNextTemp;
        }

        return current;
    }
}
