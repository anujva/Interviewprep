package com.anuj;

public class MinimumSumPath {

    public static void main(String[] args) {

    }

    public static int minWeightedPath(int[][] grid) {
        if (grid == null) {
            return 0;
        }
        int[][] minPaths = new int[grid.length][grid[0].length];
        minPaths[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            minPaths[i][0] = minPaths[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < grid[0].length; i++) {
            minPaths[0][i] = minPaths[0][i - 1] + grid[0][i];
        }

        //we have initialized all the values in the first row, first column
        //now we can begin the recursion
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                minPaths[i][j] = Math.min(minPaths[i - 1][j],
                    minPaths[i][j - 1]) + grid[i][j];
            }
        }

        return minPaths[grid.length][grid[0].length];
    }
}
