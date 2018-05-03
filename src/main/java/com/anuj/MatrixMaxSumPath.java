package com.anuj;

public class MatrixMaxSumPath {

  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {1,2,3,4,5,6,7},
        {1,2,3,4,5,6,7},
        {1,2,3,4,5,6,7},
        {1,2,3,4,5,6,7}
    };
    System.out.println(matrixMaxSumDP(grid));
  }

  public static int matrixMaxSumDP(int[][] grid) {
    int[][] max = new int[grid.length][grid[0].length];

    //initialize
    max[0][0] = grid[0][0];
    for (int i = 1; i < grid.length; i++) {
      max[0][i] = max[0][i - 1] + grid[0][i];
    }
    for (int i = 1; i < grid.length; i++) {
      max[i][0] = max[i - 1][0] + grid[i][0];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        max[i][j] = Math.max(max[i - 1][j], max[i][j - 1]) + grid[i][j];
      }
    }

    return max[grid.length - 1][grid[0].length - 1];
  }
}
