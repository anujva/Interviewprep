package com.anuj;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationsII {
    /**
     * Given a collection of numbers that might contain
     * duplicates, return all possible unique permutations.
     * For example. [1, 1, 2] have the following, unique
     * permutations.
     */

    public static void main(String[] args) {
        System.out.println(new PermutationsII().permuteUnique(new int[]{
                1, 2, 1
        }));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        //How will you permute.
        //run a subroutine to do the permutations.
        List<Integer> numsArray = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> answers = new ArrayList<>();
        HashSet<String> deduplicator = new HashSet<>();
        permuteUnique(new ArrayList<>(), numsArray, answers, deduplicator);
        return answers;
    }

    private String arrayAsString(List<Integer> array) {
        StringBuffer buffer = new StringBuffer();
        for(Integer integer : array) {
            buffer.append(integer).append('-');
        }
        return buffer.toString();
    }

    private void permuteUnique(List<Integer> prefix, List<Integer>
            currentArray, List<List<Integer>> answers, HashSet<String>
            deduplicator) {
        if(currentArray == null || currentArray.isEmpty()) {
            String arrString = arrayAsString(prefix);
            if(!deduplicator.contains(arrString)){
                answers.add(prefix);
                deduplicator.add(arrString);
            }
        }

        for(int i=0; i < currentArray.size(); i++) {
            List<Integer> arrayWithCurrentIndexRemoved = new ArrayList<>
                    (currentArray);
            arrayWithCurrentIndexRemoved.remove(i);
            List<Integer> permutedArray = new ArrayList<>(prefix);
            permutedArray.add(currentArray.get(i));

            permuteUnique(permutedArray, arrayWithCurrentIndexRemoved,
                    answers, deduplicator);
        }
    }
}
