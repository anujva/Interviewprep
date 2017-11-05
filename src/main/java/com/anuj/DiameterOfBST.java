/*
 * Copyright (c) 2016 GE. All Rights Reserved.
 * GE Confidential: Restricted Internal Distribution
 */
package com.anuj;

public class DiameterOfBST {
    public static void main(String[] args) {

    }

    public static int diameter(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = 0;
        if (root.left != null) {
            left = maxLengthFromRoot(root.left, 1);
        }
        int right = 0;
        if (root.right != null) {
            right = maxLengthFromRoot(root.right, 1);
        }

        int diameterLeft = diameter(root.left);
        int diameterRight = diameter(root.right);
        int currentMax = left + right + 1;

        return Math.max(Math.max(diameterLeft, diameterRight), currentMax);
    }

    public static int maxLengthFromRoot(TreeNode root, int height) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return height;
        }
        int leftMax = Integer.MIN_VALUE;
        if (root.left != null) {
            leftMax = maxLengthFromRoot(root.left, height + 1);
        }
        int rightMax = Integer.MIN_VALUE;
        if (root.right != null) {
            rightMax = maxLengthFromRoot(root.right, height + 1);
        }
        return leftMax > rightMax ? leftMax : rightMax;
    }
}
