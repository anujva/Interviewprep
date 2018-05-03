package com.anuj.leetcode;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {

    }

    public static double findMedianSortedArrays(int[] nums1,
                                                int[] nums2) {
        //find median sorted array
        //if the array
        int startIndexNums1 = 0;
        int endIndexNums1 = nums1.length - 1;

        int startIndexNums2 = 0;
        int endIndexNums2 = nums2.length - 1;

        findMedianSortedArrays(nums1, startIndexNums1, endIndexNums1,
                nums2, startIndexNums2, endIndexNums2);
        return 0.0;
    }

    public static double findMedianSortedArrays(int[] nums1, int startIndexNums1,
                                                int endIndexNums1, int[] nums2, int startIndexNums2,
                                                int endIndexNums2) {
        int medianIndexNums1 = (startIndexNums1 + endIndexNums1) / 2;
        int medianIndexNums2 = (startIndexNums2 + endIndexNums2) / 2;

        //compare the elements here. And then make a choice.
        if (nums1[medianIndexNums1] < nums2[medianIndexNums2]) {
            //can we glean something from a compare like this?
        }
        return 0.0;
    }
}
