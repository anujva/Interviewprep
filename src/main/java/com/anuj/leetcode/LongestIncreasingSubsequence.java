package com.anuj.leetcode;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {

    }

    public static int lengthOfLIS(int[] nums) {
        //find the longest increasing subsequence ending in index i.
        int[] lis = new int[nums.length];
        lis[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            int maxLis = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && maxLis < lis[j] + 1) {
                    maxLis = lis[j] + 1;
                }
            }
            lis[i] = maxLis;
        }

        int maxLis = lis[0];
        for (int i = 0; i < nums.length; i++) {
            if (maxLis < lis[i]) {
                maxLis = lis[i];
            }
        }
        return maxLis;
    }
}
