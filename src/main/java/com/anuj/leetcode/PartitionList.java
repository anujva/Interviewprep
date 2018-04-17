package com.anuj.leetcode;

public class PartitionList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(4,
                new ListNode(3, new ListNode(2, new ListNode(5,
                        new ListNode(2))))));

        ListNode head1 = new ListNode(3, new ListNode(1, new ListNode(2)));
        ListNode head2 = new ListNode(1, new ListNode(1));
        ListNode newHead = partition(head2, 2);

        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }

    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before
     * nodes greater than or equal to x.
     * <p>
     * You should preserve the original relative order of the nodes in each of the two partitions.
     * <p>
     * For example, Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode tempHead = new ListNode(x - 1, head);
        ListNode current = head;
        ListNode prevCurrent = tempHead;
        ListNode pointerLessX = tempHead;
        while (current != null) {
            ListNode temp = current.next;
            if (current.data < x) {
                //whatever is the prevCurrent will need to be pointed to
                prevCurrent.next = current.next;
                current.next = pointerLessX.next;
                pointerLessX.next = current;
                pointerLessX = pointerLessX.next;
            } else {
                prevCurrent = current;
            }
            current = temp;
        }
        return tempHead.next;
    }
}
