package com.anuj;

public class SplitArray {
    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{1, 2, 4}));
    }

    public static boolean splitArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 == 0) {
            return findSubArray(sum / 2, arr);
        }
        return false;
    }

    private static boolean findSubArray(int target, int[] arr) {
        if (arr == null || arr.length == 0) return false;
        if (target == arr[0]) {
            return true;
        }
        int[] arrNew = new int[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            arrNew[i - 1] = arr[i];
        }
        return findSubArray(target - arr[0], arrNew) || findSubArray(target, arrNew);
    }
}
