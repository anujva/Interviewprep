package com.anuj;

/**
 * Created by anuj on 7/5/17.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{-1, -2, 0, 2, 3}));
    }

    public static int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;
        //find the positive max value in the array.
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        int[] numsList = new int[max];

        for (int i = 0; i < max; i++) {
            numsList[i] = 2;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) continue;
            numsList[nums[i] - 1] = -1;
        }

        for (int i = 0; i < max; i++) {
            if (numsList[i] > -1) {
                return i + 1;
            }
        }
        return max + 1;
    }
}
