package com.anuj;

public class CoinChangeProblem {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int number) {
        int[][] numOfWays = new int[coins.length][number + 1];
        numOfWays[0][0] = 0;
        for (int i = 1; i < number + 1; i++) {
            int j = 1;
            while (j * coins[0] < i) {
                if (i % (j * coins[0]) == 0) {
                    //we were able to factorize the sum to value
                    numOfWays[0][i] = 1;
                } else {
                    numOfWays[0][i] = -1;
                }
                j++;
            }
        }
        //Now the initial values has been calculated

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < number + 1; j++) {
                //if the value is 0// then we have made the change
                int k = 0;
                while(k * coins[i] < j) {
                    if(j - (k * coins[i]) == 0) {

                    }
                }
            }
        }
    }
}
