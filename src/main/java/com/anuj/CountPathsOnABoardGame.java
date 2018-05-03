package com.anuj;

import java.util.HashMap;

public class CountPathsOnABoardGame {
    public static void main(String[] args) {
        System.out.println(countPaths(0, 0));
    }

    public static int countPaths(int m, int n) {
        HashMap<String, Integer> interimCounts = new HashMap<>();
        return countPathsSubroutine(m - 1, n - 1, interimCounts);
    }

    public static int countPathsSubroutine(int m, int n, HashMap<String, Integer> interimCounts) {
        if (m < 0 && n < 0) return 0;
        if (m == 0 && n == 0) return 1;
        int interimCount1 = 0;
        int interimCount2 = 0;
        if (interimCounts.containsKey(m + "+" + n)) {
            return interimCounts.get(m + "+" + n);
        } else {
            if (m > 0 || n > 0) {
                if (m > 0) {
                    interimCount1 = countPathsSubroutine(m - 1, n, interimCounts);
                    interimCounts.put((m - 1) + "+" + n, interimCount1);
                }
                if (n > 0) {
                    interimCount2 = countPathsSubroutine(m, n - 1, interimCounts);
                    interimCounts.put(m + "+" + (n - 1), interimCount2);
                }
                interimCounts.put(m + "+" + n, interimCount1 + interimCount2);
            }
            return interimCount1 + interimCount2;
        }
    }
}
