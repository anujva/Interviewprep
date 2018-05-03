package com.anuj.geeksforgeeks;

import com.anuj.TreeNode;

public class CheckBst {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)),
                new TreeNode(8, new TreeNode(1), new TreeNode(9)));
        System.out.println(isBST(root, null, null));
    }

    public static boolean isBST(TreeNode root, Integer max, Integer min) {
        if (root == null) return true;
        boolean checkHolds = true;
        if (max != null) {
            checkHolds = checkHolds && root.data < max;
        }
        if (min != null) {
            checkHolds = checkHolds && root.data > min;
        }
        boolean isLeftTrue = isBST(root.left, root.data, min);
        boolean isRightTrue = isBST(root.right, max, root.data);
        return checkHolds && isLeftTrue && isRightTrue;
    }
}
