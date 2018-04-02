package com.anuj.leetcode;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(addBinary("110", "1"));
    }

    public static String addBinary(String a, String b) {
        String aRev = new StringBuffer(a).reverse().toString();
        String bRev = new StringBuffer(b).reverse().toString();

        int aRevIndex = 0;
        int bRevIndex = 0;
        int carryOver = 0;
        StringBuffer answer = new StringBuffer();
        while (aRevIndex < aRev.length() && bRevIndex < bRev.length()) {
            int currentSum = (aRev.charAt(aRevIndex) - '0') + (bRev.charAt
                    (bRevIndex) - '0') + carryOver;
            answer.append(currentSum % 2);
            carryOver = currentSum / 2;
            aRevIndex++;
            bRevIndex++;
        }
        return answer.reverse().toString();
    }
}