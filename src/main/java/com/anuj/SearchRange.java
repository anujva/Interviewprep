
package com.anuj;

public class SearchRange {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 2, 3, 4, 5, 5, 6, 6, 7, 7, 7, 8, 8, 9, 10, 10, 10
        };
        int[] indices = searchRange(arr, 7);
        System.out.println(indices[0] + " " + indices[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        //the idea is to find the lowest index and the highest index of the target value.
        //search for the value in the array.. if you find it.. still keep searching till you find the value
        //at the highest and the lowest indices.
        int[] indices = searchRangeSubroutine(nums, target, 0, nums.length - 1);
        return indices;
    }

    private static int[] searchRangeSubroutine(int[] nums, int target, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return new int[]{-1, -1};
        }
        int mid = (startIndex + endIndex) / 2;
        int[] temp = new int[]{-1, -1};
        if (nums[mid] == target) {
            //lets say we find it..
            int[] temp1 = searchRangeSubroutine(nums, target, mid + 1, endIndex);
            int highestIndex = temp1[1];
            int[] temp2 = searchRangeSubroutine(nums, target, startIndex, mid - 1);
            int lowestIndex = temp2[0];
            if (highestIndex == -1) {
                temp[1] = mid;
            } else if (highestIndex < mid) {
                temp[1] = mid;
            } else {
                temp[1] = highestIndex;
            }
            if (lowestIndex == -1) {
                temp[0] = mid;
            } else if (lowestIndex > mid) {
                temp[0] = mid;
            } else {
                temp[0] = lowestIndex;
            }
        } else if (nums[mid] < target) {
            int[] temp1 = searchRangeSubroutine(nums, target, mid + 1, endIndex);
            temp[0] = temp1[0];
            temp[1] = temp1[1];
        } else if (nums[mid] > target) {
            int[] temp1 = searchRangeSubroutine(nums, target, startIndex, mid - 1);
            temp[0] = temp1[0];
            temp[1] = temp1[1];
        }
        return temp;
    }
}
