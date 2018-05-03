package com.anuj;

public class StockMarketOracle {
    public static void main(String[] args) {
        int[] a = new int[]{
                1, 1, 49, 1, 49, 100
        };
        System.out.println(maxProfit(a));
    }

    public static int maxProfit(int[] a) {
        //maxprofit..
        int[][] maxProfit = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            maxProfit[i][i] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (maxProfit[i][j - 1] >= 0 && a[j] - a[j - 1] >= 0)
                    maxProfit[i][j] = maxProfit[i][j - 1] + a[j] - a[j - 1];
                else if (maxProfit[i][j - 1] >= 0 && a[j] - a[j - 1] < 0) {
                    maxProfit[i][j] = maxProfit[i][j - 1];
                } else {
                    maxProfit[i][j] = 0;
                }
            }
        }
        return maxProfit[0][a.length - 1];
    }
}
