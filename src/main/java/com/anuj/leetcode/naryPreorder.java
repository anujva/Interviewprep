package com.anuj.leetcode;

import java.util.*;

public class naryPreOrder {
    class Node {
        private int val;
        private List<Node> children;

        public Node() {

        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> answer = new ArrayList<>(root.val);
        for (Node child: root.children) {
            answer.addAll(preorder(child));
        }
        return answer;
    }

    public static void main(String []args) {

    }
}