package com.anuj;

import java.util.ArrayList;

public class GenerateIPAddress {

  public static void main(String[] args) {
    System.out.println(generateIPAddrs("11111"));
  }

  public static ArrayList<String> generateIPAddrs(String s) {
    ArrayList<String> allPossibleCombinations = new ArrayList<>();
    generateIPAddrs(s, new ArrayList<>(), allPossibleCombinations);
    return allPossibleCombinations;
  }

  public static void generateIPAddrs(String s, ArrayList<String> partial,
      ArrayList<String> allIPAddress) {
    if (s == null) {
      return;
    }

    //get the first character in the string.
    if (partial.size() < 3) {
      if (s.length() > 0) {
        String firstCharacter = s.substring(0, 1);
        ArrayList<String> partial1 = new ArrayList<>(partial);
        partial1.add(firstCharacter);
        generateIPAddrs(s.substring(1), partial1, allIPAddress);
        //get the first two characters in the string
        if (s.length() > 1) {
          String firstTwoCharacters = s.substring(0, 2);
          ArrayList<String> partial2 = new ArrayList<>(partial);
          partial2.add(firstTwoCharacters);
          generateIPAddrs(s.substring(2), partial2, allIPAddress);
          //get the first three characters in the string.
          if (s.length() > 2) {
            String firstThreeCharacters = s.substring(0, 3);
            if(isValid(firstThreeCharacters)) {
              ArrayList<String> partial3 = new ArrayList<>(partial);
              partial3.add(firstThreeCharacters);
              generateIPAddrs(s.substring(3), partial3, allIPAddress);
            }
          }
        }
      }
    } else if (partial.size() == 3) {
      if (s.length() > 0 && s.length() < 4 && isValid(s)) {
        allIPAddress.add(concatPartialIps(partial, s));
      }
    }
  }

  private static boolean isValid(String s) {
    try {
      Integer subpart = Integer.parseInt(s);
      if (subpart > 255) {
        return false;
      }
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  private static String concatPartialIps(ArrayList<String> partial, String s) {
    StringBuffer buffer = new StringBuffer();
    for (String partialString : partial) {
      buffer.append(partialString).append('.');
    }
    buffer.append(s);
    return buffer.toString();
  }
}
