package com.anuj;

/**
 * Created by anuj on 5/17/17.
 */
public class CoinChange2 {
  public static void main(String[] args) {
    /**
     * The ask of the problem is to find the number of ways,
     * in which you can form the change for a particular
     * amount, from a given set of denominations of currency.
     */

    System.out.println(change(500, new int[] { 2, 7, 13 }));
  }

  public static int change(int amount, int[] coins) {
    if (amount == 0) {
      return 0;
    }
    if (coins.length == 0) {
      return -1;
    }
    int[][] numOfWays = new int[coins.length][amount + 1];
    //is sorting of the coins array needed? Doesn't seem like
    //it. If we are keeping the count till the denomination..
    //we should be able to do it.
    for (int i = 1; i < amount + 1; i++) {
      numOfWays[0][i] = i % coins[0] == 0 ? 1 : 0;
    }

    for (int i = 1; i < amount + 1; i++) {
      for (int j = 1; j < coins.length; j++) {
        //keep picking the value of this coin up until the value gets divided
        int numWaysForCurrentCoinDenomination = 0;
        int index = 0;
        while (i - index * coins[j] >= 0) {
          int residualAmount = i - index * coins[j];
          //find the max num of ways to get to the residual amount
          //from the row above.
          if (residualAmount == 0) {
            numWaysForCurrentCoinDenomination += 1;
          } else {
            numWaysForCurrentCoinDenomination += numOfWays[j - 1][residualAmount];
          }
          index++;
        }
        numOfWays[j][i] = numWaysForCurrentCoinDenomination;
      }
    }
    return numOfWays[coins.length - 1][amount];
  }
}
