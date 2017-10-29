package com.anuj;

/**
 * Created by anuj on 10/29/17.
 */
public class DeleteNodeFromLinkedListAtMiddle {
    public static void main(String[] args) {

    }

    public ListNode deleteAtMiddle(ListNode head, int position) {
        if (head == null || position < 1) return null;
        ListNode temp = head;
        ListNode nodeBefore = null;
        ListNode nodeAfter = temp.next;
        int i = 1;
        while (i < position && temp != null) {
            nodeBefore = temp;
            temp = temp.next;
            if (temp != null)
                nodeAfter = temp.next;
            i++;
        }
        if (nodeBefore == null) return nodeAfter;
        nodeBefore.next = nodeAfter;
        return head;
    }
}
