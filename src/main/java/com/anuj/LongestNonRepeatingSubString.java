package com.anuj;

import java.util.HashMap;
import java.util.Map;

public class LongestNonRepeatingSubString {
    public static void main(String[] args) {
        System.out.println(longestNRSubstringLen("abcda"));
    }

    public static int longestNRSubstringLen(String input) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        for (int i = 0; i < input.length(); i++) {
            if (map.containsKey(input.charAt(i))) {
                //we are seeing the character again.
                //The substring from original index to this index
                int originalIndex = map.get(input.charAt(i));
                String currentSubstring = input.substring(originalIndex, i);
                if (longest < currentSubstring.length()) {
                    longest = currentSubstring.length();
                }
                map = new HashMap();
                for (int j = originalIndex + 1; j <= i; j++) {
                    map.put(input.charAt(j), j);
                }
            } else {
                map.put(input.charAt(i), i);
            }
        }
        //finally whatever is left in the map if it is bigger than ther largest.
        longest = longest < map.size() ? map.size() : longest;
        return longest;
    }
}
