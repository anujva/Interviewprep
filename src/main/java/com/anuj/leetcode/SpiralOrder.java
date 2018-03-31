package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
        };

        List<Integer> answer = spiralOrder(matrix);
        answer.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        if (matrix.length == 0) return spiralList;
        int startIndexRow = 0;
        int startIndexCol = 0;
        int endIndexRow = matrix.length - 1;
        int endIndexCol = matrix[0].length - 1;
        //find which is minimum row or column.
        //if there are only 1 rows then its just a list
        //same when its just 1 column.
        while (startIndexCol <= matrix[0].length / 2 &&
                startIndexRow <= matrix.length / 2) {
            int i = startIndexRow;
            int j = startIndexCol;
            for (; j <= endIndexCol; j++) {
                spiralList.add(matrix[i][j]);
            }
            j = endIndexCol;
            for (i = i + 1; i <= endIndexRow; i++) {
                spiralList.add(matrix[i][j]);
            }
            i = endIndexRow;
            j = endIndexCol - 1; // j should never go out of bounds
            if (endIndexRow - startIndexRow > 0) {
                for (; j >= startIndexCol; j--) {
                    spiralList.add(matrix[i][j]);
                }
            }
            i = endIndexRow - 1; // i should never go out of bounds
            j = startIndexCol;
            if (endIndexCol - startIndexCol > 0) {
                for (; i > startIndexRow; i--) {
                    spiralList.add(matrix[i][j]);
                }
            }
            startIndexCol++;
            startIndexRow++;
            endIndexCol--;
            endIndexRow--;
        }

        return spiralList;
    }
}
