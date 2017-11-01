package com.anuj;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintBinaryTreeLevelByLevel {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                                     new TreeNode(2,
                                                  new TreeNode(4), new TreeNode(5)),
                                     new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        ArrayList<ArrayList<Integer>> levelAnswer = printLevelByLevel(root);
        System.out.println(levelAnswer);
    }

    public static ArrayList<ArrayList<Integer>> printLevelByLevel(TreeNode root) {
        ArrayList<ArrayList<Integer>> levelAnswers = new ArrayList<>();
        printLevelByLevelSubroutine(root, 0, levelAnswers);
        return levelAnswers;
    }

    public static void printLevelByLevelSubroutine(TreeNode root, int level,
                                                   ArrayList<ArrayList<Integer>> valuesLevel) {
        if (root == null) {
            return;
        }
        if (valuesLevel.size() - 1 < level) {
            valuesLevel.add(new ArrayList<>(Arrays.asList(root.data)));
        } else {
            ArrayList<Integer> values = valuesLevel.get(level);
            values.add(root.data);
        }
        printLevelByLevelSubroutine(root.left, level + 1, valuesLevel);
        printLevelByLevelSubroutine(root.right, level + 1, valuesLevel);
    }
}
