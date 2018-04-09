package com.anuj.leetcode;

public class ConstructAllPossibleBST {
    public static void main(String[] args) {
        System.out.println(constructBST(3));
    }

    public static int constructBST(int n) {
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = i + 1;
        }

        return constructBST(num);
    }

    private static int constructBST(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;

        int totalNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int[] left = getLeft(nums, i);
            int[] right = getRight(nums, i);
            int totalLeft = constructBST(left);
            int totalRight = constructBST(right);
            //at this stage.. what is the total left?
            //what is the total right?
            totalNum = totalLeft + totalRight;
        }
        return totalNum;
    }

    private static int[] getLeft(int[] nums, int index) {
        if (index == 0) {
            return null;
        }
        int[] left = new int[index];
        for (int i = 0; i < index; i++) {
            left[i] = nums[i];
        }
        return left;
    }

    private static int[] getRight(int[] nums, int index) {
        if (index == nums.length - 1) {
            return null;
        }

        int[] right = new int[nums.length - index - 1];
        for (int i = 0; i < nums.length - index - 1; i++) {
            right[i] = nums[index + 1 + i];
        }
        return right;
    }
}
