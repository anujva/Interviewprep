package com.anuj.leetcode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        Arrays.stream(plusOne(new int[] {
                9,9
        })).boxed().forEach(x -> System.out.print(x));
        System.out.println();
    }

    public static int[] plusOne(int[] digits) {
        boolean carryOver = true;
        int carryOverValue = 0;
        int index = digits.length - 1;
        while (carryOver) {
            int digit = digits[index] + 1;
            digits[index] = digit % 10;
            carryOverValue = digit / 10;
            if (carryOverValue == 0 || index == 0) {
                carryOver = false;
            }
            index--;
        }

        if (carryOverValue > 0) {
            int[] digitsNew = new int[digits.length + 1];
            digitsNew[0] = carryOverValue;
            for (int i = 0; i < digits.length; i++) {
                digitsNew[i + 1] = digits[i];
            }
            return digitsNew;
        }
        return digits;
    }
}
