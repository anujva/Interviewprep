package com.anuj;

public class GetNodeDistance {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(5);
        TreeNode root = new TreeNode(1, new TreeNode(2, a, b),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        System.out.println(getNodeDistance(root, 4, 7));
    }

    public static int getNodeDistance(TreeNode root, int n1, int n2) {
        if (root == null) {
            return -1;
        }
        Answer answer = getNodeDistanceSubRoutine(root, n1, n2);
        return answer.firstDepth + answer.secondDepth;
    }

    public static Answer getNodeDistanceSubRoutine(TreeNode root, int n1, int n2) {
        if (root == null) {
            return new Answer();
        }
        Answer left = getNodeDistanceSubRoutine(root.left, n1, n2);
        Answer right = getNodeDistanceSubRoutine(root.right, n1, n2);

        //if left or right lca are non null;
        if (left.lca != null) return left;
        if (right.lca != null) return right;
        //check if the left and right have found anything.
        if (left.foundFirst && right.foundSecond) {
            //this is the lca.
            Answer answer = new Answer(left.foundFirst, right.foundSecond);
            answer.firstDepth = left.firstDepth + 1;
            answer.secondDepth = right.secondDepth + 1;
            answer.lca = root;
            return answer;
        } else if (left.foundFirst) {
            if (root.data != n2) {
                left.firstDepth = left.firstDepth + 1;
                return left;
            } else {
                left.firstDepth = left.firstDepth + 1;
                left.secondDepth = 0;
                left.foundSecond = true;
                left.lca = root;
                return left;
            }
        } else if (right.foundSecond) {
            if (root.data != n1) {
                right.secondDepth += 1;
                return right;
            } else {
                right.foundFirst = true;
                right.firstDepth = 0;
                right.secondDepth += 1;
                right.lca = root;
                return right;
            }
        } else if (left.foundSecond && right.foundFirst) {
            Answer answer = new Answer(right.foundFirst, left.foundSecond);
            answer.firstDepth = right.firstDepth + 1;
            answer.secondDepth = left.secondDepth + 1;
            answer.lca = root;
            return answer;
        } else if (left.foundSecond) {
            if (root.data == n1) {
                left.foundFirst = true;
                left.firstDepth = 0;
                left.secondDepth += 1;
                left.lca = root;
                return left;
            } else {
                left.secondDepth += 1;
                return left;
            }
        } else if (right.foundFirst) {
            if (root.data == n2) {
                right.foundSecond = true;
                right.secondDepth = 0;
                right.firstDepth += 1;
                right.lca = root;
                return right;
            } else {
                right.firstDepth += 1;
                return right;
            }
        }

        //both left and right are null.
        Answer answer = new Answer();
        if (root.data == n1) {
            answer.foundFirst = true;
            answer.firstDepth = 0;
        } else if (root.data == n2) {
            answer.foundSecond = true;
            answer.secondDepth = 0;
        }

        return answer;
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
            firstDepth = -1;
            secondDepth = -1;
        }

        public Answer(boolean foundFirst, boolean foundSecond) {
            this.foundFirst = foundFirst;
            this.foundSecond = foundSecond;
            lca = null;
            firstDepth = -1;
            secondDepth = -1;
        }
    }
}
