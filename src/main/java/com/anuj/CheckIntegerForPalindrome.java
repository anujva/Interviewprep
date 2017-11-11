
package com.anuj;

public class CheckIntegerForPalindrome {
    public static void main(String[] args) {
        System.out.println(isIntPalindrome(-1));
    }

    public static Boolean isIntPalindrome(int x) {
        //This will require checking if the first and the last digits are
        //the same. We will need to find out the first and last digit
        //and compare.
        int y = reverseInt(x);
        if (y == x) {
            return true;
        }
        return false;
    }

    public static int reverseInt(int x) {
        int number = x % 10;
        x = x / 10;
        while (x != 0) {
            number = number * 10 + x % 10;
            x = x / 10;
        }
        return number;
    }
}
