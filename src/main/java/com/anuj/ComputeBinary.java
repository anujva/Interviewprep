package com.anuj;

public class ComputeBinary {

    public static void main(String[] args) {
        System.out.println(computeBinary(2));
        System.out.println(reverseInt(10008));
    }

    public static String computeBinary(int val) {
        if (val == 0) {
            return "0";
        }
        if (val == 1) {
            return "1";
        }
        return computeBinary(val / 2) + val % 2;
    }

    public static int reverseInt(int x) {
        int sum = 0;
        while(x != 0) {
            sum = 10*sum + x%10;
            x = x/10;
        }
        return sum;
    }
}
