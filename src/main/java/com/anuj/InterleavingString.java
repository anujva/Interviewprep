package com.anuj;

public class InterleavingString {
    public static void main(String[] args) {
        System.out.println(isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }

    public static boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }

    public static boolean isInterleave(String s1, String s2, String s3,
                                       int i1, int i2, int i3) {
        boolean isInterleaved = false;
        if (i1 == s1.length() && i2 == s2.length() && i3 == s3.length()) {
            return true;
        }
        if (i1 < s1.length() && i3 < s3.length()) {
            if (s1.charAt(i1) == s3.charAt(i3)) {
                isInterleaved |= isInterleave(s1, s2, s3, i1 + 1, i2, i3 + 1);
            }
        }
        if (i2 < s2.length() && i3 < s3.length()) {
            if (s2.charAt(i2) == s3.charAt(i3)) {
                isInterleaved |= isInterleave(s1, s2, s3, i1, i2 + 1, i3 + 1);
            }
        }
        return isInterleaved;
    }
}
