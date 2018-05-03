package com.anuj.leetcode;

public class ConstructAllPossibleBST {
    public static void main(String[] args) {
        System.out.println(constructBST(5));
    }

    /**
     * Catalan Number. A sequence of natural numbers that occur in various
     * counting problems, often involving recursively-defined objects.
     *
     * @param n
     * @return
     */
    public static int constructBST(int n) {
        int[] num = new int[n + 1];

        num[0] = 1;
        num[1] = 1;

        for (int i = 2; i <= n; i++) {
            //get num 0 and 1 and put them together
            //take two number and put it together.
            int sum = 0;
            for (int j = 0; j < i; j++) {
                int first = j;
                int second = (i - j - 1);
                sum += num[first] * num[second];
            }
            num[i] = sum;
        }

        return num[n];
    }

    //Given a number how many bst can you create.

    /**
     * In order to create a bst we have to
     *
     * @param n
     * @return
     */
    public static int constructBSTActually(int n) {
        //BST needs to be created with nodes..
        return 0;
    }
}
