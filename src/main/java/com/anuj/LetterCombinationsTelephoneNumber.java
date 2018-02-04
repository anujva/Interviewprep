package com.anuj;

import java.util.*;

public class LetterCombinationsTelephoneNumber {
    public static void main(String[] args) {
        List<String> combinations = letterCombinations("23");
        System.out.println(combinations);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        Map<Character, List<String>> map = new HashMap<>();
        map.put('1', new ArrayList<>());
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        map.put('0', new ArrayList<>());
        for (int i = 0; i < digits.length(); i++) {
            List<String> newList = new ArrayList<>();
            if (list.isEmpty()) {
                for (int k = 0; k < map.get(digits.charAt(i)).size(); k++) {
                    newList.add(map.get(digits.charAt(i)).get(k));
                }
            } else {
                for (int j = 0; j < list.size(); j++) {
                    for (int k = 0; k < map.get(digits.charAt(i)).size(); k++) {
                        newList.add(list.get(j).concat(map.get(digits.charAt(i)).get(k)));
                    }
                }
            }
            list = newList;
        }
        //at the end of this loop, list should have all the values for the letter
        //combination
        Set<String> combinationsAndPermutations = new HashSet<>();
        String[] answersArray = new String[10];
        return Arrays.asList(combinationsAndPermutations.toArray(answersArray));
    }

    public static void combinationsAndPermutations(String wordToPermute,
                                                   Set<String> combinationsAndPermutations) {
        //we will generate a permutation for the word and put it in the set.
        generatePermutation(wordToPermute, 0, combinationsAndPermutations);
    }

    private static String generatePermutation(String wordToPermute, int startIndex,
                                              Set<String> combinationsAndPermutations) {
        //when startIndex is equal to the length of the word to Permute
        //we have reached the end of the permutations possible and now is the time to return
        char[] wordCharacterArray = wordToPermute.toCharArray();
        for (int i = startIndex; i < wordToPermute.length(); i++) {
            //swap the character at appears at the startIndex with the i;
            char startIndexCharacter = wordCharacterArray[startIndex];
            wordCharacterArray[startIndex] = wordCharacterArray[i];
            wordCharacterArray[i] = startIndexCharacter;
        }
        return null;
    }
}
