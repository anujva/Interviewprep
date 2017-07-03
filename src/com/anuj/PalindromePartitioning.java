package com.anuj;

import java.util.ArrayList;
import java.util.List;

import static com.anuj.ValidPalindrome.isPalindrome;

/**
 * Created by anuj on 6/2/17.
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(partition("aab"));
    }

    public static List<List<String>> partition(String s) {
        //partition the string in such a way that all partitions are
        //palindromes
        List<List<String>> listOfStringLists = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            //check if palindrome.
            if (isPalindrome(s.substring(0, i))) {
                List<String> stringList = new ArrayList<>();
                stringList.add(s.substring(0, i + 1));
            }
        }
        return listOfStringLists;
    }

    private static List<String> partitionSubroutine(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }
        for (int i = 0; i < s.length(); i++) {
            //check if palindrome.
            if (isPalindrome(s.substring(0, i + 1))) {
                List<String> stringList1 = new ArrayList<>();
                stringList1.add(s.substring(0, i + 1));
                stringList1.addAll(partitionSubroutine(s.substring(i + 1)));
            }
        }
        return null;
    }
}
