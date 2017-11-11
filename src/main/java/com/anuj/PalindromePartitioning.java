
package com.anuj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(minCut("ababababababababababababcbabababababababababababa"));
    }

    public static List<List<String>> partition(String s) {
        Map<String, LinkedList<LinkedList<String>>> memoization = new HashMap<>();
        LinkedList<LinkedList<String>> answerFromRoutine = partitionSubroutine(s, memoization);
        List<List<String>> answerAsList = new ArrayList<>();
        answerAsList.addAll(answerFromRoutine);
        return answerAsList;
    }

    public static int minCut(String s) {
        List<List<String>> partitions = partition(s);
        int min = partitions.get(0).size();
        for (List<String> partition : partitions) {
            if (min > partition.size()) {
                min = partition.size();
            }
        }
        return min - 1;
    }

    public static LinkedList<LinkedList<String>> partitionSubroutine(String s,
        Map<String, LinkedList<LinkedList<String>>> memoization) {
        if (s == null || s.isEmpty()) {
            LinkedList<String> subList = new LinkedList<>();
            LinkedList<LinkedList<String>> subsubList = new LinkedList<>();
            subsubList.add(subList);
            return subsubList;
        }
        if (memoization.containsKey(s)) {
            return memoization.get(s);
        } else {
            LinkedList<LinkedList<String>> answer = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                String sub = s.substring(0, i + 1);
                if (isPalindrome(sub)) {
                    LinkedList<LinkedList<String>> listFromRecursion;
                    listFromRecursion = partitionSubroutine(s.substring(i + 1), memoization);
                    memoization.put(s.substring(i + 1), listFromRecursion);
                    if (listFromRecursion.isEmpty()) {
                        LinkedList<String> newSubList = new LinkedList<>();
                        newSubList.addFirst(sub);
                    } else {
                        for (LinkedList<String> list : listFromRecursion) {
                            list.addFirst(sub);
                        }
                    }
                    answer.addAll(listFromRecursion);
                }
            }
            memoization.put(s, answer);
            return answer;
        }
    }

    private static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (!(str.charAt(i) == str.charAt(str.length() - i - 1))) {
                return false;
            }
        }
        return true;
    }
}
