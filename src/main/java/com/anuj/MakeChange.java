package com.anuj;

public class MakeChange {

  public static void main(String[] args) {
    System.out.println(makeChange(new int[]{25, 10, 5, 1}, 100));
  }

  public static int makeChange(int[] coins, int amount) {
    if(amount < 0) return 0;
    int[][] change = new int[coins.length][amount + 1];
    for (int i = 0; i < coins.length; i++) {
      for (int j = 0; j < amount + 1; j++) {
        change[i][j] = 0;
      }
    }

    //lets prepopulate with what can be done with the first coin.
    for (int i = 0; i < amount + 1; i++) {
      int j = 1;
      while (j * coins[0] <= i) {
        if (i - (j * coins[0]) == 0) {
          change[0][i] += 1;
        }
        j++;
      }
    }

    for (int i = 1; i < coins.length; i++) {
      for (int j = 0; j < amount + 1; j++) {
        int k = 1;
        change[i][j] = change[i - 1][j];
        while (k * coins[i] <= j) {
          if (j - (k * coins[i]) == 0) {
            change[i][j] += 1;
          } else {
            int remainder = j - (k * coins[i]);
            if (remainder > 0 && change[i - 1][remainder] > 0) {
              change[i][j] += change[i - 1][remainder];
            }
          }
          k++;
        }
      }
    }
    // Total number of ways in which we can make the amount
    return change[coins.length - 1][amount];
  }
}
