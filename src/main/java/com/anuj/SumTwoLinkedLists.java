package com.anuj;

public class SumTwoLinkedLists {
    public static void main(String[] args) {
        ListNode input1 = new ListNode(6);
        input1.next = new ListNode(5);
        input1.next.next = new ListNode(1);
        input1.next.next.next = new ListNode(9);

        ListNode input2 = new ListNode(2);
        input2.next = new ListNode(8);
        input2.next.next = new ListNode(7);
        input2.next.next.next = new ListNode(7);

        ListNode head = sumTwoLinkedLists(input1, input2);

        printNumber(head);
        System.out.println();
    }

    public static void printNumber(ListNode head) {
        if (head != null) {
            printNumber(head.next);
            System.out.print(head.val);
        }
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
        if (input1 == null && input2 == null) {
            //Whatever is left in the carry over needs to be in the list that will be returned.
            while (carryOver != 0) {
                head.next = new ListNode(carryOver % 10);
                carryOver = carryOver / 10;
            }
            return head;
        }
        if (input1 == null) {
            head.next = new ListNode((input2.val + carryOver) % 10);
            carryOver = (input2.val + carryOver) / 10;
            sumTwoLinkedLists(null, input2.next, head.next, carryOver);
            return head;
        }
        if (input2 == null) {
            head.next = new ListNode((input1.val + carryOver) % 10);
            carryOver = (input1.val + carryOver) / 10;
            sumTwoLinkedLists(input1.next, null, head.next, carryOver);
            return head;
        }

        head.next = new ListNode((input1.val + input2.val + carryOver) % 10);
        carryOver = (input1.val + input2.val + carryOver) / 10;
        sumTwoLinkedLists(input1.next, input2.next, head.next, carryOver);
        return head;
    }
}
