package com.anuj;

public class LargestSquare {

    public static void main(String[] args) {

    }

    public static int largestSquare(char[][] matrix) {
        //What is the best way to find the matrix
        //It will have to be a square no matter what.
        //so the largest square can be least of the rows or columns
        //length.
        final int d = matrix.length < matrix[0].length ? matrix.length
            : matrix[0].length;
        int[][][] largestSquareMatrixMemo = new
            int[matrix.length][matrix[0].length][d];

        //Now we need to initialize the values. [i][j][0] = 1 always
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                largestSquareMatrixMemo[i][j][0] = 1;
                for (int k = 1; k < d; k++) {
                    largestSquareMatrixMemo[i][j][k] = -1; //indicates
                    // its not been calculated yet.
                }
            }
        }
        return -1;
    }
}
