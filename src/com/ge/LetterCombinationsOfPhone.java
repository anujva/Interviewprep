/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.ge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfPhone {

  public static HashMap<Character, List<Character>> keyToCharacterMapping = new HashMap<>();

  public LetterCombinationsOfPhone() {
    keyToCharacterMapping.put('2', new ArrayList<>(Arrays.asList('a', 'b', 'c')));
    keyToCharacterMapping.put('3', new ArrayList<>(Arrays.asList('d', 'e', 'f')));
    keyToCharacterMapping.put('4', new ArrayList<>(Arrays.asList('g', 'h', 'i')));
    keyToCharacterMapping.put('5', new ArrayList<>(Arrays.asList('j', 'k', 'l')));
    keyToCharacterMapping.put('6', new ArrayList<>(Arrays.asList('m', 'n', 'o')));
    keyToCharacterMapping.put('7', new ArrayList<>(Arrays.asList('p', 'q', 'r', 's')));
    keyToCharacterMapping.put('8', new ArrayList<>(Arrays.asList('t', 'u', 'v')));
    keyToCharacterMapping.put('9', new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z')));
  }

  public static void main(String[] args) {
    LetterCombinationsOfPhone letterCombinationsOfPhone = new LetterCombinationsOfPhone();
    System.out.println(letterCombinationsOfPhone.letterCombinations("23"));
  }

  public List<String> letterCombinations(String digits) {
    List<StringBuffer> combinations = new ArrayList<>();
    for (int i = 0; i < digits.length(); i++) {
      List<Character> characters = keyToCharacterMapping.get(digits.charAt(i));
      if (combinations.isEmpty()) {
        for (Character character : characters) {
          combinations.add(new StringBuffer().append(character));
        }
      } else {
        List<StringBuffer> combinationsTemp = new ArrayList<>();
        for (int j = 0; j < combinations.size(); j++) {
          for (Character character : characters) {
            combinationsTemp.add(new StringBuffer().append(combinations.get(j)).append(character));
          }
        }
        combinations = combinationsTemp;
      }
    }
    List<String> answer = new ArrayList<>();
    for (int i = 0; i < combinations.size(); i++) {
      answer.add(combinations.get(i).toString());
    }
    return answer;
  }
}
