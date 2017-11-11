
package com.anuj;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2, 5, 10, 1}, 27));
    }

    public static int coinChange(int[] coins, int amount) {
        /**
         * Now what we need to track is different. We need to track the minimum number of coins it
         * took to make the change.
         */
        int[][] minCoinDP = new int[coins.length][amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            int numOfCoins = -1;
            if (i % coins[0] == 0) {
                numOfCoins = i / coins[0];
            }
            minCoinDP[0][i] = numOfCoins;
        }
        /**
         * Initialization done. Now for the main loop
         */
        for (int i = 1; i < coins.length; i++) {
            for (int j = 0; j < amount + 1; j++) {
                int denominationCount = 0;
                int minimumCountOfCoins = Integer.MAX_VALUE;
                while (j - denominationCount * coins[i] >= 0) {
                    int residualAmount = j - denominationCount * coins[i];
                    //find the best way to make the residual amount using dp
                    int currentCountOfCoins = -1;
                    if (minCoinDP[i - 1][residualAmount] != -1) {
                        currentCountOfCoins = denominationCount + minCoinDP[i - 1][residualAmount];
                    }
                    denominationCount++;
                    if (currentCountOfCoins == -1) {
                        continue;
                    }
                    if (currentCountOfCoins < minimumCountOfCoins) {
                        minimumCountOfCoins = currentCountOfCoins;
                    }

                }
                if (minimumCountOfCoins == Integer.MAX_VALUE) {
                    minimumCountOfCoins = -1;
                }
                minCoinDP[i][j] = minimumCountOfCoins;
            }
        }
        return minCoinDP[coins.length - 1][amount];
    }
}
