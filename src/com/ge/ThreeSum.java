package com.ge;

import java.util.*;

/**
 * Created by anuj on 5/7/17.
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{
                13, 9, 1, 12, -7, -12, 7, 3, 9, 6, -7, 4, 9, 5, 5, -7, 4, 11, 1, -2, 12, 3, -12, -15, 0, -12, -6, -1, 7, -5, -4, -3, 12, 4, -14, -10, -1, 8, 1, -6, -1, 9, 13, -14, -1, -5, -6, -12, -8, 2, 2, 11, 13, -3, 11, -2, 1, -10, 4, -15, -8, 7, -11, 11, -4, -10, -13, 3, 5, 3, 12, 11, -11, 2, 12, 3, 13, 13, -2, 12, -7, -15, 8, -9, -10, -4, -4, 6, 1, -15, -2, 0, -1, 2, -3, 10, -1, -9, -10, -11, 1, -13, -15, 5, -3, 5, -7, -5, -5, 6, 14, 3, -1, 7, 1, -4, -12, 12, -13, -4, 4, 0, 3, -12, 9, -15, 6
        };
        System.out.println(threeSum(nums));
    }

    private static class Triplet {
        int index1;
        int index2;
        int index3;

        public Triplet(int a, int b, int c) {
            index1 = a;
            index2 = b;
            index3 = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triplet triplet = (Triplet) o;
            return index1 == triplet.index1 &&
                    index2 == triplet.index2 &&
                    index3 == triplet.index3;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index1, index2, index3);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        HashSet<Triplet> triplets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = -1 * (nums[i] + nums[j]);
                //if this number is in the hashmap;
                if (hashMap.containsKey(sum)) {
                    //get the three indices in order and put them
                    //in a hashset.
                    int indexFromMap = hashMap.get(sum);
                    if (indexFromMap == i || indexFromMap == j) {
                        continue;
                    }
                    List<Integer> sortedValues = new ArrayList<Integer>
                            (Arrays.asList(nums[i], nums[j],
                                    nums[indexFromMap]));
                    Collections.sort(sortedValues);
                    triplets.add(new Triplet(sortedValues.get(0),
                            sortedValues.get(1), sortedValues
                            .get(2)));
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>();
        for (Triplet triplet : triplets) {
            answer.add(new ArrayList<>(Arrays.asList(triplet.index1, triplet
                    .index2, triplet.index3)));
        }
        return answer;
    }
}
