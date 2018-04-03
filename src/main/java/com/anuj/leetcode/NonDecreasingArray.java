package com.anuj.leetcode;

public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] input = new int[]{
                3, 4, 2, 3
        };
        System.out.println(checkPossibility(input));
    }

    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        int indexOfInversion = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                indexOfInversion = i;
            }
        }

        if (count > 1)
            return false;

        if (nums[indexOfInversion - 1] <= nums[indexOfInversion + 1]) {
            return true;
        } else if (nums[indexOfInversion] <= nums[indexOfInversion + 2]) {
            return true;
        }

        return false;
    }
}
