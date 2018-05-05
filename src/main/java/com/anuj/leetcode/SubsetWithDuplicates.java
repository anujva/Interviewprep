package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SubsetWithDuplicates {
    public static void main(String[] args) {
        List<List<Integer>> lists = subsetsWithDup(new int[]{
                1, 2, 2
        });
        System.out.println(lists);
        System.out.println("The total number of permutations: " + lists.size());
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> answer = new HashSet<>();
        List<Integer> numsAsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        subsetsWithDupSubroutine(numsAsList, answer);
        return answer.stream().collect(Collectors.toList());
    }

    public static void subsetsWithDupSubroutine(List<Integer> nums,
                                                Set<List<Integer>> answer) {
        if (nums.size() == 0) {
            //There are two options.. either
            answer.add(new ArrayList<>());
            return;
        }

        Integer currentNum = nums.get(0);
        nums.remove(0);
        subsetsWithDupSubroutine(nums, answer);
        Set<List<Integer>> answerForThisStep = new HashSet<>();
        for (List<Integer> list : answer) {
            //for each entry we have to do two things
            //either chose to add the current num
            //or choose not to. If I choose not to add to the list
            //that would mean just adding to the answer for this
            answerForThisStep.add(list);
            List<Integer> interim = new ArrayList<>(list);
            interim.add(currentNum);
            Collections.sort(interim);
            answerForThisStep.add(interim);
        }
        answer.addAll(answerForThisStep);
    }
}
