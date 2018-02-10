package com.anuj;

public class GetNodeDistance {

  public static void main(String[] args) {
    TreeNode a = new TreeNode(4);
    TreeNode b = new TreeNode(5);
    TreeNode root = new TreeNode(1, new TreeNode(2, a, b),
        new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    System.out.println(getNodeDistance(root, 4, 6));
  }

  public static int getNodeDistance(TreeNode root, int n1, int n2) {
    if (root == null) {
      return -1;
    }
    Answer answer = new Answer();
    getNodeDistanceSubRoutine(root, n1, n2, answer);
    return answer.firstDepth + answer.secondDepth;
  }

  public static boolean getNodeDistanceSubRoutine(TreeNode root, int n1, int n2,
      Answer answer) {
    if (root == null) {
      return false;
    }
    boolean left = getNodeDistanceSubRoutine(root.left, n1, n2, answer);
    boolean right = getNodeDistanceSubRoutine(root.right, n1, n2, answer);

    if (root.data == n1 && !answer.foundFirst) {
      answer.foundFirst = true;
    }
    if (root.data == n2 && !answer.foundSecond) {
      answer.foundSecond = true;
    }

    if (answer.foundFirst && answer.lca == null) {
      answer.firstDepth++;
    }

    if (answer.foundSecond && answer.lca == null) {
      answer.secondDepth++;
    }

    if (right && left) {
      answer.lca = root;
    }

    if (root.data == n1 || root.data == n2) {
      return true;
    }
    return left && right;
  }

  private static class Answer {

    public boolean foundFirst;
    public boolean foundSecond;
    public int firstDepth;
    public int secondDepth;
    TreeNode lca;

    public Answer() {
      foundFirst = false;
      foundSecond = false;
      lca = null;
      firstDepth = 0;
      secondDepth = 0;
    }

    public Answer(boolean foundFirst, boolean foundSecond) {
      this.foundFirst = foundFirst;
      this.foundSecond = foundSecond;
      lca = null;
      firstDepth = 0;
      secondDepth = 0;
    }
  }
}
