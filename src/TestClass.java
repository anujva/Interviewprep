/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */

public class TestClass {
  public static void main(String [] args) {
    String [] words = {
        "Word1", "Word2", "Word3"
    };

    changeValueInArray(words);

    for(int i=0; i < words.length; i++) {
      System.out.println(words[i]);
    }
  }

  public static void changeValueInArray(String[] words) {
    words[0] = "What the hell";
    words = new String[] {
        "Changing everything"
    };
  }
}
