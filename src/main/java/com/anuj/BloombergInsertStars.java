
package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class BloombergInsertStars {
    public static void main(String[] args) {
        String string = "cc";
        System.out.println(insertPairStar(string));

        List<String> input = new ArrayList<>(Arrays.asList("Hi", "Hello", "Hey", "Hi", "Hello", "Hey"));
        ArrayList<String> sortedDedupValues = removeDuplicates(input);
        for (String str : sortedDedupValues) {
            System.out.println(str);
        }
    }

    public static String insertPairStar(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 0) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }

        StringBuffer stringBuffer = new StringBuffer(2 * s.length());
        stringBuffer.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                stringBuffer.append('*').append(s.charAt(i));
            } else {
                stringBuffer.append(s.charAt(i));
            }
        }

        return stringBuffer.toString();
    }

    public static ArrayList<String> removeDuplicates(List<String> input) {
        TreeSet<String> uniqueWords = new TreeSet<>();
        for (String str : input) {
            uniqueWords.add(str);
        }
        String[] sortedUniqueWords = new String[uniqueWords.size()];
        return new ArrayList<>(Arrays.asList(uniqueWords.toArray(sortedUniqueWords)));
    }
}
