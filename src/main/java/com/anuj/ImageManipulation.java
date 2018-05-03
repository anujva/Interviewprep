package com.anuj;

public class ImageManipulation {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotate(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
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
        //Need to swap images around the diagonal
        for (int i = 0; i < matrix.length; i++) {
            //diagonal row is same but the column == matrix.length-1 - i;
            for (int j = 0; j < matrix.length - i - 1; j++) {
                //for the current index (i, j) find
                //the distanceFrom diagonal to the
                //right.
                int distance = matrix.length - 1 - i - j;
                swap(matrix, i, j, i + distance, matrix.length - 1 - i);
            }
        }
    }

    private static void swap(int[][] matrix, int i, int j, int otheri, int otherj) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[otheri][otherj];
        matrix[otheri][otherj] = temp;
    }
}
