package com.anuj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj on 5/6/17.
 */
public class Test {
    public static void main (String[] args) throws java.lang.Exception{
        //System.out.println(longestPalindromeString("aaaaab"));

        //you can test now

        String s = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";

        long startTime = System.nanoTime();

        System.out.println("Result: "+longestPalindromeString(s));

        long elapsedTime = System.nanoTime() - startTime;

        System.out.println("Total Time taken:" + elapsedTime);//304951 -- 302965
    }

    public static String longestPalindromeString(String s) {
        if (s.length() == 1 || s.length() == 0) {
            return s;
        }

        // Keep track of the maximum here itself in this loop.
        // Initialization complete.
        int maxLength = -1;
        int maxIIndex = -1;
        int maxJIndex = -1;
        //HashSet<String> currentlyFoundPalindrome = new HashSet<String>();

        //--here is the change

        List<String> currentlyFoundPalindrome = new ArrayList<String>();
        for (int i = 0; i < s.length(); i++) {
            currentlyFoundPalindrome.add(s.substring(i, i + 1));
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    // check the difference between i and j
                    int diff = i - j;
                    if (diff == 0) {
                        // same index nothing to do
                    } else if (diff == 1) {
                        // right next to each other.
                        String str = s.substring(j, i + 1);
                        currentlyFoundPalindrome.add(str);
                        if (str != null && maxLength < str.length()) {
                            maxIIndex = i;
                            maxJIndex = j;
                            maxLength = str.length();
                        }
                    } else if (diff > 1) {
                        int indexOfj = j + 1;
                        if (currentlyFoundPalindrome.contains(s.substring(indexOfj, i))) {
                            String str = s.charAt(i) + s.substring(indexOfj, i) + s.charAt(i);
                            if (str != null && maxLength < str.length()) {
                                maxIIndex = i;
                                maxJIndex = j;
                                maxLength = str.length();
                            }
                            currentlyFoundPalindrome.add(str);
                        }
                    }
                }
            }
        }
        if (maxLength == -1) {
            return s.substring(0, 1);
        }
        return s.substring(maxJIndex, maxIIndex + 1);
    }
}
