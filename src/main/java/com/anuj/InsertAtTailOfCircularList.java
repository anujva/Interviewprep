package com.anuj;

import java.util.Stack;

public class InsertAtTailOfCircularList {
    public static void main(String[] args) {
        System.out.println(insertAtTail(null, 1).val);
    }

    public static ListNode insertAtTail(ListNode head, int data) {
        if (head == null) {
            head = new ListNode(data);
            head.next = head;
            return head;
        }

        if (head == head.next) {
            ListNode temp = new ListNode(data);
            head.next = temp;
            temp.next = head;
            return head;
        }

        ListNode beforeHead = head;
        ListNode temp = head.next;
        while (temp != head) {
            temp = temp.next;
            beforeHead = beforeHead.next;
        }

        beforeHead.next = new ListNode(data);
        beforeHead.next.next = head;
        return head;
    }

    public TreeNode findNode(TreeNode root, int val) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            if (currentNode.data == val) {
                return currentNode;
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }
        return null;
    }
}
