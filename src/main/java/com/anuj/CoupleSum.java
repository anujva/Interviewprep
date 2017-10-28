/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

import java.util.HashMap;

public class CoupleSum {
    public static void main(String[] args) {
        int[] a = new int[] { 2, 3, 4, 7 };
        int[] answer = coupleSum(a, 7);
        System.out.println(answer[0] + ", " + answer[1]);
    }

    public static int[] coupleSum(int[] numbers, int target) {
        HashMap<Integer, Integer> integers = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (integers.containsKey(target - numbers[i])) {
                return new int[] { integers.get(target - numbers[i]) + 1, i + 1 };
            } else {
                integers.put(numbers[i], i);
            }
        }

        return new int[] { -1, -1 };
    }
}
