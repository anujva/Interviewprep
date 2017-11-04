package com.anuj;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TransposeMatrix {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(-1, null, null), null);
        TreeNode answer = findKthSmallest(root, 1);
        System.out.println(answer.data);
    }

    public static void transposeMatrix(int[][] matrix) {
        //We are given a square 2D matrix.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void flipVertically(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void flipHorizontally(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = 0; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - i][j];
                matrix[matrix.length - 1 - i][j] = temp;
            }
        }
    }

    public static boolean isAnagram(String input1, String input2) {
        //calculate frequency of characters in input1
        HashMap<Character, Integer> input1Freq = new HashMap<>();
        for (int i = 0; i < input1.length(); i++) {
            if (input1Freq.containsKey(input1.charAt(i))) {
                int currentFreq = input1Freq.get(input1.charAt(i));
                input1Freq.put(input1.charAt(i), currentFreq + 1);
            } else {
                input1Freq.put(input1.charAt(i), 1);
            }
        }
        //calculate frequency of characters in input2
        HashMap<Character, Integer> input2Freq = new HashMap<>();
        for (int i = 0; i < input2.length(); i++) {
            if (input2Freq.containsKey(input2.charAt(i))) {
                int currentFreq = input2Freq.get(input2.charAt(i));
                input2Freq.put(input2.charAt(i), currentFreq + 1);
            } else {
                input2Freq.put(input2.charAt(i), 1);
            }
        }
        //both should match
        for (Map.Entry<Character, Integer> entry : input1Freq.entrySet()) {
            if (input2Freq.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public static TreeNode findKthSmallest(TreeNode root, int k) {
        Comparator<TreeNode> comparator = new Comparator<TreeNode>() {
            @Override
            public int compare(TreeNode o1, TreeNode o2) {
                if (o1.data < o2.data) {
                    return -1;
                } else if (o1.data > o2.data) {
                    return 1;
                } else {
                    return 0;
                }
            }
        };
        PriorityQueue<TreeNode> priorityQueue = new PriorityQueue<>(comparator);
        findKthSmallestSubRoutine(root, k, priorityQueue);
        return priorityQueue.peek();
    }

    public static void findKthSmallestSubRoutine(TreeNode root, int k, PriorityQueue<TreeNode> priorityQueue) {
        if (root == null) {
            return;
        }
        if (priorityQueue.size() < k + 1) {
            priorityQueue.add(root);
        } else if (priorityQueue.peek().data > root.data) {
            priorityQueue.remove();
            priorityQueue.add(root);
        }

        findKthSmallestSubRoutine(root.left, k, priorityQueue);
        findKthSmallestSubRoutine(root.right, k, priorityQueue);
    }
}
