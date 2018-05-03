package com.anuj;

/**
 * Created by anuj on 5/23/17.
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 0, 0, 3, 12};
        moveZeros(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void moveZeros(int[] nums) {
        int zeroStartIndex = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] != 0) {
                //swap num with zerostartindex.
                if (zeroStartIndex == -1) {
                    zeroStartIndex = i;
                }
                nums[zeroStartIndex] = nums[i + 1];
                nums[i + 1] = 0;
                zeroStartIndex++;
                if (nums[zeroStartIndex] != 0) {
                    zeroStartIndex = -1;
                }
            }
            if (nums[i] == 0 && nums[i + 1] == 0) {
                if (zeroStartIndex == -1) {
                    zeroStartIndex = i;
                }
            }
        }
    }
}
