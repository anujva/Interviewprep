package com.anuj;

import java.util.ArrayList;
import java.util.List;

public class SubSetSummationWithNumberConstraint {

    public static void main(String[] args) {
        System.out.println(groupSumWithNum(new int[]{1,2,3,6,5},
            3, 7));
    }

    public static boolean groupSumWithNum(int[] arr, int must_have, int target) {
        //this devolves into the problem groupSumWithNum target
        List<Integer> arrWithoutVal = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != must_have) {
                arrWithoutVal.add(arr[i]);
            }
        }

        int[] arrWithoutValArr = new int[arrWithoutVal.size()];
        if (arrWithoutVal.size() == arr.length) {
            return groupSumWithNum(arrWithoutVal.stream().
                mapToInt(i -> i).toArray(), target);
        }
        return groupSumWithNum(arrWithoutVal.stream().mapToInt(i -> i)
            .toArray(), target - must_have);
    }

    public static boolean groupSumWithNum(int[] arr, int target) {
        if (arr == null) {
            return false;
        }
        if (arr.length == 1) {
            return arr[0] == target;
        }

        if (arr[0] == target) {
            return true;
        }

        int[] arrWithoutVal = new int[arr.length - 1];

        for (int i = 1; i < arr.length; i++) {
            arrWithoutVal[i - 1] = arr[i];
        }

        return groupSumWithNum(arrWithoutVal, target) ||
            groupSumWithNum(arrWithoutVal, target - arr[0]);
    }
}
