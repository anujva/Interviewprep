/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.ge;

import java.util.HashMap;

public class LeetCode {
  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstringWithUniqueCharacters("abcabcbb"));
  }

  public static int lengthOfLongestSubstringWithUniqueCharacters(String s) {
    //Track the index of the last seen character.
    HashMap<Character, Integer> characterIntegerHashSet = new HashMap<>();
    int maxLengthSequence = 0;
    int length = 0;
    for (int i = 0; i < s.length(); i++) {
      if (characterIntegerHashSet.containsKey(s.charAt(i))) {
        //we are seeing character again. So this means we save the
        //length of the sequence till now.
        maxLengthSequence = (maxLengthSequence < length) ? length : maxLengthSequence;
        //reset the index
        if(characterIntegerHashSet.get(s.charAt(i)) - i == )
        characterIntegerHashSet.put(s.charAt(i), i);
        length = length-1;
      } else {
        characterIntegerHashSet.put(s.charAt(i), i);
        length++;
        maxLengthSequence = (maxLengthSequence < length) ? length : maxLengthSequence;
      }
    }
    return maxLengthSequence;
  }

  public ListNode addTwoNumbers(ListNode node1, ListNode node2) {
    ListNode root = new ListNode(0);
    ListNode temp = root;
    int carryOver = 0;
    while (node1 != null && node2 != null) {
      int sum = 0;
      sum += node1.val + node2.val + carryOver;
      temp.val = sum % 10;
      carryOver = sum / 10;
      temp.next = new ListNode(0);
      temp = temp.next;
      node1 = node1.next;
      node2 = node2.next;
    }

    while (node1 != null) {
      int sum = 0;
      sum += node1.val + carryOver;
      temp.val = sum % 10;
      carryOver = sum / 10;
      node1 = node1.next;
      temp.next = new ListNode(0);
      temp = temp.next;
    }

    while (node2 != null) {
      int sum = 0;
      sum += node2.val + carryOver;
      temp.val = sum % 10;
      carryOver = sum / 10;
      node2 = node2.next;
      temp.next = new ListNode(0);
      temp = temp.next;
    }

    temp.next = null;
    return root;
  }

  private static class ListNode {
    int val;
    ListNode next;

    public ListNode(int x) {
      val = x;
    }
  }
}
