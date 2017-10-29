package com.anuj;

import java.util.HashSet;

/**
 * Created by anuj on 10/25/17.
 */
public class DeleteAtHead {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = head;
        head = deleteAtHead(head);
        System.out.println("head: " + head.val);
        System.out.println("next: " + head.next.val);
        System.out.println("next: " + head.next.next.val);
        System.out.println("next: " + head.next.next.next.val);
    }

    public static ListNode deleteAtHead(ListNode head) {
        //Delete the head of the circular linked list..
        if (head == null) return null;
        if (head.next == null || head.next == head) return null;

        HashSet<ListNode> listNodes = new HashSet<>();
        ListNode nodeAfterHead = head.next;
        ListNode nodeBeforeHead = null;

        while (listNodes.add(head)) {
            nodeBeforeHead = head;
            head = head.next;
        }
        nodeBeforeHead.next = nodeAfterHead;
        return nodeAfterHead;
    }
}
