package com.anuj.leetcode;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode list2 = new ListNode(2, new ListNode(5, new ListNode(7, new ListNode(9))));
        ListNode head = mergeKLists(new ListNode[]{
                null, null
        });

        while (head != null) {
            System.out.print(head.data + " ->");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        if (mergeKLists(lists, head, null))
            return head;
        else
            return null;
    }

    private static boolean mergeKLists(ListNode[] lists, ListNode head, ListNode prevNode) {
        int minVal = Integer.MAX_VALUE;
        int index = 0;
        int count = 0;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (minVal > lists[i].data) {
                    minVal = lists[i].data;
                    index = i;
                }
            } else {
                count++;
            }
        }
        if (lists[index] != null) {
            lists[index] = lists[index].next;
        }
        if (count < lists.length) {
            head.data = minVal;
            head.next = new ListNode();
            mergeKLists(lists, head.next, head);
        } else {
            if (prevNode != null) {
                prevNode.next = null;
            } else {
                return false;
            }
        }
        return true;
    }
}
