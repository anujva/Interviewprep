package com.anuj;

/**
 * Created by anuj on 5/23/17.
 */
public class MaximumSubArrayLength {
    public static void main(String[] args) {
        System.out.println(maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 2));
    }

    public static int maxSubArrayLen(int[] nums, int k) {
        int[][] dp = new int[nums.length][nums.length];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    int length = j - i + 1;
                    if (maxLength < length) {
                        maxLength = length;
                    }
                }
            }
        }
        return maxLength == Integer.MIN_VALUE ? 0 : maxLength;
    }
}
