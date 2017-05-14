/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.ge;

import java.math.BigInteger;

public class PowerOf2 {
  public static void main(String[] args) {
    System.out.println(power("8"));
  }

  public static int power(String str) {
    BigInteger integer = new BigInteger(str);
    int countOfOne = 0;
    while (integer != BigInteger.valueOf(0)) {
      int remainder = integer.remainder(BigInteger.valueOf(2)).intValue();
      if (remainder == 1) {
        countOfOne++;
      }

      if (countOfOne > 1) {
        return 0;
      }

      integer = integer.divide(BigInteger.valueOf(2));
    }
    return countOfOne == 1 ? 1 : 0;
  }
}
