package com.anuj;

import java.util.Arrays;

public class SummationSubset {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3, 4
        };
        System.out.println(groupSum(arr, 7));
    }

    public static boolean groupSum(int[] arr, int target) {
        boolean answer = false;
        for (int i = 0; i < arr.length; i++) {
            int[] arrCopy = new int[arr.length - 1];
            int index = 0;
            for (int j = i + 1; j < arr.length; j++) {
                arrCopy[index++] = arr[j];
            }
            if (target - arr[i] == 0) {
                return true;
            }
            answer = answer || groupSum(arrCopy, target - arr[i]);
        }
        return answer;
    }
}
