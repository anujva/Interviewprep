package com.anuj;

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

/**
 * Created by anuj on 5/8/17.
 */
public class MergeLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = null;
        ListNode temp = null;
        ListNode oldTemp = null;
        while (temp1 != null || temp2 != null) {
            if (temp1 != null && temp2 != null) {
                if (temp1.val < temp2.val) {
                    if (temp == null) {
                        temp = new ListNode(temp1.val);
                    } else {
                        temp.val = temp1.val;
                    }
                    temp1 = temp1 != null ? temp1.next : null;
                    oldTemp = temp;
                    temp.next = new ListNode(-1);
                } else {
                    if (temp == null) {
                        temp = new ListNode(temp2.val);
                    } else {
                        temp.val = temp2.val;
                    }
                    temp2 = temp2 != null ? temp2.next : null;
                    oldTemp = temp;
                    temp.next = new ListNode(-1);
                }
                if (head == null) {
                    head = temp;
                }
                temp = temp.next;
            } else if (temp1 == null) {
                //temp1 is null.. only temp2 left at this point
                while (temp2 != null) {
                    if (temp == null) {
                        temp = new ListNode(temp2.val);
                    } else {
                        temp.val = temp2.val;
                    }
                    if (head == null) {
                        head = temp;
                    }
                    temp2 = temp2 != null ? temp2.next : null;
                    oldTemp = temp;
                    temp.next = new ListNode(-1);
                    temp = temp.next;
                }
            } else if (temp2 == null) {
                //temp1 is null.. only temp2 left at this point;
                while (temp1 != null) {
                    if (temp == null) {
                        temp = new ListNode(temp1.val);
                    } else {
                        temp.val = temp1.val;
                    }
                    if (head == null) {
                        head = temp;
                    }
                    temp1 = temp1 != null ? temp1.next : null;
                    oldTemp = temp;
                    temp.next = new ListNode(-1);
                    temp = temp.next;
                }
            }
        }
        if (oldTemp != null) {
            oldTemp.next = null;
        }

        return head;
    }
}
