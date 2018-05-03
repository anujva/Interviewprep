package com.anuj;

import java.util.ArrayList;

public class FindLCA {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(4);
        TreeNode b = new TreeNode(5);
        TreeNode root = new TreeNode(1, new TreeNode(2, a, b),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        TreeNode lca = findLCA(root, a, b);
        System.out.println("LCA data: " + lca.data);
    }

    public static TreeNode findLCA(TreeNode root, TreeNode a, TreeNode b) {
        if (root == a || root == b) return root;
        ArrayList<TreeNode> lca = new ArrayList<>();
        boolean found = findLCASubroutine(root, a, b, lca);
        if (found) {
            assert lca.size() == 1;
            return lca.get(0);
        }
        return null;
    }

    public static boolean findLCASubroutine(TreeNode root, TreeNode a, TreeNode b, ArrayList<TreeNode> lca) {
        if (root == null) return false;
        boolean left = findLCASubroutine(root.left, a, b, lca);
        boolean right = findLCASubroutine(root.right, a, b, lca);

        if (root == a) {
            if (left && lca.isEmpty()) {
                lca.add(root);
            }
            if (right && lca.isEmpty()) {
                lca.add(root);
            }
            return true;
        }
        if (root == b) {
            if (left && lca.isEmpty()) {
                lca.add(root);
            }
            if (right && lca.isEmpty()) {
                lca.add(root);
            }
            return true;
        }
        if (right && left && lca.isEmpty()) {
            lca.add(root);
        }
        return left || right;
    }
}
