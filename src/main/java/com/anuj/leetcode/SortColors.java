package com.anuj.leetcode;

import java.util.Arrays;

public class SortColors {

    public static void main(String[] args) {
        int[] colors = new int[]{
            0, 1, 2, 0, 1, 2, 0, 1, 2
        };
        sortColors(colors);
        Arrays.stream(colors).boxed().forEach(x ->
            System.out.print(x + " "));
    }

    public static void sortColors(int[] nums) {
        int[] colors = new int[3];

        for (int i = 0; i < nums.length; i++) {
            colors[nums[i]]++;
        }

        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < colors[i]; j++) {
                nums[count++] = i;
            }
        }
    }
}
