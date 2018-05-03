package com.anuj;

import java.util.HashMap;
import java.util.Stack;

public class BSTValidateIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(20, new TreeNode(15,
                                                      new TreeNode(10), new TreeNode(30)), new TreeNode(40));
//        TreeNode root1 = new TreeNode(20, new TreeNode(30,
//                                                       new TreeNode(14), new TreeNode(18)), new TreeNode(15));
        System.out.println(validateBSTItr(root));
    }

    public static boolean validateBSTItr(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNodeWrapper> stackOfNodes = new Stack<>();
        stackOfNodes.push(new TreeNodeWrapper(root, null, null));

        HashMap<TreeNode, TreeNodeWrapper> visitedNodes = new HashMap<>();
        while (!stackOfNodes.isEmpty()) {
            TreeNodeWrapper treeNodeWrapper = stackOfNodes.peek();
            if (treeNodeWrapper.node.left != null && !visitedNodes.containsKey(treeNodeWrapper.node.left)) {
                stackOfNodes.push(new TreeNodeWrapper(treeNodeWrapper.node.left, null, null));
                continue;
            }
            if (treeNodeWrapper.node.right != null && !visitedNodes.containsKey(treeNodeWrapper.node.right)) {
                stackOfNodes.push(new TreeNodeWrapper(treeNodeWrapper.node.right, null, null));
                continue;
            }
            treeNodeWrapper = stackOfNodes.pop();
            if (treeNodeWrapper.node.right == null && treeNodeWrapper.node.left == null) {
                treeNodeWrapper.maxValue = treeNodeWrapper.node.data;
                treeNodeWrapper.minValue = treeNodeWrapper.node.data;
            } else if (treeNodeWrapper.node.left == null) {
                TreeNodeWrapper rightNode = visitedNodes.get(treeNodeWrapper.node.right);
                if (!(treeNodeWrapper.node.data < rightNode.node.data && treeNodeWrapper.node.data < rightNode
                        .minValue)) {
                    return false;
                }
                treeNodeWrapper.maxValue = rightNode.maxValue;
                treeNodeWrapper.minValue = treeNodeWrapper.node.data;
            } else if (treeNodeWrapper.node.right == null) {
                TreeNodeWrapper leftNode = visitedNodes.get(treeNodeWrapper.node.left);
                if (!(treeNodeWrapper.node.data > leftNode.node.data
                        && treeNodeWrapper.node.data > leftNode.maxValue)) {
                    return false;
                }
                treeNodeWrapper.maxValue = treeNodeWrapper.node.data;
                treeNodeWrapper.minValue = leftNode.minValue;
            } else {
                //both right and left are non null
                TreeNodeWrapper leftNode = visitedNodes.get(treeNodeWrapper.node.left);
                TreeNodeWrapper rightNode = visitedNodes.get(treeNodeWrapper.node.right);

                if (!(treeNodeWrapper.node.data > leftNode.node.data
                        && treeNodeWrapper.node.data > leftNode.maxValue) || !(
                        treeNodeWrapper.node.data < rightNode.node.data && treeNodeWrapper.node.data < rightNode
                                .minValue)) {
                    return false;
                }
                treeNodeWrapper.maxValue = rightNode.maxValue;
                treeNodeWrapper.minValue = leftNode.minValue;
            }
            visitedNodes.put(treeNodeWrapper.node, treeNodeWrapper);
        }
        return true;
    }

    private static class TreeNodeWrapper {
        public TreeNode node;
        public Integer minValue;
        public Integer maxValue;

        public TreeNodeWrapper(TreeNode node, Integer minValue, Integer maxValue) {
            this.node = node;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }
}
