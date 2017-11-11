
package com.anuj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindSubstring {
  public static void main(String[] args) {
    System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));
  }

  public static List<Integer> findSubstring(String s, String[] words) {
    Set<String> currentlyGeneratedPermutations = new HashSet<>();
    currentlyGeneratedPermutations.add(concatenateArray(words));
    Set<String> substringsToSearchFor = getSubstringPermutations(words, 0, currentlyGeneratedPermutations);
    int lengthOfSubstrings = substringsToSearchFor.iterator().next().length();
    //what is the length of the concatenated string.
    List<Integer> integerList = new ArrayList<>();
    for (int i = 0; i < s.length() - lengthOfSubstrings + 1; i++) {
      String substring = s.substring(i, i + lengthOfSubstrings);
      if (substringsToSearchFor.contains(substring)) {
        integerList.add(i);
      }
    }
    return integerList;
  }

  private static Set<String> getSubstringPermutations(String[] words, int index,
      Set<String> currentlyGeneratedPermutations) {
    for (int i = index; i < words.length; i++) {
      for (int j = i + 1; j < words.length; j++) {
        //swap the words in the two indices
        String tempWord = words[i];
        words[i] = words[j];
        words[j] = tempWord;
        //concatenate the words and save the result.
        currentlyGeneratedPermutations.add(concatenateArray(words));
        //need to recurse on this.
        String[] wordsCurrentCopy = copyWords(words);
        getSubstringPermutations(wordsCurrentCopy, i + 1, currentlyGeneratedPermutations);
        tempWord = words[i];
        words[i] = words[j];
        words[j] = tempWord;
      }
    }
    //should I be saving the indices that was used to concatenate.
    return currentlyGeneratedPermutations;
  }

  private static String[] copyWords(String[] words) {
    String[] wordsCopy = new String[words.length];
    for (int i = 0; i < words.length; i++) {
      wordsCopy[i] = words[i];
    }
    return wordsCopy;
  }

  private static String concatenateArray(String[] words) {
    String concatenatedWord = "";
    for (int i = 0; i < words.length; i++) {
      concatenatedWord += words[i];
    }
    return concatenatedWord;
  }

}
