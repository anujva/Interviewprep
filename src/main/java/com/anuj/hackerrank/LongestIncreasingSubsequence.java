package com.anuj.hackerrank;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        System.out.println(longestIncreasingSubsequence(new int[]{
                15, 27, 14, 38, 26, 55, 46, 65, 85
        }));
    }

    public static int longestIncreasingSubsequence(int[] arr) {
        int[] lis = new int[arr.length];
        lis[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (lis[j] > max) {
                        max = lis[j];
                    }
                }
            }
            lis[i] = max + 1;
        }
        int max = lis[0];
        for (int i = 0; i < arr.length; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }

        return max;
    }
}
