package com.anuj.leetcode;

public class MinDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("aab", "a"));
        System.out.println(minDistance("pneumonoultramicroscopicsilicovolcanoconiosis",
                "ultramicroscopically"));
    }

    public static int minDistance(String word1, String
            word2) {
        int[][] minDistance = new
                int[word1.length() + 1][word2.length() + 1];

        //update the minDistance array with the
        //initial choices for the min distance.
        minDistance[0][0] = 0; //when both are empty string
        for (int i = 1; i <= word2.length(); i++) {
            minDistance[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            minDistance[i][0] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minDistance[i][j] = minDistance[i - 1][j - 1];
                } else {
                    minDistance[i][j] = Math.min(Math.min(minDistance[i][j - 1],
                            minDistance[i - 1][j]), minDistance[i - 1][j -
                            1]) + 1;
                }
            }
        }

        return minDistance[word1.length()][word2.length()];
    }
}
