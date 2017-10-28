/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

public class MergeSortSubRoutine {
    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int k = 0;
        int i = 0;
        int j = 0;
        if (arrLeft == null || arrLeft.length == 0) {
            return arrRight;
        } else if (arrRight == null || arrRight.length == 0) {
            return arrLeft;
        }
        int[] mergeArray = new int[arrLeft.length + arrRight.length];
        for (; k < arrLeft.length + arrRight.length; k++) {
            if (i < arrLeft.length && j < arrRight.length) {
                if (arrLeft[i] < arrRight[j]) {
                    mergeArray[k] = arrLeft[i++];
                    if (i == arrLeft.length) {
                        k++;
                        break;
                    }
                } else {
                    mergeArray[k] = arrRight[j++];
                    if (j == arrRight.length) {
                        k++;
                        break;
                    }
                }
            }
        }
        if (i == arrLeft.length) {
            for (; k < arrLeft.length + arrRight.length; k++) {
                mergeArray[k] = arrRight[j++];
            }
        } else if (j == arrRight.length) {
            for (; k < arrLeft.length + arrRight.length; k++) {
                mergeArray[k] = arrLeft[i++];
            }
        }

        return mergeArray;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[0];
        System.out.println("Array Length: " + arr1.length);
        int[] arr2 = new int[] { 1, 2, 4, 7, 8, 9, 12 };

        int[] mergedArray = merge(arr1, arr2);

        for (int i = 0; i < mergedArray.length; i++) {
            System.out.println(mergedArray[i]);
        }
    }
}
