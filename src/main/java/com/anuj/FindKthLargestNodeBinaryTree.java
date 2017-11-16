package com.anuj;

import java.util.PriorityQueue;

public class FindKthLargestNodeBinaryTree {
    public static void main(String[] args) {

    }

    public TreeNode findKthLargest(TreeNode root, int k) {
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.data < o2.data) return -1;
            else if (o1.data > o2.data) return 1;
            else return 0;
        });
        findKthLargestSubRoutine(root, k, priorityQueue);
        return priorityQueue.poll();
    }

    public void findKthLargestSubRoutine(TreeNode root, int k, PriorityQueue<TreeNode> priorityQueue) {
        if (root == null) return;
        if (root.data > priorityQueue.peek().data) {
            if (priorityQueue.size() == k) {
                priorityQueue.poll();
            }
            priorityQueue.add(root);
        }
        findKthLargestSubRoutine(root.left, k, priorityQueue);
        findKthLargestSubRoutine(root.right, k, priorityQueue);
    }
}
