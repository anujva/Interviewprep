/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

public class MergeKSortedLists {
  public static void main(String[] args) {

  }

  public static ListNode mergeKLists(ListNode[] lists) {
    ListNode head = null;
    for (int i = 0; i < lists.length; i++) {
      head = mergeLists(head, lists[i]);
    }

    return head;
  }

  public static ListNode mergeLists(ListNode head, ListNode list) {
    if (list == null) {
      return head;
    }

    ListNode temp1 = head;
    ListNode temp2 = list;
    ListNode temp3 = null;

    while (temp1 != null && temp2 != null) {
      if (temp1.val <= temp2.val) {
        if (temp3 == null) {
          temp3 = new ListNode(temp1.val);
          head = temp3;
        } else {
          temp3.val = temp1.val;
        }
        temp3.next = new ListNode(-1);
        temp1 = temp1.next;
        temp3 = temp3.next;
      } else {
        if (temp3 == null) {
          temp3 = new ListNode(temp2.val);
          head = temp3;
        } else {
          temp3.val = temp2.val;
        }
        temp3.next = new ListNode(-1);
        temp2 = temp2.next;
        temp3 = temp3.next;
      }
    }

    if (temp1 != null) {
      while (temp1 != null) {
        if (temp3 == null) {
          temp3 = new ListNode(-1);
          head = temp3;
        }
        temp3.val = temp1.val;
        temp3.next = new ListNode(-1);
        temp3 = temp3.next;
        temp1 = temp1.next;
      }
    }

    if (temp2 != null) {
      while (temp2 != null) {
        if (temp3 == null) {
          temp3 = new ListNode(-1);
          head = temp3;
        }
        temp3.val = temp2.val;
        temp3.next = new ListNode(-1);
        temp2 = temp2.next;
        temp3 = temp3.next;
      }
    }

    if (temp3 != null) {
      temp3.next = null;
    }
    return head;
  }
}
