/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

import java.util.HashSet;

public class ColorfulNumbers {
  public static void main(String [] args) {
    System.out.println(colorful(99));
  }

  public static int colorful(int a) {
    int numberOfDigits = getDigitsInNumber(a);
    int temp = a;
    HashSet<Integer> subSequences = new HashSet<>();
    int index = 1;
    while (index <= numberOfDigits) {
      HashSet<Integer> uniqueSubsequences = new HashSet<>();
      while (temp != 0) {
        if(uniqueSubsequences.contains(temp % (int)Math.pow(10, index))){
          return 0;
        }
        uniqueSubsequences.add(temp % (int)Math.pow(10, index));
        subSequences.add(temp % (int)Math.pow(10, index));
        temp = temp / 10;
      }
      index++;
      temp = a;
    }

    //Once I have the subsequences.. iterate over the products to see
    //if they are repeated.
    HashSet<Integer> products = new HashSet<>();
    for (Integer sub : subSequences) {
      int productOfDigits = productOfDigits(sub);
      if (products.contains(productOfDigits)) {
        return 0;
      }
      products.add(productOfDigits);
    }
    return 1;
  }

  private static int productOfDigits(int sub) {
    int product = sub % 10;
    sub = sub / 10;
    while (sub != 0) {
      product *= sub % 10;
      sub = sub / 10;
    }
    return product;
  }

  private static int getDigitsInNumber(int a) {
    int length = 0;
    while (a != 0) {
      length++;
      a = a / 10;
    }
    return length;
  }
}
