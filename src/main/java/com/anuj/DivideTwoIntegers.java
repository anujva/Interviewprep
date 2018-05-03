
package com.anuj;

public class DivideTwoIntegers {
  public static void main(String [] args) {
    System.out.println(divide(-2147483648, 2));
  }

  public static int divide(int dividend, int divisor) {
    //we have to deal with division of negative numbers as well.
    //when the numbers are negative. then we need to divide and keep the
    //sign.
    if(dividend == Integer.MIN_VALUE && divisor == -1) {
      return Integer.MAX_VALUE;
    }

    int signDividend = Integer.signum(dividend);
    int signDivisor = Integer.signum(divisor);

    int count = 0;
    long dividendLong = Math.abs((long)dividend);
    divisor = Math.abs(divisor);

    while(dividendLong >= divisor) {
      dividendLong = dividendLong- divisor;
      count++;
    }

    //now the count is the quotient.
    //its sign is going to be whatever is the sign.
    if(signDividend != signDivisor) {
      return count*(-1);
    }else {
      return count;
    }
  }
}
