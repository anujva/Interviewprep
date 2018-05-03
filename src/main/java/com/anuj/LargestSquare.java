package com.anuj;

public class LargestSquare {

    public static void main(String[] args) {
        char[][] matrix = new char[][]{
            {'1', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '0', '0', '0'}
        };
        System.out.println(largestSquare(matrix));
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
        //Keep a count of the running maximum.. if the value
        //cannot be produced by a smaller value of the d.
        //no need to calculate.. just break and go ahead.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    largestSquareMatrixMemo[i][j][0] = 1;
                } else {
                    largestSquareMatrixMemo[i][j][0] = 0;
                }
                for (int k = 1; k < d; k++) {
                    largestSquareMatrixMemo[i][j][k] = -1; //indicates
                    // its not been calculated yet.
                }
            }
        }

        //if the value for the i, j, k is zero for a certain index,
        //that means that it wasn't possible to create a square
        int max = -1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //what should be max value of d?
                //from that point to the end
                int dist = matrix.length - 1 - i <
                    matrix[0].length - 1 - j ? matrix.length - 1 - i
                    : matrix[0].length - 1 - j;
                for (int k = dist; k > -1; k--) {
                    if (max >= k) {
                        continue;
                    }
                    int val = fillInValuesInMemoAndReturn(matrix, i,
                        j, k, dist, largestSquareMatrixMemo);
                    if (val == 1 && max < k) {
                        max = k;
                    }
                }
            }
        }
        return (max + 1) * (max + 1);
    }

    private static int fillInValuesInMemoAndReturn(char[][] matrix,
        int rowIndex, int columnIndex, int distance, int maxDistance,
        int[][][] largestSqMatMemo) {
        //in order to decide, we will need to create a call stack
        if (rowIndex < matrix.length && columnIndex < matrix[0].length) {
            if (largestSqMatMemo[rowIndex][columnIndex][distance] != -1) {
                return largestSqMatMemo[rowIndex][columnIndex][distance];
            } else {
                //find its sub components
                if (matrix[rowIndex][columnIndex] != '1') {
                    for (int i = 0; i < maxDistance; i++) {
                        largestSqMatMemo[rowIndex][columnIndex][i] = 0;
                    }
                    return 0;
                }
                //this means that the value in the matrix is one for this
                //row and column. Moving right along
                int left = -3;
                if (rowIndex + 1 < matrix.length) {
                    left = fillInValuesInMemoAndReturn(matrix, rowIndex + 1,
                        columnIndex, distance - 1,
                        maxDistance, largestSqMatMemo);
                }
                int right = -3;
                if (columnIndex + 1 < matrix[0].length) {
                    right = fillInValuesInMemoAndReturn(matrix, rowIndex,
                        columnIndex + 1, distance - 1,
                        maxDistance, largestSqMatMemo);
                }

                int diagonal = -3;
                if (rowIndex + 1 < matrix.length && columnIndex + 1
                    < matrix[0].length) {
                    diagonal = fillInValuesInMemoAndReturn(matrix,
                        rowIndex + 1, columnIndex + 1,
                        distance - 1, maxDistance, largestSqMatMemo);
                }

                if (left == -3 || right == -3 || diagonal == -3) {
                    //this should have already returned cause of the precalculation.
                    largestSqMatMemo[rowIndex][columnIndex][distance] = 0;
                    return 0;
                } else {
                    //This means that the square is good in all the 
                    //different directions and we should just 
                    if (left == 1 && right == 1 && diagonal == 1
                        && matrix[rowIndex][columnIndex] == '1') {
                        largestSqMatMemo[rowIndex][columnIndex][distance] = 1;
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
