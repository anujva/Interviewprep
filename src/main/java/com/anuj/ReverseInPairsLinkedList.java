package com.anuj;

public class ReverseInPairsLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        head = reverseInPairs(head);
        System.out.println(head.val + " --> " + head.next.val + " --> "
                + head.next.next.val
                + " --> " + head.next.next.next.val
                + " --> " + head.next.next.next.next.val
                + " --> " + head.next.next.next.next.next.val
        );
    }

    public static ListNode reverseInPairs(ListNode head) {
        //If the head is null or head is the only node, just return
        if (head == null || head.next == null) return head;
        ListNode beforeTemp = null;
        ListNode temp = head;
        ListNode tempNext = temp.next;
        ListNode tempNextNext = tempNext.next;
        do {
            temp.next = tempNextNext;
            tempNext.next = temp;
            if (beforeTemp != null) {
                beforeTemp.next = tempNext;
            } else {
                head = tempNext;
            }
            beforeTemp = temp;
            temp = tempNextNext;
            if (temp != null)
                tempNext = temp.next;
            else
                tempNext = null;
            if (tempNext != null)
                tempNextNext = tempNext.next;
            else
                tempNextNext = null;
            if (tempNext == null) temp = null;
        } while (temp != null);

        return head;
    }
}
