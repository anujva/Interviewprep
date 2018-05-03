package com.anuj;

/**
 * Created by anuj on 6/2/17.
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Raccar"));
    }

    public static boolean isPalindrome(String s) {
        //check if the string is a palindrome not taking into account
        //non alphanumeric characters in the string.
        //Simple way would to copy the string into another one with the
        //nonalphanumeric characters removed.

        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                stringBuffer.append(s.charAt(i));
            }
        }

        return isPalindromeString(stringBuffer.toString().toLowerCase());
    }

    private static boolean isPalindromeString(String str) {
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) == str.charAt(str.length() - i - 1)) {
                continue;
            }
            return false;
        }
        return true;
    }
}
