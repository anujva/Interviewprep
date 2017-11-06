/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

import java.util.ArrayList;

public class RotateLeftLinearArray {
    public static void main(String[] args) {
        int arr[] = new int[] { 1, 2, 3, 4, 5 };
        int[] arrRotated = rotateLeft(arr, 2);
        for (int i = 0; i < arrRotated.length; i++) {
            System.out.print(arrRotated[i] + " ");
        }
        System.out.println();
    }

    public static int[] rotateLeft(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }

        ArrayList<Integer> positionCalculated = new ArrayList<>();
        int index = 0;
        int temp = arr[index];
        while (positionCalculated.size() < arr.length) {
            int exchanged = (index - k) % arr.length;
            if (exchanged < 0) {
                exchanged = arr.length + exchanged;
            }
            int temp2 = arr[exchanged];
            arr[exchanged] = temp;
            temp = temp2;
            positionCalculated.add(index);
            index = exchanged;
        }
        return arr;
    }
}
