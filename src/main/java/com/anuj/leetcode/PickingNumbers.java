package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickingNumbers {

    /**
     * This testcase fails.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(pickingNumbers(new int[]{
            14,18,17,10,9,20,4,13,19,19,8,15,15,17,6,5,15,12,18,2,18,7,20,8,2,8,11,2,16,2,12,9,3,6,9,9,13,7,4,6,19,7,2,4,3,4,14,3,4,9,17,9,4,20,10,16,12,1,16,4,15,15,9,13,6,3,8,4,7,14,16,18, 20,11,20,14,20,12,15,4,5,10,10,20,11,18,5,20,13,4,18,1,14,3,20,19,14,2,5,13
        }));
    }

    /**
     * This is a wrong implementation of picking numbers.
     * I have kept it to remember, how this thinking didn't work
     * and what I missed
     * @param a
     * @return
     */
    public static int pickingNumbers(int[] a) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(a[0])));

        for (int i = 1; i < a.length; i++) {
            List<Integer> thisRun = new ArrayList<>(Arrays.asList(a[i]));
            for (int j = 0; j < i; j++) {
                List<Integer> l = list.get(j);
                boolean canAdd = true;
                for (int k = 0; k < l.size(); k++) {
                    if (Math.abs(a[i] - l.get(k)) > 1) {
                        canAdd = false;
                    }
                }
                if (canAdd && thisRun.size() - 1 < l.size()) {
                    thisRun = new ArrayList<>(l);
                    thisRun.add(a[i]);
                }
            }
            list.add(thisRun);
        }
        int max = list.get(0).size();
        for (int i = 0; i < list.size(); i++) {
            if (max < list.get(i).size()) {
                max = list.get(i).size();
            }
        }
        return max;
    }
}
