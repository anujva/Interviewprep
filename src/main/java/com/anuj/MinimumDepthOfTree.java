package com.anuj;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class MinimumDepthOfTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20, new TreeNode(15,
                                                      new TreeNode(10), new TreeNode(30)), new TreeNode(40));
        System.out.println(minTreeDepth(root));
    }

    public static int minTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        Map<TreeNode, Integer> depthCount = new HashMap<>();
        depthCount.put(root, 1);
        while (!queue.isEmpty()) {
            TreeNode firstInQueue = queue.removeFirst();
            int depth = depthCount.get(firstInQueue);
            if (firstInQueue.left == null && firstInQueue.right == null) {
                return depth;
            }
            if (firstInQueue.left != null && !depthCount.containsKey(firstInQueue.left)) {
                queue.addLast(firstInQueue.left);
                depthCount.put(firstInQueue.left, depth + 1);
            }
            if (firstInQueue.right != null && !depthCount.containsKey(firstInQueue.right)) {
                queue.addLast(firstInQueue.right);
                depthCount.put(firstInQueue.right, depth + 1);
            }
        }
        return -1;
    }
}
