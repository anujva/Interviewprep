package com.ge;

/**
 * Created by anuj on 5/7/17.
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] s = new String[]{
                "apple", "ape", "april"
        };
        System.out.println(longestCommonPrefix(s));
    }

    public static String longestCommonPrefix(String[] s) {
        if(s.length ==0){
            return "";
        }
        StringBuffer prefixString = new StringBuffer();
        int stringIndex = 0;
        //Find the shortest string
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) {
            if (s[i].length() < minLength) {
                minLength = s[i].length();
            }
        }

        while (stringIndex < minLength) {
            Character c = s[0].charAt(stringIndex);
            boolean longestPrefixFound = false;
            for (int i = 0; i < s.length; i++) {
                if (c != s[i].charAt(stringIndex)) {
                    //longestprefix found
                    longestPrefixFound = true;
                    break;
                }
            }
            if (longestPrefixFound) {
                break;
            }
            prefixString.append(c);
            stringIndex++;
        }

        return prefixString.toString();
    }
}
