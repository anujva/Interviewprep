package com.anuj;

import java.util.ArrayList;

public class Snake {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 5},
                {4, 5, 6, 7},
                {7, 8, 9, 10}
        };
        ArrayList<Integer> answer = findSpiral(arr);
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
    }

    public static ArrayList<Integer> findSpiral(int[][] arr) {
        int rowStart = 0;
        int rowEnd = arr.length - 1;
        int colStart = 0;
        int colEnd = arr[0].length - 1;
        ArrayList<Integer> answer = new ArrayList<>();
        while (rowEnd - rowStart > -1 && colEnd - colStart > -1) {
            answer.addAll(moveSpirally(arr, rowStart, rowEnd, colStart, colEnd));
            rowStart = rowStart + 1;
            rowEnd = rowEnd - 1;
            colStart = colStart + 1;
            colEnd = colEnd - 1;
        }
        return answer;
    }

    public static ArrayList<Integer> moveSpirally(int[][] arr, int rowStart, int rowEnd, int colStart, int colEnd) {
        if (rowStart < 0 || rowEnd < 0 || colStart < 0 || colEnd < 0) return new ArrayList<>();
        int index = 0;
        ArrayList<Integer> answer = new ArrayList<>();
        while (colStart + index <= colEnd) {
            answer.add(arr[rowStart][colStart + index]);
            index++;
        }
        index = 1;
        while (rowStart + index <= rowEnd) {
            answer.add(arr[rowStart + index][colEnd]);
            index++;
        }
        if(rowStart == rowEnd) return answer;
        index = colEnd - 1;
        while (colStart + index > -1) {
            answer.add(arr[rowEnd][colStart + index]);
            index--;
        }
        index = rowEnd - 1;
        while (rowStart + index > 0) {
            answer.add(arr[rowStart + index][colStart]);
            index--;
        }
        return answer;
    }
}
