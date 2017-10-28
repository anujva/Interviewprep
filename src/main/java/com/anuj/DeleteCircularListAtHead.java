package com.anuj;

import java.util.HashSet;
import java.util.Set;

public class DeleteCircularListAtHead {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = head;
//        head.next.next.next = new ListNode(7);
//        head.next.next.next.next = head;
        System.out.println(deleteAtHead(null));
        head = deleteAtHead(head);
        System.out.println("head: " + head.val);
        System.out.println("next: " + head.next.val);
        System.out.println("next: " + head.next.next.val);
        System.out.println("next: " + head.next.next.next.val);
    }

    public static ListNode deleteAtHead(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        Set<ListNode> nodeSet = new HashSet<>();
        nodeSet.add(head);
        ListNode afterCurrentHead = head.next;
        ListNode beforeCurrentHead = null;
        while ((head != null)) {
            beforeCurrentHead = head;
            head = head.next;
            if (!nodeSet.add(head)) {
                break;
            }
        }
        if (beforeCurrentHead == head) return null;
        beforeCurrentHead.next = afterCurrentHead;
        return afterCurrentHead;
    }
}