
package com.anuj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumII {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[] { 1, 2 }, 1));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Answer[][] dp = new Answer[candidates.length][target + 1];
        for (int i = 0; i < candidates.length; i++) {
            dp[i] = new Answer[target + 1];
        }

        for (int i = 0; i < candidates.length; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j - candidates[i] == 0) {
                    //this would mean that for this index i and j we have a solution
                    if (dp[i][j] == null) {
                        dp[i][j] = new Answer();
                    }
                    dp[i][j].values.add(Collections.singletonList(candidates[i]));
                } else {
                    int remainder = j - candidates[i];
                    //check if remainder has a solution
                    if (remainder > 0) {
                        if (i - 1 > -1 && dp[i - 1][remainder] != null) {
                            for (List<Integer> value : dp[i - 1][remainder].values) {
                                List<Integer> valueCopy = new ArrayList<>(value);
                                valueCopy.add(candidates[i]);
                                if (dp[i][j] == null) {
                                    dp[i][j] = new Answer();
                                }
                                Collections.sort(valueCopy);
                                dp[i][j].values.add(valueCopy);
                            }
                        }
                    }
                }
                //if the previous line had the solution just copy it over to this line too.
                if (i - 1 > -1 && dp[i - 1][j] != null) {
                    if (dp[i][j] == null) {
                        dp[i][j] = new Answer();
                    }
                    dp[i][j].values.addAll(dp[i - 1][j].values);
                }
            }
        }
        return dp[candidates.length - 1][target] != null
            ? new ArrayList<>(dp[candidates.length - 1][target].values)
            : new ArrayList<>();
    }

    private static class Answer {
        private final Set<List<Integer>> values;

        public Answer() {
            values = new HashSet<>();
        }
    }
}
