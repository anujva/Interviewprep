package com.anuj;

/**
 * Created by anuj on 5/24/17.
 */
public class SearchInRotatedArray {
    public static void main(String[] args) {
        int[] sortedRotatedArray = new int[]{
                5, 6, 7, 1, 2, 3, 4
        };
        int target = 8;
        System.out.println(search(sortedRotatedArray, target));
    }

    public static int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
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
        } else if (nums[mid] < nums[high] && (target > nums[mid] && target <
                nums[high])) {
            return binarySearch(nums, mid + 1, high - 1, target);
        } else if (nums[low] < nums[mid] && (target > nums[low] && target <
                nums[mid])) {
            return binarySearch(nums, low + 1, mid - 1, target);
        } else if (nums[mid] < nums[high]) {
            return binarySearch(nums, low + 1, mid - 1, target);
        } else if (nums[low] < nums[mid]) {
            return binarySearch(nums, mid + 1, high - 1, target);
        }
        return -1;
    }
}
