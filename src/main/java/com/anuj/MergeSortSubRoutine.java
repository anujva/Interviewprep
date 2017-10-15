package com.anuj;

public class MergeSortSubRoutine {
    public static int[] merge(int[] arrLeft, int[] arrRight) {
        int[] mergeArray = new int[arrLeft.length + arrRight.length];
        int i = 0, j = 0;
        int k = 0;
        for (k = 0; k < arrLeft.length + arrRight.length; k++) {
            if (i >= arrLeft.length) {
                break;
            }
            if (j >= arrRight.length) {
                break;
            }

            if (arrLeft[i] < arrRight[j]) {
                mergeArray[k] = arrLeft[i++];
            } else {
                mergeArray[k] = arrRight[j++];
            }
        }

        for (; k < arrLeft.length + arrRight.length; k++) {
            if (i >= arrLeft.length) {
                mergeArray[k] = arrRight[j++];
            }
            if (j >= arrRight.length) {
                mergeArray[k] = arrLeft[i++];
            }
        }

        return mergeArray;
    }

    public static void main(String[] args) {
        int[] arrLeft = new int[]{
                2, 6, 7, 10, 25
        };
        int[] arrRight = new int[]{
                1, 3, 5, 7, 13
        };
        int[] mergedArray = merge(arrLeft, arrRight);

        for (int i = 0; i < mergedArray.length; i++) {
            System.out.println(mergedArray[i]);
        }
    }
}
