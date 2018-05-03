package com.anuj;

public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        listNode = removeNthFromEnd(listNode, 6);
        System.out.println(listNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n < 1) {
            return head;
        }

        int length = 0;
        ListNode runner = head;
        ListNode follower = head;
        boolean reachedTailBeforeEnd = false;

        while (length++ < n + 1) {
            if (runner.next != null) {
                runner = runner.next;
            } else {
                reachedTailBeforeEnd = true;
                break;
            }
        }

        if (length != n && reachedTailBeforeEnd) {
            return head;
        } else if (length == n && reachedTailBeforeEnd) {
            head = head.next;
            return head;
        }

        while (runner != null) {
            runner = runner.next;
            follower = follower.next;
        }
        if (follower != head) {
            follower.next = follower.next.next;
        } else {
            head = head.next;
        }

        return head;
    }
}
