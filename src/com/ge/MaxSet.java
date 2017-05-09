package com.ge;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by anuj on 5/7/17.
 */
public class MaxSet {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1967513926, 1540383426, -1303455736, -521595368));
        System.out.println(maxset(a));
    }

    public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
        long maxValue = Integer.MIN_VALUE;
        ArrayList<Integer> maxSet = null;
        ArrayList<Integer> temp = new ArrayList<>();
        long sum = 0;
        a.add(-1);
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > -1) {
                //put this value in the current
                temp.add(a.get(i));
                sum += (long)a.get(i);
            } else {
                //we hit the fist negative value..
                //we should check if the elements that we have
                //picked up in the temp list have a sum
                //that is larger than the current sum
                if (sum > maxValue) {
                    maxValue = sum;
                    maxSet = temp;
                } else if (sum == maxValue) {
                    if (maxSet != null && maxSet.size() < temp.size()) {
                        maxSet = temp;
                    }
                }
                temp = new ArrayList<>();
                sum = 0;
            }
        }
        return maxSet;
    }
}
