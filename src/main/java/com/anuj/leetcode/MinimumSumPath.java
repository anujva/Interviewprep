package com.anuj.leetcode;

public class MinimumSumPath {
    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        int[][] minSum = new int[grid.length][grid[0].length];
        minSum[0][0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            minSum[0][i] = minSum[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < grid.length; i++) {
            minSum[i][0] = minSum[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                minSum[i][j] = Math.min(minSum[i-1][j], minSum[i][j-1]) +
                        grid[i][j];
            }
        }
        return minSum[grid.length-1][grid[0].length-1];
    }
}
