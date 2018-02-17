package com.anuj;

public class ImageManipulation {

  public static void main(String[] args) {

  }

  public static int[][] rotate(int[][] matrix) {
    spinOnCenterAxis(matrix);
    spinOnDiagonal(matrix);
    return matrix;
  }

  private static void spinOnCenterAxis(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix.length / 2; j++) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[i][matrix.length - 1 - j];
        matrix[i][matrix.length - 1 - j] = temp;
      }
    }
  }

  private static void spinOnDiagonal(int[][] matrix) {

  }
}
