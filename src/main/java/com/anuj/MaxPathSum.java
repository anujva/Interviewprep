
package com.anuj;

public class MaxPathSum {
    public static void main(String[] args) {

    }

    public static int maxSumPath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxSumAtNodeAsRoot = new int[1];
        maxSumAtNodeAsRoot[0] = Integer.MIN_VALUE;
        int maxSum = maxSumPath(root, maxSumAtNodeAsRoot);
        //once we have returned we have to check if maxSum is greater
        //or the value in maxSumAtNodeAsRoot is greater.
        return maxSum > maxSumAtNodeAsRoot[0] ? maxSum : maxSumAtNodeAsRoot[0];
    }

    public static int maxSumPath(TreeNode root, int[] maxSumAtNodeAsRoot) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.left != null) {
            left = maxSumPath(root.left, maxSumAtNodeAsRoot);
        }
        int right = 0;
        if (root.right != null) {
            right = maxSumPath(root.right, maxSumAtNodeAsRoot);
        }

        if (root.left == null && root.right == null) {
            return root.data;
        }
        if (maxSumAtNodeAsRoot[0] < left + right + root.data) {
            maxSumAtNodeAsRoot[0] = left + right + root.data;
        }
        return Math.max(root.data + left, root.data + right);
    }
}
