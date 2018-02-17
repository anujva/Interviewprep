package com.anuj;

import java.util.ArrayList;

public class FindTheMaxSumLevel {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1, new TreeNode(2
    , new TreeNode(4), new TreeNode(5)),
        new TreeNode(3, new TreeNode(6), new
        TreeNode(7)));
    System.out.println(findMaxSumLevel(root));
  }

  public static int findMaxSumLevel(TreeNode root) {
    if (root == null) {
      return -1;
    }
    ArrayList<Integer> levelSum = new ArrayList<>();
    //This is the easiest way of getting this done.
    findMaxSumLevel(root, levelSum, 0);

    //find the min value in ArrayList
    int max = levelSum.get(0);
    int index = 0;
    for (int i = 0; i < levelSum.size(); i++) {
      if (max < levelSum.get(i)) {
        max = levelSum.get(i);
        index = i;
      }
    }
    return index;
  }

  private static void findMaxSumLevel(TreeNode root,
      ArrayList<Integer> levelSum, int level) {
    if (root == null) {
      return;
    }
    if (levelSum.size() == level) {
      //that means that
      levelSum.add(root.data);
    } else {
      levelSum.set(level, levelSum.get(level) + root.data);
    }
    findMaxSumLevel(root.left, levelSum, level + 1);
    findMaxSumLevel(root.right, levelSum, level + 1);
  }
}
