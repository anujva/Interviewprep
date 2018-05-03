package com.anuj;

/**
 * Created by anuj on 5/24/17.
 */
public class SearchSortedRotated {
    public static void main(String[] args) {
        int [] arr = new int [] {
                1,2,3,4,5
        };
        System.out.println(search(arr, 4));
    }

    public static int search(int[] nums, int target) {
        return binarySearchSubroutine(nums, 0, nums.length - 1, target);
    }

    private static int binarySearchSubroutine(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;

        if (nums[mid] == target) {
            return mid;
        } else if (nums[low] == target) {
            return low;
        } else if (nums[high] == target) {
            return high;
        } else if (nums[mid] < nums[high] && (target > nums[mid] && target < nums[high])) {
            return binarySearchSubroutine(nums, mid + 1, high - 1, target);
        } else if (nums[mid] < nums[high]) {
            return binarySearchSubroutine(nums, low + 1, mid - 1, target);
        } else if (nums[mid] > nums[high] && (target > nums[low] && target < nums[mid])) {
            return binarySearchSubroutine(nums, low + 1, mid - 1, target);
        } else if (nums[mid] > nums[high]) {
            return binarySearchSubroutine(nums, mid + 1, high - 1, target);
        }

        return -1;
    }
}
