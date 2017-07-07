package com.anuj;

/**
 * Created by anuj on 5/28/17.
 */
public class SearchInsertPosition {
    public static void main(String[] args) {
        int [] nums = new int[] {
                1,2,3,4,5,7,8,9,10
        };
        int target = 6;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        return binarySearchSubroutine(nums, target, 0, nums.length - 1);
    }

    private static int binarySearchSubroutine(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return startIndex;
        }

        int mid = (startIndex + endIndex) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return binarySearchSubroutine(nums, target, mid + 1, endIndex);
        } else if (nums[mid] > target) {
            return binarySearchSubroutine(nums, target, startIndex, mid - 1);
        }
        return -1;
    }
}
