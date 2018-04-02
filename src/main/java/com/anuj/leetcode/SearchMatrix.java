package com.anuj.leetcode;

public class SearchMatrix {
    public static void main(String[] args) {

    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        //Do a binary search on the rows to pinpoint which row should
        //be searched.
        int rowToSearch = getRowForTarget(matrix, target);
    }

    private static int getRowForTarget(int[][] matrix, int target) {

    }
}
