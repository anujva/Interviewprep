package com.anuj;

import java.util.Arrays;

/**
 * Created by anuj on 5/24/17.
 */
public class FindMaxLength {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer("bcda");
        char[] arrForWord = buffer.toString().toCharArray();
        Arrays.sort(arrForWord);
        System.out.println(new String(arrForWord));
    }

    public int findMaxLength(int[] nums) {
        return 0;
    }
}
