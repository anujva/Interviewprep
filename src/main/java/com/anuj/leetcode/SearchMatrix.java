package com.anuj.leetcode;

public class SearchMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(searchMatrix(matrix, 51));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        //Do a binary search on the rows to pinpoint which row should
        //be searched.
        int rowToSearch = getRowForTarget(matrix, target, 0,
                matrix.length - 1);
        //once we have found the row to search.. its a matter of doing
        //a binary search over the row to find the element.
        if (rowToSearch == -1) return false;
        int column = getColumnForTarget(matrix, target, rowToSearch, 0,
                matrix[0].length - 1);

        if (column == -1) return false;
        return true;
    }

    private static int getColumnForTarget(int[][] matrix, int target,
                                          int rowToSearch, int startIndex,
                                          int endIndex) {
        if (rowToSearch == -1) return -1;
        if (startIndex > endIndex) return -1;
        int mid = startIndex + (endIndex - startIndex) / 2;
        if (matrix[rowToSearch][mid] == target) {
            return mid;
        } else if (matrix[rowToSearch][mid] < target) {
            return getColumnForTarget(matrix, target, rowToSearch,
                    mid + 1, endIndex);
        } else {
            return getColumnForTarget(matrix, target, rowToSearch,
                    startIndex, mid - 1);
        }
    }

    private static int getRowForTarget(int[][] matrix, int target,
                                       int startIndex, int endIndex) {
        //What is this life if full of care we have no time to stand or stare
        //no time to stand beneath the boughs and stare as long as sheep
        if (startIndex > endIndex) return -1;
        int mid = startIndex + (endIndex - startIndex) / 2;
        if (matrix[mid][0] <= target && target <= matrix[mid][matrix[0]
                .length - 1]) {
            return mid;
        } else if (target > matrix[mid][matrix[0].length - 1]) {
            //target lies to the higher rows
            return getRowForTarget(matrix, target, mid + 1, endIndex);
        } else if (matrix[mid][0] > target) {
            //target lies to the lower rows
            return getRowForTarget(matrix, target, startIndex, mid - 1);
        }
        return -1;
    }
}
