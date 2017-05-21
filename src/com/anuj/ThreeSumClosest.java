package com.anuj;

/**
 * Created by anuj on 5/19/17.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j + 1 >= nums.length) {
                    continue;
                }
                int targetValue = target - (nums[i] + nums[j]);
                //compare it to the rest of the differences and see if
                //we need to update the minimum
                for (int k = j + 1; k < nums.length; k++) {
                    int difference = Math.abs(nums[k] - targetValue);
                    if (difference < minimum) {
                        minimum = difference;
                    }
                }
            }
        }
        return minimum;
    }
}
