package com.anuj;

public class IsCyclic {
    public static void main(String[] args) {

    }

    public static Boolean isCyclic(ListNode head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (!(fast == null || slow == null)) {
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
