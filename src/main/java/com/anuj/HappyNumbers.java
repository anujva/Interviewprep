/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

public class HappyNumbers {
    public static void main(String[] args) {
        System.out.println(isHappyNumber(100));
    }

    public static boolean isHappyNumber(int n) {
        if (n == 1) {
            return true;
        }
        if (n < 10) {
            return false;
        }
        int num = sumOfSqDig(n);
        return isHappyNumber(num);
    }

    public static int sumOfSqDig(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n = n / 10;
        }
        return sum;
    }
}
