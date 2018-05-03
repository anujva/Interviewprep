package com.anuj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj on 7/2/17.
 */
public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{8, 7, 4, 3}, 11));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Answer[][] dp = new Answer[target + 1][candidates.length];
        for (int i = 0; i < target + 1; i++) {
            dp[i] = new Answer[candidates.length];
        }

        for (int j = 0; j < candidates.length; j++) {
            int currentVal = candidates[j];
            for (int i = 1; i < target + 1; i++) {
                //pick the current value from the candidates array
                int index = 1;
                while (i - (index * currentVal) >= 0) {
                    int remainder = i - (currentVal * index);
                    if (remainder == 0) {
                        //this target and currentVal combination should be entered
                        //in the dp array
                        Answer answer = dp[i][j];
                        if (answer == null) {
                            dp[i][j] = new Answer();
                            answer = dp[i][j];
                        }
                        List<Integer> currentValList = new ArrayList<>();
                        for (int k = 0; k < index; k++) {
                            currentValList.add(currentVal);
                        }
                        answer.answer.add(currentValList);
                    } else {
                        //check if the remainder has an answer entry in the dp
                        //array.
                        if (j == 0) {
                            index++;
                            continue;
                        }
                        List<Answer> answers = null;
                        for (int k = j - 1; k > -1; k--) {
                            if (dp[remainder][k] != null) {
                                if (answers == null) answers = new ArrayList<>();
                                answers.add(dp[remainder][k]);
                            }
                        }

                        if (answers != null) {
                            if (dp[i][j] == null) dp[i][j] = new Answer();
                            for (Answer answer : answers) {
                                //At this point we should make a copy of this list and
                                //add it to the current index.
                                for (List<Integer> integerList : answer.answer) {
                                    List<Integer> integerListCopy = new ArrayList(integerList);
                                    for (int k = 0; k < index; k++) {
                                        integerListCopy.add(currentVal);
                                    }
                                    dp[i][j].answer.add(integerListCopy);
                                }
                            }
                        }
                    }
                    index++;
                }
            }
        }

        for (int i = 0; i < candidates.length - 1; i++) {
            if (dp[target][i] != null && dp[target][i].answer != null) {
                if (dp[target][candidates.length - 1] == null) dp[target][candidates.length - 1] = new Answer();
                dp[target][candidates.length - 1].answer.addAll(dp[target][i].answer);
            }
        }
        return dp[target][candidates.length - 1] != null ? dp[target][candidates.length - 1].answer : new ArrayList<>();
    }

    private static class Answer {
        List<List<Integer>> answer;

        public Answer() {
            answer = new ArrayList<>();
        }
    }
}
