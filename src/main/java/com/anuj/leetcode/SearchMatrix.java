package com.anuj.leetcode;

public class SearchMatrix {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //Do a binary search on the rows to pinpoint which row should
        //be searched.
        int rowToSearch = getRowForTarget(matrix, target, 0,
                matrix.length - 1);
    }

    private static int getRowForTarget(int[][] matrix, int target,
                                       int startIndex, int endIndex) {
        //What is this life if full of care we have no time to stand or stare
        //no time to stand beneath the boughs and stare as long as sheep
        int mid = startIndex + (endIndex - startIndex) / 2;
        if(matrix[mid][0] <= target && target <= matrix[mid][matrix[0].length-1]) {
            return mid;
        } if(matrix[mid][0] < target && target > matrix[mid][matrix[0].length-1]) {
            //target lies to the higher rows
            return getRowForTarget(matrix, target, mid+1, endIndex);
        } else if(matrix[mid][0] > target) {
            //target lies to the lower rows
            return getRowForTarget(matrix, target, startIndex, mid-1);
        }
    }
}
