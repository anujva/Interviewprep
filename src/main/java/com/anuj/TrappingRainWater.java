package com.anuj;

/**
 * Created by anuj on 7/5/17.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int start = -1;
        int startIndex = -1;
        int end = -1;
        int endIndex = -1;
        int trap = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > 0) {
                if (start == -1) {
                    start = height[i];
                    startIndex = i;
                } else if (height[i] >= start) {
                    end = height[i];
                    endIndex = i;
                    int trappedInThisPart = (start * (endIndex - startIndex - 1));
                    for (int j = startIndex + 1; j < endIndex; j++) {
                        trappedInThisPart = trappedInThisPart - height[j];
                    }
                    trap += trappedInThisPart;
                    startIndex = endIndex;
                    start = end;
                    end = -1;
                    endIndex = -1;
                }
            }
        }
        if(startIndex == -1) {
            return trap;
        }
        //whatever is the startIndex will be the index till which we have to
        //run the algorithm.. which is the same algorithm.. just the opposite
        //direction.
        int end1 = start;
        int endIndex1 = startIndex;
        start = -1;
        startIndex = -1;
        for (int i = height.length - 1; i >= endIndex1; i--) {
            if (height[i] > 0) {
                if (start == -1) {
                    start = height[i];
                    startIndex = i;
                } else if (height[i] >= start) {
                    end = height[i];
                    endIndex = i;
                    int trappedInThisPart = (start * (startIndex - endIndex - 1));
                    for (int j = startIndex - 1; j > endIndex; j--) {
                        trappedInThisPart = trappedInThisPart - height[j];
                    }
                    trap += trappedInThisPart;
                    startIndex = endIndex;
                    start = end;
                    end = -1;
                    endIndex = -1;
                }
            }
        }
        return trap;
    }
}
