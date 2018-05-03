package com.anuj;

public class CoinChangeProblem {
    public static void main(String[] args) {
        System.out.println(getWays(10, new long[]{2, 5, 3, 6}));
    }

    public static long getWays(long n, long[] c) {
        long[][] numWays = new long[c.length][Math.toIntExact(n + 1)];
        //how many ways can I pick a coin from the array c
        //and try to make the value.
        for (int i = 0; i < c.length; i++) {
            for (long j = 1; j < n + 1; j++) {
                for (int k = 0; k * c[i] <= j; k++) {
                    long remainder = j - k * c[i];
                    if (remainder == 0) {
                        numWays[i][Math.toIntExact(j)] = numWays[i][Math
                                .toIntExact(j)] + 1;
                    } else if (i != 0 && numWays[i - 1][Math.toIntExact
                            (remainder)] > 0) {
                        numWays[i][Math.toIntExact(j)] += numWays[i - 1][Math
                                .toIntExact(remainder)];
                    }
                }
            }
        }
        return numWays[c.length - 1][Math.toIntExact(n)];
    }
}
