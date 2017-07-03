package com.anuj;

/**
 * Created by anuj on 5/29/17.
 */
public class SuperWashingMachines {
    public static void main(String[] args) {
        System.out.println(findMinMoves(new int[] { 0, 0, 11, 5 }));
    }

    public static int findMinMoves(int[] machines) {
        int totalNumOfClothes = 0;
        int max = machines[0];
        for (int i = 0; i < machines.length; i++) {
            totalNumOfClothes += machines[i];
            if (max < machines[i]) {
                max = machines[i];
            }
        }

        if (totalNumOfClothes % machines.length != 0) {
            return -1;
        }

        int target = totalNumOfClothes / machines.length;
        int steps = 0;
        for (int i = 0; i < machines.length; i++) {
            if (machines[i] < target) {
                steps = steps + target - machines[i];
            }
        }
        return steps;
    }
}
