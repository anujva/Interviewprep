package com.anuj.leetcode;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings("011"));
    }

    public static int numDecodings(String s) {
        if (s.length() == 1) {
            if (Integer.parseInt(s) > 0)
                return 1;
            else
                return 0;
        }

        if (s.length() == 2) {
            if (Integer.parseInt(s) < 27 && Integer.parseInt(s) > 10) {
                return 2;
            } else if (Integer.parseInt(s) == 0 || Integer.parseInt(s.substring(0,1)) == 0) {
                return 0;
            } else {
                return 1;
            }
        }
        int count = 0;
        if(s.charAt(0) == '0') {
            return 0;
        }

        if (s.charAt(0) != 0) {
            count += numDecodings(s.substring(1));
        }

        if (Integer.parseInt(s.substring(0, 2)) < 27 && Integer.parseInt(s.substring(0, 2)) > 9) {
            count += numDecodings(s.substring(2));
        }

        return count;
    }
}
