package com.anuj;

public class MaximumSubarray {
    public static void main(String[] args) {
        System.out.println(new MaximumSubarray().maxSubArray(new int[] {
                8,-19,5,-4,20
        }));
    }

    //I have the O(n^2) solution which is pretty straight fwd.
    //I know there is an O(1) solution for this as well.
    //And there is a divide and conquer approach to solving this problem.
    public int maxSubArray(int[] nums) {
        int[] maxVal = new int[nums.length];

        maxVal[0] = nums[0];
        int runningSum = nums[0];
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (runningSum + nums[i] > maxVal[i - 1] && runningSum + nums[i]
                    > nums[i]) {
                maxVal[i] = runningSum + nums[i];
                runningSum = maxVal[i];
                endIndex = i;
            } else if(runningSum + nums[i] > maxVal[i-1] && runningSum +
                    nums[i] <= nums[i]) {
                maxVal[i] = nums[i];
                runningSum = nums[i];
                startIndex = i;
                endIndex = i;
            } else if (runningSum + nums[i] <= maxVal[i - 1] && runningSum +
                    nums[i] > nums[i]) {
                maxVal[i] = maxVal[i - 1];
                runningSum = runningSum + nums[i];
            } else if (runningSum + nums[i] <= maxVal[i - 1] && runningSum +
                    nums[i] <= nums[i]) {
                if(maxVal[i-1] < nums[i]) {
                    maxVal[i] = nums[i];
                    runningSum = nums[i];
                    startIndex = i;
                    endIndex = i;
                } else {
                    maxVal[i] = maxVal[i-1];
                }
                runningSum = nums[i];
            }
        }
        return maxVal[nums.length-1];
    }
}
