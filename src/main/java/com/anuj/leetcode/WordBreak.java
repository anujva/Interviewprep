package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>(Arrays.asList(
                "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"
        ));
        System.out.println(wordBreak(
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Set<String> wordDictSet = new HashSet<>(wordDict);
        for (int i = 1; i < s.length() + 1; i++) {
            if (wordDictSet.contains(s.substring(0, i))) {
                if (wordBreak(s.substring(i), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }
}
