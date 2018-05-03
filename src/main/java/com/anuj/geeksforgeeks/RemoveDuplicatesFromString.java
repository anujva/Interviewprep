package com.anuj.geeksforgeeks;

import java.util.HashSet;

public class RemoveDuplicatesFromString {
    public static void main(String[] args) {
        System.out.println(removeDuplicatesFromString("geeksforgeeks"));
        System.out.println(removeDuplicatesAnotherWay("geeksforgeeks"));
    }

    public static String removeDuplicatesFromString(String str) {
        if (str == null || str.isEmpty()) return str;
        StringBuffer buffer = new StringBuffer();
        buffer.append(str.charAt(0));
        HashSet<Character> seenCharacters = new HashSet<>();
        seenCharacters.add(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (!seenCharacters.contains(str.charAt(i))) {
                buffer.append(str.charAt(i));
                seenCharacters.add(str.charAt(i));
            }
        }
        return buffer.toString();
    }

    public static String removeDuplicatesAnotherWay(String str) {
        StringBuffer buffer = new StringBuffer();
        buffer.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            boolean found = false;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == str.charAt(i)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                buffer.append(str.charAt(i));
            }
        }
        return buffer.toString();
    }
}
