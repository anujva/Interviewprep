
package com.anuj;

import java.util.Arrays;

public class NextPermutation {
  public static void main(String[] args) {
    int[] nums = new int[] { 1, 3, 2 };
    nextPermutation(nums);
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
    System.out.println();
  }

  public static void nextPermutation(int[] nums) {
    if (nums.length < 2) {
      return;
    }
    for (int i = nums.length - 1; i > -1; i--) {
      if (nums[i] == nums[i - 1]) {
        continue;
      } else if (nums[i] > nums[i - 1]) {
        //just swap this to get to the next highest number in the list
        int temp = nums[i];
        nums[i] = nums[i - 1];
        nums[i - 1] = temp;
        break;
      } else if (nums[i] < nums[i - 1]) {
        int j = i - 2;
        boolean foundVal = false;
        while (j > -1) {
          if (nums[j] > nums[i]) {
            j--;
          } else {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            foundVal = true;
            break;
          }
        }
        if(foundVal) {
          //sort the values that are
        }
        if (!foundVal) {
          Arrays.sort(nums);
        }
        break;
      }
    }
  }
}
