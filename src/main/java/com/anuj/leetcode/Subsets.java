package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{
            1,2,3
        }));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        List<List<Integer>> level1 = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            level1.add(new ArrayList<>(Arrays.asList(nums[i])));
        }
        answer.addAll(level1);
        //grow the list
        int level = 1;
        while (level < nums.length) {
            List<List<Integer>> levelByLevel = new ArrayList<>();
            //iterate over all of this level.
            for (List<Integer> list : level1) {
                //what is the index of the last element
                int indexOfLast = getIndexOfLastElement(list, nums);
                for (int i = indexOfLast + 1; i < nums.length; i++) {
                    List<Integer> copyList = new ArrayList<>(list);
                    copyList.add(nums[i]);
                    levelByLevel.add(copyList);
                }
            }
            answer.addAll(levelByLevel);
            level1 = levelByLevel;
            level++;
        }
        return answer;
    }

    private static int getIndexOfLastElement(List<Integer> list, int[] nums) {
        int index = 0;
        for (; index < nums.length; index++) {
            if (list.get(list.size() - 1) == nums[index]) {
                return index;
            }
        }
        return -1;
    }
}
