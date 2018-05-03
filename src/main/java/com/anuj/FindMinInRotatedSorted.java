package com.anuj;

public class FindMinInRotatedSorted {

    public static void main(String[] args) throws Exception {
        boolean[] test = new boolean[5];
        for (int i = 0; i < 5; i++) {
            System.out.println(test[i]);
        }
        System.out.println(findMin(new int[]{5, 6, 7, 1, 2, 3, 4}));
    }

    public static int findMin(int[] arr) throws Exception {
        if (arr.length == 0) {
            throw new Exception("empty not allowed");
        }
        if (arr.length == 1) {
            return arr[0];
        }
        if (arr.length == 2) {
            return arr[0] < arr[1] ? arr[0] : arr[1];
        }
        int mid = arr.length / 2;
        if (arr[mid] < arr[arr.length - 1]) {
            //all the values are sorted
            int[] cpArr = copyTillMid(arr, mid);
            return findMin(cpArr);
        } else if (arr[mid] > arr[arr.length - 1]) {
            int[] cpArr = copyFromMid(arr, mid);
            return findMin(cpArr);
        }
        return -2;
    }

    private static int[] copyFromMid(int[] arr, int mid) {
        int[] cpArr = new int[arr.length - mid - 1];
        for (int i = mid + 1; i < arr.length; i++) {
            cpArr[i - mid - 1] = arr[i];
        }
        return cpArr;
    }

    private static int[] copyTillMid(int[] arr, int mid) {
        int[] cpArr = new int[mid + 1];
        for (int i = 0; i < mid + 1; i++) {
            cpArr[i] = arr[i];
        }
        return cpArr;
    }
}
