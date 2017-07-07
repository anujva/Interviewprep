package com.anuj;

import java.util.LinkedList;

/**
 * Created by anuj on 5/26/17.
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(("));
    }

    public static int longestValidParentheses(String s) {
        LinkedList<Character> parentheses = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (!parentheses.isEmpty() && parentheses.getLast() == '(') {
                    parentheses.removeLast();
                    count++;
                }
            } else {
                parentheses.addLast(s.charAt(i));
            }
        }
        return count * 2;
    }
}
