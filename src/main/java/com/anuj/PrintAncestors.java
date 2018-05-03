package com.anuj;

import java.util.ArrayList;
import java.util.Collections;

public class PrintAncestors {
    public static ArrayList<Integer> ancestorsList = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2,
                                                     new TreeNode(4), new TreeNode(5)),
                                     new TreeNode(3, new TreeNode(6), new TreeNode(7)));

        System.out.println(printAncestors(root, 5));
        for (int i = 0; i < ancestorsList.size(); i++) {
            System.out.print(ancestorsList.get(i) + " ");
        }
    }

    public static boolean printAncestors(TreeNode root, int nodeData) {
        return printAncestorsSubRoutine(root, nodeData, ancestorsList, ancestorsList);
    }

    public static boolean printAncestorsSubRoutine(TreeNode root, int nodeData,
                                                   ArrayList<Integer> ancestorsList, ArrayList<Integer>
                                                           ancestorsListOriginal) {
        if (root == null) {
            return false;
        }
        if (root.data == nodeData) {
            Collections.reverse(ancestorsList);
            ancestorsListOriginal.addAll(ancestorsList);
            return true;
        }
        ArrayList<Integer> ancestorsListTemp = new ArrayList<>(ancestorsList);
        ancestorsListTemp.add(root.data);
        ArrayList<Integer> leftAncestors = new ArrayList<>(ancestorsListTemp);
        boolean foundLeft = printAncestorsSubRoutine(root.left, nodeData, leftAncestors, ancestorsListOriginal);
        ArrayList<Integer> rightAncestors = new ArrayList<>(ancestorsListTemp);
        boolean foundRight = printAncestorsSubRoutine(root.right, nodeData, rightAncestors, ancestorsListOriginal);

        return foundLeft || foundRight;
    }
}
