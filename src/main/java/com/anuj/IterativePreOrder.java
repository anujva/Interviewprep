
package com.anuj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class IterativePreOrder {
    public static void main(String[] args) {

    }

    public ArrayList<Integer> preorderItr(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        ArrayList<Integer> answer = new ArrayList<>();
        while (!stack.isEmpty()) {
            TreeNode med = stack.pop();
            answer.add(med.data);

            if (med.left != null) {
                stack.push(med.left);
            }

        }
        return answer;
    }
}
