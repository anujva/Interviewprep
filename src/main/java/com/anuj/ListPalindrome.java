/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

import java.util.ArrayList;
import java.util.List;

public class ListPalindrome {
    public static void main(String[] args) {

    }

    public static Boolean isListPalindrome(ListNode head) {
        //create a new array with all the values with all the nodes reversed.
        if (head == null) {
            return true;
        }
        ListNode temp = head;
        List<Integer> values = new ArrayList<>();
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        for (int i = 0; i < values.size() / 2; i++) {
            if (values.get(i) != values.get(values.size() - 1)) {
                return false;
            }
        }
        return true;
    }
}
