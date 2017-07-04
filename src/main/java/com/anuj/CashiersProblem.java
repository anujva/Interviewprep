/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CashiersProblem {
  public static void main(String[] args) {
    String[] itemsBought = new String[] { "apple", "banana", "kale" };
    System.out.println(combinations(itemsBought));
  }

  public static Set<Set<String>> combinations(String[] itemsBought) {
    //items bought.
    Set<Set<String>> allCombinations = new HashSet<>();
    for (int i = 0; i < itemsBought.length; i++) {
      allCombinations.add(new HashSet<>(Arrays.asList(itemsBought[i])));
    }
    allCombinationsSubroutine(itemsBought, allCombinations, allCombinations);
    return allCombinations;
  }

  public static void allCombinationsSubroutine(String[] itemsBought, Set<Set<String>> allCombinations,
      Set<Set<String>> iterationCombinations) {
    if (iterationCombinations.iterator().next().size() == itemsBought.length) {
      return;
    }
    //whatever is the current combination.. take it and grow it..
    Set<Set<String>> allCominationsGeneratedInThisIteration = new HashSet<>();
    for (Set<String> iterationCombination : iterationCombinations) {
      //grow it by one again..
      for (int j = 0; j < itemsBought.length; j++) {
        if (!iterationCombination.contains(itemsBought[j])) {
          Set<String> expandedSet = new HashSet<>();
          expandedSet.addAll(iterationCombination);
          expandedSet.add(itemsBought[j]);
          allCominationsGeneratedInThisIteration.add(expandedSet);
        }
      }
    }
    allCombinations.addAll(allCominationsGeneratedInThisIteration);
    allCombinationsSubroutine(itemsBought, allCombinations, allCominationsGeneratedInThisIteration);
  }
}
