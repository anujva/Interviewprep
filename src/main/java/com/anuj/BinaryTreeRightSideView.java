package com.anuj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by anuj on 5/18/17.
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> allValuesSeenFromRight = new ArrayList<>();
        int level = 0;
        //go down the binary tree, right most root first and then
        addRightMostValues(root, allValuesSeenFromRight, level);
        return allValuesSeenFromRight;
    }

    private static void addRightMostValues(TreeNode root, List<Integer> allValuesSeenFromRight, int level) {
        if (root == null) {
            return;
        }

        if (level == allValuesSeenFromRight.size()) {
            allValuesSeenFromRight.add(root.val);
        }

        addRightMostValues(root.right, allValuesSeenFromRight, level + 1);
        addRightMostValues(root.left, allValuesSeenFromRight, level + 1);
    }

    public static List<Integer> rightSideViewWrongUnderstanding(TreeNode root) {
        List<Integer> allValues = new ArrayList<>();
        if (root == null) {
            return allValues;
        }
        allValues.add(root.val);
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root.right != null) {
            queue.add(root.right);
        }
        while (!queue.isEmpty()) {
            TreeNode currentVal = queue.removeLast();
            allValues.add(currentVal.val);
            if (currentVal.left != null) {
                queue.add(currentVal.left);
            }
            if (currentVal.right != null) {
                queue.add(currentVal.right);
            }
        }
        return allValues;
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }
}
