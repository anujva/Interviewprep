package com.anuj;

public class BinaryTreeMaxElement {

    public static int findMax(TreeNode root) {
        int leftMax = Integer.MIN_VALUE;
        if (root.left != null) {
            leftMax = findMax(root.left);
        }

        int rightMax = Integer.MIN_VALUE;
        if (root.right != null) {
            rightMax = findMax(root.right);
        }

        return Math.max(Math.max(root.data, leftMax), rightMax);
    }

    private static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(10), new TreeNode(2));
        System.out.println(findMax(root));
    }
}
