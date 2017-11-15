package com.anuj;

import java.util.HashSet;
import java.util.Stack;

public class SumOfBinaryTreeIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20, new TreeNode(15,
                                                      new TreeNode(10), new TreeNode(30)), new TreeNode(40));
        System.out.println(sumItr(root));
    }

    public static int sumItr(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> visitedNodes = new HashSet<>();

        stack.push(root);
        int sum = 0;
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            visitedNodes.add(top);
            sum += top.data;
            if (top.left != null && !visitedNodes.contains(top.left)) {
                stack.push(top.left);
            }

            if (top.right != null && !visitedNodes.contains(top.right)) {
                stack.push(top.right);
            }
        }
        return sum;
    }
}
