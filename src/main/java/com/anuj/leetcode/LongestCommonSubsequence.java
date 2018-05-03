package com.anuj.leetcode;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(lcs("ABCDGH", "AEDFHR"));
        System.out.println(lcs("AGGTAB", "GXTXAYB"));
    }

    public static int lcs(String str1, String str2) {
        int[][] lcs = new int[str1.length() + 1][str2.length() + 1];

        lcs[0][0] = 0; //both strings are empty.. so the longest common subsequence is also empty

        //if one string is empty and the length of the longest common
        //subsequence is going to be 0 always
        for (int i = 0; i < str2.length(); i++) {
            lcs[0][i] = 0;
        }

        for (int i = 0; i < str1.length(); i++) {
            lcs[i][0] = 0;
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    //if these two are equal
                    //find the max lcs and add 1;
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(Math.max(lcs[i][j - 1], lcs[i - 1][j]), lcs[i - 1][j - 1]);
                }
            }
        }

        return lcs[str1.length()][str2.length()];
    }
}
