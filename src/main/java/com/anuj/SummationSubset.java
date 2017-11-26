package com.anuj;

import java.util.Arrays;

public class SummationSubset {
    public static void main(String[] args) {

    }

    public static boolean groupSum(int[] arr, int target) {
        Arrays.sort(arr);
        //we can try to add up to the target and then roll back each of the
        //values that have already been used to get to the target.
        //This will require an exhaustive search on the array search space.
        //There might be an easier way of doing this. I am trying to think
        //how that could be achieved. Lets see.
        return false;
    }
}
