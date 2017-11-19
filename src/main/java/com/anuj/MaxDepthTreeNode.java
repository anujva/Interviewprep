package com.anuj;

public class MaxDepthTreeNode {
    public static void main(String[] args) {

    }

    public TreeNode findDeepest(TreeNode root) {
        return findDeepestSubroutine(new TreeNodeWithLevel(root, 0)).node;
    }

    public TreeNodeWithLevel findDeepestSubroutine(TreeNodeWithLevel root) {
        if (root == null) return null;

        TreeNodeWithLevel fromTheDepthsLeft = findDeepestSubroutine(new TreeNodeWithLevel(root.node.left, root.level + 1));
        TreeNodeWithLevel fromTheDepthsRight = findDeepestSubroutine(new TreeNodeWithLevel(root.node.right, root.level + 1));

        if (fromTheDepthsRight == null && fromTheDepthsLeft == null) return root;
        if (fromTheDepthsLeft == null) {
            return fromTheDepthsRight;
        }
        if (fromTheDepthsRight == null) {
            return fromTheDepthsLeft;
        }

        return root;
    }

    public static class TreeNodeWithLevel {
        TreeNode node;
        int level;

        public TreeNodeWithLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
