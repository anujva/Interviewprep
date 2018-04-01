package com.anuj.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationSequence {

    public static void main(String[] args) {
        String permutation = getPermutation(3, 6);
        System.out.println(permutation);
    }

    public static String getPermutation(int n, int k) {
        String buffer = new String();
        for (int i = 1; i < n + 1; i++) {
            buffer = buffer.concat(Integer.toString(i));
        }

        //if k == 1
        if (k == 1) {
            return buffer.toString();
        }

        List<String> permutedSet = permute(buffer.toString());
        return permutedSet.get(k - 1);
    }

    public static List<String> permute(String str) {
        if (str == null || str.length() == 0) {
            return new ArrayList<>();
        }
        if (str.length() == 1) {
            return new ArrayList<>(Arrays.asList(str));
        }
        List<String> currentBuffer = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            List<String> permutedBuffer = permute(new String(
                str.substring(0, i) + str.substring(i + 1)
            ));
            for (String strBuf : permutedBuffer) {
                currentBuffer.add(str.charAt(i) + strBuf.toString());
            }
        }
        return currentBuffer;
    }
}
