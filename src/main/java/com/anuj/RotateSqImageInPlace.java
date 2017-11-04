package com.anuj;

public class RotateSqImageInPlace {
    public static void main(String[] args) {
        int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        printRowByRow(matrix);
        rotateSquareImageCW(matrix);
        printRowByRow(matrix);
    }

    public static void printRowByRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotateSquareImageCW(int[][] matrix) {
        TransposeMatrix.transposeMatrix(matrix);
        TransposeMatrix.flipVertically(matrix);
    }

    public static void rotateSquareImageCCW(int[][] matrix) {
        TransposeMatrix.transposeMatrix(matrix);
        TransposeMatrix.flipHorizontally(matrix);
    }


}
