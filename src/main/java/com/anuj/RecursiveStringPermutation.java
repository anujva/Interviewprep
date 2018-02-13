package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;

public class RecursiveStringPermutation {

  public static void main(String[] args) {
    System.out.println(getPermutations("cat"));
  }

  public static ArrayList<String> getPermutations(String s) {
    if (s == null || s.isEmpty()) {
      return null;
    }

    if (s.length() == 1) {
      return new ArrayList<>(Arrays.asList(s));
    }

    Character firstCharacter = s.charAt(0);
    ArrayList<String> permutations = getPermutations(s.substring(1));
    ArrayList<String> answers = new ArrayList<>();
    for (String str : permutations) {
      char[] strArray = str.toCharArray();
      char[] mergedArray = new char[strArray.length + 1];
      int idx = 0;
      for (int i = 0; i < strArray.length; i++) {
        for (int j = 0; j < strArray.length; j++) {
          if (i == j) {
            mergedArray[idx++] = firstCharacter;
          }
          mergedArray[idx++] = strArray[j];
        }
        idx = 0;
        answers.add(new String(mergedArray));
      }
      answers.add(str.concat(Character.toString(firstCharacter)));
    }
    return answers;
  }
}
