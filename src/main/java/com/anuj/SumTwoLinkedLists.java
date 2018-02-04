package com.anuj;

public class SumTwoLinkedLists {
    public static void main(String[] args) {

    }

    public static ListNode sumTwoLinkedLists(ListNode input1, ListNode input2) {
        if (input1 == null && input2 == null) return null;
        if (input1 == null) return input2;
        if (input2 == null) return input1;

        ListNode head = new ListNode((input1.val + input2.val) % 10);
        int carryOver = (input1.val + input2.val) / 10;

        sumTwoLinkedLists(input1.next, input2.next, head, carryOver);
        return head;
    }

    public static ListNode sumTwoLinkedLists(ListNode input1, ListNode input2,
                                             ListNode head, int carryOver) {
        if (input1 == null && input2 == null) return null;
        if (input1 == null) {
            while (input2 != null) {
                head.next = new ListNode(input2.val);
                input2 = input2.next;
                head = head.next;
            }
            return input2;
        }
        if (input2 == null) {
            while (input1 != null) {
                head.next = new ListNode(input1.val);
                input1 = input1.next;
                head = head.next;
            }
            return input1;
        }

    }
}
