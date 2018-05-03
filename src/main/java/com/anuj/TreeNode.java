package com.anuj;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void printTreeNode() {
        preOrderPrintTree(this);
        System.out.println();
    }

    private void preOrderPrintTree(TreeNode root) {
        if (root == null) {
            System.out.print(" --> null");
            return;
        }
        System.out.print(" --> " + root.data);
        preOrderPrintTree(root.left);
        preOrderPrintTree(root.right);
    }
}
