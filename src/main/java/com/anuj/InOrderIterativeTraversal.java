
package com.anuj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class InOrderIterativeTraversal {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> inorderItr(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<TreeNode> poppedNodes = new HashSet<>();
        while (!stack.isEmpty()) {
            if (stack.peek().left != null && !poppedNodes.contains(stack.peek().left)) {
                stack.push(stack.peek().left);
            } else {
                TreeNode top = stack.pop();
                poppedNodes.add(top);
                answer.add(top.data);
                if (top.right != null) {
                    stack.push(top.right);
                }
            }
        }
        return answer;
    }
}
