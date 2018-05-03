package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(new Permutations().permute(new int[]{
                1, 2, 3,
        }));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> currentArray = Arrays.stream(nums).boxed().collect(Collectors.toList());
        permute(new ArrayList<>(), currentArray, answer);
        return answer;
    }

    private void permute(List<Integer> prefix, List<Integer> currentArray,
                         List<List<Integer>> answer) {
        if (currentArray == null || currentArray.isEmpty()) {
            answer.add(prefix);
        }

        for(int i=0; i < currentArray.size(); i++) {
            List<Integer> arrayIndexRem = new ArrayList<>(currentArray);
            arrayIndexRem.remove(i);
            List<Integer> currentPrefix = new ArrayList<>(prefix);
            currentPrefix.add(currentArray.get(i));
            permute(currentPrefix, arrayIndexRem, answer);
        }
    }
}
