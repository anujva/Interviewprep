
package com.anuj;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecompressTree {
    public static void main(String[] args) {
        TreeNode root = decompress("1,2,3,4,*,6,*");
        root.printTreeNode();
    }

    public static TreeNode decompress(String str) {
        String[] nodes = str.split(",");
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode head = null;
        if (nodes.length > 0) {
            queue.add(head = new TreeNode(Integer.parseInt(nodes[0])));
            int i = 1;
            while (!queue.isEmpty() && i < nodes.length) {
                TreeNode currentNode = queue.poll();
                if (!nodes[i].equalsIgnoreCase("*")) {
                    currentNode.left = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.add(currentNode.left);
                }
                i++;
                if (!nodes[i].equalsIgnoreCase("*")) {
                    currentNode.right = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.add(currentNode.right);
                }
                i++;
            }
        }
        return head;
    }
}
