package com.anuj;

public class StealANode {
    public static void main(String[] args) {

    }

    public TreeNode delete(TreeNode root, int data) {
        if (root == null ) return null;
        //root is not null and doesn't have the data that needs
        //to be deleted
        deleteSubRoutine(root, root.left, true, data);
        deleteSubRoutine(root, root.right, false, data);

        return root;
    }

    public void deleteSubRoutine(TreeNode root, TreeNode child, boolean left, int data) {
        assert root != null;
        if (child == null) return;

        if (child.data == data) {
            //This is where the deletion of the node needs to happen
            //Is this child the right or the left child
            if (left) {
                if (child.right != null) {
                    root.left = child.right;
                    //if there is a left node to the child
                    //it has to be added to the tree
                    if (child.left != null)
                        addToTree(child.right, child.left);
                } else if (child.left != null) {
                    root.left = child.left;
                } else {
                    //both the right and left child of the child
                    //is null
                    root.left = null;
                }
            } else {
                if (child.right != null) {
                    root.right = child.right;
                    //if there is a left node to the child
                    //it has to be added to the tree
                    if (child.left != null)
                        addToTree(child.right, child.left);
                } else if (child.left != null) {
                    root.right = child.left;
                } else {
                    //both the right and left child of the child
                    //is null
                    root.right = null;
                }
            }

            return;
        }
        deleteSubRoutine(child, child.left, true, data);
        deleteSubRoutine(child, child.right, false, data);
    }

    public void addToTree(TreeNode root, TreeNode child) {
        if (root != null) {
            if (root.data < child.data) {
                if (root.right != null) {
                    addToTree(root.right, child);
                } else {
                    root.right = child;
                }
            } else {
                if (root.left != null) {
                    addToTree(root.left, child);
                } else {
                    root.left = child;
                }
            }
        }
    }
}
