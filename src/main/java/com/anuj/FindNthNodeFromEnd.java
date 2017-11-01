package com.anuj;

public class FindNthNodeFromEnd {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        ListNode found = findNthNodeFromEnd(node, 0);
        System.out.println(found.val);
    }

    public static ListNode findNthNodeFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode follow = head;
        int count = 1;
        while (temp != null) {
            if (count++ > n) {
                follow = follow.next;
            }
            temp = temp.next;
        }
        if (temp == null && count <= n) {
            return null;
        }
        return follow;
    }
}
