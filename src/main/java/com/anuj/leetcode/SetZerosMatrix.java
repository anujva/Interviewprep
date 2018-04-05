package com.anuj.leetcode;

import java.util.LinkedHashSet;
import java.util.Set;

public class SetZerosMatrix {

    public static void main(String[] args) {

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
