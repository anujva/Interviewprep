package com.anuj.leetcode;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetZerosMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
            {1, 3, 5, 0}, {1, 5, 3, 1}, {2, 5, 8, 9}
        };
        setZeros(matrix);
        Arrays.stream(matrix).forEach(x -> {
            Arrays.stream(x).boxed().forEach(y -> {
                System.out.print(y + " ");
            });
            System.out.println();
        });
    }

    public static void setZeros(int[][] matrix) {
        Set<Integer> rowsToSetZero = new LinkedHashSet<>();
        Set<Integer> columnsToSetZero = new LinkedHashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                //what I am trying to do is to keep track of the
                if (matrix[i][j] == 0) {
                    rowsToSetZero.add(i);
                    columnsToSetZero.add(j);
                }
            }
        }

        //Set the rows and columns to zeros now.
        for (Integer row : rowsToSetZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i] = 0;
            }
        }

        for (Integer column : columnsToSetZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][column] = 0;
            }
        }
    }
}
