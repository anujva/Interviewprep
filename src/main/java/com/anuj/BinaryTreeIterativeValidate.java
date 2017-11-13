package com.anuj;

import java.util.Stack;

public class BinaryTreeIterativeValidate {
    public static void main(String[] args) {

    }

    public static boolean validateBSTItr(TreeNode root) {
        if (root == null) return true;
        //Need to create a range.. all values to the left, its easy to manage
        //it has to be less than the value of the root, but all values to the
        //right has to be in the range. This is for the left side, for the right
        //side we have the same issue.
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

        }

        return false;
    }
}
