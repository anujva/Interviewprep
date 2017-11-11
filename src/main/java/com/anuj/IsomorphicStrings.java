
package com.anuj;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("abcabc", "xyzxyz"));
    }

    public static boolean isIsomorphic(String input1, String input2) {
        Map<Character, Character> characterMap = new HashMap<>();

        for (int i = 0; i < input1.length(); i++) {
            if (characterMap.containsKey(input1.charAt(i))) {
                if (characterMap.get(input1.charAt(i)) != input2.charAt(i)) {
                    return false;
                }
            } else if (characterMap.containsKey(input2.charAt(i))) {
                if (characterMap.get(input2.charAt(i)) != input1.charAt(i)) {
                    return false;
                }
            } else {
                characterMap.put(input1.charAt(i), input2.charAt(i));
                characterMap.put(input2.charAt(i), input1.charAt(i));
            }
        }
        return true;
    }
}
