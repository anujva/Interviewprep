package com.anuj;

public class CheckCycleInList {
    public static void main(String[] main) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        System.out.println(isCyclic(head));
    }

    public static Boolean isCyclic(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && slow != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return false;
        }

        return false;
    }
}
