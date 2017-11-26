package com.anuj;

public class SubsetSummation {
    public static void main(String[] args) {
        int[] arr = new int[]{
                1, 2, 3, 6, 5
        };
        System.out.println(groupSum(arr, 18));
    }

    public static boolean groupSum(int[] arr, int target) {
        //What is it that I need to do for this one?
        //what ever is the target, I need to see if I can find
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
