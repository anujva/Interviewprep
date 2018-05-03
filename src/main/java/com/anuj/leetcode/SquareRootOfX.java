package com.anuj.leetcode;

public class SquareRootOfX {

    public static void main(String[] args) {
        System.out.println(mySqrt(674478281));
    }

    public static int mySqrt(int x) {
        int interimRoot = mySqrt(x, 1, x);
        if(interimRoot * interimRoot > x) {
            interimRoot--;
        }
        return interimRoot;
    }

    public static int mySqrt(int x, int start, int end) {
        if (start >= end) {
            return start;
        }
        //I am going to decrease the range by +-1 of the mid
        int mid = start + (end - start) / 2;
        if (mid == x / mid) {
            return mid;
        } else if (mid < x / mid) {
            return mySqrt(x, mid + 1, end);
        } else if (mid > x / mid) {
            return mySqrt(x, start, mid - 1);
        }
        return -1;
    }
}
