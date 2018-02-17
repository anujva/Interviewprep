package com.anuj;

import java.util.ArrayList;

public class MatrixMaxSumPathWithDFS {

  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {1, 2, 3, 4, 5, 6, 7},
        {1, 2, 3, 4, 5, 6, 7},
        {1, 2, 3, 4, 5, 6, 7},
        {1, 2, 3, 4, 5, 6, 7}
    };
    System.out.println(matrixMaxSumDfs(grid));
  }

  public static int matrixMaxSumDfs(int[][] grid) {
    ArrayList<Integer> allSums = new ArrayList<>();
    matrixMaxSumDfs(grid, 0, 0, 0, allSums);

    int max = allSums.get(0);
    for (int i = 0; i < allSums.size(); i++) {
      if (max < allSums.get(i)) {
        max = allSums.get(i);
      }
    }
    return max;
  }

  public static void matrixMaxSumDfs(int[][] grid,
      int i, int j, int sum,
      ArrayList<Integer> allSums) {
    if (i > grid.length - 1) {
      return;
    }
    if (j > grid[0].length - 1) {
      return;
    }

    if (i == grid.length - 1 && j == grid[0].length - 1) {
      //we are here with the max sum
      allSums.add(sum + grid[i][j]);
    }
    matrixMaxSumDfs(grid, i + 1, j, sum + grid[i][j], allSums);
    matrixMaxSumDfs(grid, i, j + 1, sum + grid[i][j], allSums);
  }
}
