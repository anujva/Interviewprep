package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1},
                {4},
                {7}
        };

        List<Integer> answer = spiralOrder(matrix);

        answer.stream().forEach(x -> System.out.print(x + " "));
        System.out.println();
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> answer = new ArrayList<>();
        int row = 0;
        int col = 0;

        while (row <= matrix.length / 2 && col <= matrix[0].length / 2) {
            int i = row;
            int j = col;

            for (; j < matrix[i].length - col; j++) {
                answer.add(matrix[i][j]);
            }
            j--;
            i++;
            for (; i < matrix.length - row; i++) {
                answer.add(matrix[i][j]);
            }
            i--;
            j--;
            for (; j >= col; j--) {
                answer.add(matrix[i][j]);
            }
            j++;
            i--;
            for (; i > row; i--) {
                answer.add(matrix[i][j]);
            }

            row++;
            col++;
        }

        return answer;
    }
}
