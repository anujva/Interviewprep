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
    }

    public static int change(int amount, int[] coins) {
        int[][] numOfWays = new int[coins.length][amount + 1];
        //is sorting of the coins array needed? Doesn't seem like
        //it. If we are keeping the count till the denomination..
        //we should be able to do it.
        for (int i = 1; i < amount + 1; i++) {
            numOfWays[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

        for (int i = 1; i < amount + 1; i++) {
            for (int j = 1; j < coins.length; j++) {
                
            }
        }

        return 0;
    }
}
