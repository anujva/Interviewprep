package com.anuj;

public class InsertNodeAtSpecifiedPosition {
    public static void main(String[] args) {
        ListNode head = insertAtPosition(null, 5, 1);
        head = insertAtPosition(head, 5, 1);
        head = insertAtPosition(head, 5, 3);
        printList(head);
    }

    public static ListNode insertAtPosition(ListNode head, int data, int pos) {
        if (pos < 1) return head;
        if (head == null && pos != 1) return null;
        if (head == null && pos == 1) return new ListNode(data);

        ListNode temp = head;
        ListNode beforeTemp = null;

        int position = 1;
        boolean posGreaterThanTail = false;
        boolean addToHead = true;
        while (position++ < pos) {
            addToHead = false;
            beforeTemp = temp;
            if (temp == null) posGreaterThanTail = true;
            else temp = temp.next;
        }
        if (posGreaterThanTail) return head;
        if (addToHead) {
            ListNode newNode = new ListNode(data);
            newNode.next = head;
            head = newNode;
            return head;
        }
        beforeTemp.next = new ListNode(data);
        beforeTemp.next.next = temp;
        return head;
    }

    public static final void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ----> ");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
