
package com.anuj;

import java.util.ArrayList;
import java.util.List;

/**
 * This class will be dedicated to the dynamic programming problems
 * that I will be tackling during my prep work for the facebook interview
 */
public class DynamicProgrammingAndRecursion {
    public static void main(String[] args) {
        String a = "WWWB";
        int b = 2;
        System.out.println(arrange(a, b));
    }

    /**
     * You are given a sequence of black and white horses, and a set of K stables numbered 1 to K. You have to
     * accommodate the horses into the stables in such a way that the following conditions are satisfied:
     * <p>
     * You fill the horses into the stables preserving the relative order of horses. For instance, you cannot put horse
     * 1 into stable 2 and horse 2 into stable 1. You have to preserve the ordering of the horses.
     * No stable should be empty and no horse should be left unaccommodated.
     * Take the product (number of white horses * number of black horses) for each stable and take the sum of all these
     * products. This value should be the minimum among all possible accommodation arrangements
     * Example:
     * <p>
     * <p>
     * Input: {WWWB} , K = 2
     * Output: 0
     * <p>
     * Explanation:
     * We have 3 choices {W, WWB}, {WW, WB}, {WWW, B}
     * for first choice we will get 1*0 + 2*1 = 2.
     * for second choice we will get 2*0 + 1*1 = 1.
     * for third choice we will get 3*0 + 0*1 = 0.
     * <p>
     * Of the 3 choices, the third choice is the best option.
     * <p>
     * If a solution is not possible, then return -1
     *
     * @param a
     * @param b
     * @return
     */
    public static int arrange(String a, int b) {
        //I know this can be solved using dynamic programming
        //but I am challenging myself to get all the arrangements
        //first and then trying to find the max.
        if (a.length() < b) {
            return -1;
        }
        ArrayList<ArrayList<String>> allPermutations = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < a.length() - b + 1; i++) {
            String current = a.substring(0, i + 1);
            String left = a.substring(i + 1, a.length());
            ArrayList<String> fromRecursion = new ArrayList<>();
            fromRecursion.add(current);
            arrangeSubroutine(left, b - 1, fromRecursion, allPermutations);
            fromRecursion.remove(fromRecursion.size() - 1);
        }
        int min = Integer.MAX_VALUE;
        for (ArrayList<String> permutation : allPermutations) {
            int sumOverPermutations = 0;
            for (int i = 0; i < permutation.size(); i++) {
                int whiteHorses = 0;
                int blackHorses = 0;
                int valForPermutation = Integer.MAX_VALUE;
                for (int j = 0; j < permutation.get(i).length(); j++) {
                    if (permutation.get(i).charAt(j) == 'W') {
                        whiteHorses++;
                    } else {
                        blackHorses++;
                    }
                }
                sumOverPermutations += whiteHorses * blackHorses;
            }
            if (min > sumOverPermutations) {
                min = sumOverPermutations;
            }
        }
        return min;
    }

    public static void arrangeSubroutine(String left, int stables, ArrayList<String> fromRecursion,
                                         ArrayList<ArrayList<String>> allPermutations) {
        if (stables == 1) {
            fromRecursion.add(left);
            ArrayList<String> allList = new ArrayList<String>(fromRecursion);
            allPermutations.add(allList);
            fromRecursion.remove(fromRecursion.size() - 1);
            return;
        }

        for (int i = 0; i < left.length() - stables + 1; i++) {
            String current = left.substring(0, i + 1);
            String leftR = left.substring(i + 1, left.length());
            fromRecursion.add(current);
            arrangeSubroutine(leftR, stables - 1, fromRecursion, allPermutations);
            fromRecursion.remove(fromRecursion.size() - 1);
        }
    }

    public static int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
        for (int i = 0; i < cost.size(); i++) {
            //I am going to start from this point
            //can do it with a while loop as well.. what is the better way of achieving this.
            int index = i;
            int currentGas = gas.get(index);
            while (true) {
                if (currentGas >= cost.get(index)) {
                    //expend the gas and reach the station.
                    currentGas = currentGas - cost.get(index) + gas.get((index + 1) % cost.size());
                    index++;
                    index = index % cost.size();
                    if (index == i) {
                        //reached this point.
                        return i;
                    }
                } else {
                    break;
                }
            }
        }
        return -1;
    }
}
