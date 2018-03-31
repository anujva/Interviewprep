package com.anuj.leetcode;

import java.util.Arrays;

public class SpiralOrderII {

    public static void main(String[] args) {
        int[][] arr = generateMatrix(4);

        Arrays.stream(arr).forEach(x -> {
            Arrays.stream(x).forEach(y -> {
                System.out.print(y + " ");
            });
            System.out.println();
        });
    }

    public static int[][] generateMatrix(int n) {
        int startRowIndex = 0;
        int startColIndex = 0;
        int endRowIndex = n - 1;
        int endColumnIndex = n - 1;

        int[][] arr = new int[n][n];
        int count = 1;
        while (count < n * n + 1) {
            int i = startRowIndex;
            int j = startColIndex;

            for (; j <= endColumnIndex; j++) {
                arr[i][j] = count++;
            }
            j = endColumnIndex;

            for (i = i + 1; i <= endRowIndex; i++) {
                arr[i][j] = count++;
            }
            i = endRowIndex;

            if (count >= n * n + 1) {
                break;
            }
            for (j = j - 1; j >= startColIndex; j--) {
                arr[i][j] = count++;
            }
            j = startColIndex;
            if (count > n * n + 1) {
                break;
            }
            for (i = i - 1; i > startRowIndex; i--) {
                arr[i][j] = count++;
            }
            startColIndex++;
            startRowIndex++;
            endColumnIndex--;
            endRowIndex--;
        }

        return arr;
    }
}
