package com.anuj;

public class BinaryTreeMirror {
    public static void main(String[] args) {

    }

    public static TreeNode mirror(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirror(root.left);
        mirror(root.right);
        return root;
    }
}
