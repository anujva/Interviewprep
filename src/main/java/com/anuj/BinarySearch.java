package com.anuj;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2,3,4,5,6,7}, 8));
    }

    public static boolean binarySearch(int[] arr, int searchElement) {
        //returns -1 when element not found;
        if (arr == null || arr.length == 0) {
            return false;
        }
        int mid = arr.length / 2;
        if (arr[mid] == searchElement) {
            return true;
        } else if (arr[mid] > searchElement) {
            int[] arrTillMid = new int[mid];
            for (int i = 0; i < mid; i++) {
                arrTillMid[i] = arr[i];
            }
            binarySearch(arrTillMid, searchElement);
        } else {
            int[] arrFromMid = new int[arr.length - mid - 1];
            for (int i = mid + 1; i < arr.length; i++) {
                arrFromMid[i - mid - 1] = arr[i];
            }
            binarySearch(arrFromMid, searchElement);
        }
        return false;
    }
}
