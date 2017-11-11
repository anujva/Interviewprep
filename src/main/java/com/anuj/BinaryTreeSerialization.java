package com.anuj;

public class BinaryTreeSerialization {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4, new TreeNode(8), null), null),
                new TreeNode(3, null,
                        new TreeNode(5, new TreeNode(6), new TreeNode(7))));
        root.printTreeNode();
        String serialize = serializeTree(root);
        System.out.println(serialize);
        TreeNode newRoot = restoreTree(serialize);
        newRoot.printTreeNode();
    }

    public static String serializeTree(TreeNode root) {
        if (root == null) return null;
        String left = null;
        if (root.left != null) {
            left = serializeTree(root.left);
        }

        String right = null;
        if (root.right != null) {
            right = serializeTree(root.right);
        }

        StringBuffer answer = new StringBuffer();
        answer.append(root.data);

        appendToAnswer(left, answer);

        appendToAnswer(right, answer);

        return answer.toString();
    }

    private static void appendToAnswer(String string, StringBuffer answer) {
        if (string != null) {
            if (answer.length() > 0) {
                answer.append(',').append(string);
            } else {
                answer.append(string);
            }
        } else {
            if (answer.length() > 0) {
                answer.append(',').append('*');
            } else {
                answer.append('*');
            }
        }
    }

    public static TreeNode restoreTree(String str) {
        //we need to restore the tree from the string.
        if (str == null) return null;
        String[] splitString = str.split(",");
        //based on what the value is
        if (splitString.length <= 0) return null;
        TreeNode root = new TreeNode(Integer.parseInt(splitString[0]));
        restoreTreeSubroutine(splitString, 1, root);
        return root;
    }

    public static int restoreTreeSubroutine(String[] strings, int index, TreeNode root) {
        if (root == null) return index;
        if (!strings[index].equalsIgnoreCase("*")) {
            root.left = new TreeNode(Integer.parseInt(strings[index]));
        }
        index = restoreTreeSubroutine(strings, index + 1, root.left);
        if (!strings[index].equalsIgnoreCase("*")) {
            root.right = new TreeNode(Integer.parseInt(strings[index]));
        }
        index = restoreTreeSubroutine(strings, index + 1, root.right);
        return index;
    }
}
