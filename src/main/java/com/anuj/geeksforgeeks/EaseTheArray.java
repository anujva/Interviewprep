package com.anuj.geeksforgeeks;

import java.util.Arrays;

public class EaseTheArray {
    public static void main(String[] args) {
        int[] arr = new int[]{
                0, 2, 2, 2, 0, 6, 6, 0, 0, 8
        };
        int[] arr1 = easeTheArray(arr);
//        Arrays.stream(arr1).forEach(x -> System.out.println(x));
        int[][] arr2 = new int[][]{
                {1, 2, 3, 4, 6},
                {5, 7, 8, 9, 10}
        };
        Arrays.stream(arr2).forEach(x -> Arrays.stream(x).forEach(y -> System
                .out.println(y)));
    }

    public static int[] easeTheArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                arr[i] = 0;
                arr[i - 1] = arr[i - 1] * 2;
                i++;
            }
        }

        int index0 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && index0 == -1) {
                index0 = i;
                continue;
            }
            if (arr[i] != 0) {
                if (index0 != -1) {
                    int temp = arr[i];
                    arr[i] = arr[index0];
                    arr[index0] = temp;
                    index0++;
                }
            }
        }

        return arr;
    }
}
