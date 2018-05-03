package com.anuj;

public class PathLengthOfNodeFromRoot {
    public static void main(String[] args) {

    }

    public static int pathLengthFromRoot(TreeNode root, int n1) {
        int length = 0;
        return pathLengthSubRoutine(root, n1, length);
    }

    public static int pathLengthSubRoutine(TreeNode root, int n1, int length) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.data == n1) {
            return length;
        }

        int distLeft = pathLengthSubRoutine(root.left, n1, length + 1);
        int distRight = pathLengthSubRoutine(root.right, n1, length + 1);

        return distLeft < distRight ? distLeft : distRight;
    }
}
