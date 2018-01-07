package com.anuj;

public class StealANode {
    public static void main(String[] args) {

    }

    public static TreeNode delete(TreeNode root, int data) {
        if (root == null) return null;
        if (root.data == data) {
            if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
            return root;
        }
        deleteNode(root, root.left, data);
        deleteNode(root, root.right, data);

        return root;
    }

    public static void deleteNode(TreeNode root, TreeNode currentNode, int data) {
        if (currentNode == null) return;
        if (currentNode.data == data) {
            if (currentNode.left != null) {
                root = currentNode.left;
            } else if (currentNode.right != null) {
                root = currentNode.right;
            } else {
                currentNode = null;
            }
            return;
        }
        deleteNode(currentNode, currentNode.left, data);
        deleteNode(currentNode, currentNode.right, data);
    }
}
