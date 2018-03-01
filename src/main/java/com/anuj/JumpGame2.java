package com.anuj;

public class JumpGame2 {

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        boolean[] canJumpDynamic = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            canJumpDynamic[i] = false;
        }
        if (nums[0] > 0) {
            canJumpDynamic[0] = true;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i <= nums[i] && canJumpDynamic[i] == true) {
                    canJumpDynamic[j] = true;
                }
            }
        }

        return canJumpDynamic[nums.length - 1];
    }

    public int jump(int[] nums) {
        //start off at index 0;
        //no of indices reachable.
        return jumpSubroutine(nums, 0);
    }

    public int jumpSubroutine(int[] nums, int currentIndex) {
        return 0;
    }

}