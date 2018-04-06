package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {

    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        //the numbers 1 to n.
        //pick k at a time
        for (int i = 1; i <= n; i++) {
            //The current number we have picked is going to be i.
            List<Integer> list = new ArrayList<>(Arrays.asList(i));
            combineSubroutine(i, k - 1, n, list, answer);
        }

        return answer;
    }

    public static void combineSubroutine(int start, int k, int n, List<Integer> currentList,
        List<List<Integer>> answer) {
        if (k == 0) {
            answer.add(currentList);
            return;
        }
        for (int i = start + 1; i <= n; i++) {
            List<Integer> list = new ArrayList<>(currentList);
            list.add(i);
            combineSubroutine(i, k - 1, n, list, answer);
        }
    }
}
