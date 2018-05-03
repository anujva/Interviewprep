
package com.anuj;

public class ValidateBST {
    public static void main(String[] args) {

    }

    public static boolean validateBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int maxValue = validateBSTSubRoutineFindMax(root.left);
        int minValue = validateBSTSubRoutineFindMin(root.right);
        if (root.data < minValue && root.data > maxValue) {
            return true;
        }

        return false;
    }

    public static int validateBSTSubRoutineFindMax(TreeNode node) {
        if (node == null) return Integer.MIN_VALUE;
        return Math.max(Math.max(node.data, validateBSTSubRoutineFindMax(node
                .right)), validateBSTSubRoutineFindMax(node.left));
    }

    public static int validateBSTSubRoutineFindMin(TreeNode node) {
        if (node == null) return Integer.MAX_VALUE;
        return Math.min(Math.min(node.data, validateBSTSubRoutineFindMin(node
                .left)), validateBSTSubRoutineFindMin(node.right));
    }
}
