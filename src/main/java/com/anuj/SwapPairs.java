/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

public class SwapPairs {
  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    System.out.println(swapPairs(head));
  }

  public static ListNode swapPairs(ListNode head) {
    ListNode temp = head;
    int index = 0;
    ListNode oldTemp = temp;
    while (temp != null) {
      ListNode tempNext = temp.next;
      if (tempNext != null) {
        //we can still swap
        temp.next = tempNext.next;
        tempNext.next = temp;
        if(index++ == 0) {
          head = tempNext;
        }else {
          oldTemp.next = tempNext;
        }
      }
      oldTemp = temp;
      temp = temp.next;
    }
    return head;
  }
}
