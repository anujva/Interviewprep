package com.anuj;


public class BinaryTreeSize {

    public static int size(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftSize = 0;
        if (root.left != null) {
            leftSize = size(root.left);
        }

        int rightSize = 0;
        if (root.right != null) {
            rightSize = size(root.right);
        }

        return leftSize + rightSize + 1;
    }

    public static void main(String[] args) {

    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
}
