
package com.anuj;

class DoublyLinkedNode {
    int data;
    DoublyLinkedNode next;
    DoublyLinkedNode prev;

    public DoublyLinkedNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DoublyLinkedNode{" + "data=" + data + '}';
    }
}

public class InsertNodeAtSpePosDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedNode head = new DoublyLinkedNode(1);
        head.next = new DoublyLinkedNode(2);
        head.next.prev = head;

        head.next.next = new DoublyLinkedNode(3);
        head.next.next.prev = head.next;
        head = insertAtPos(head, 4, 4);
        System.out.println(head);
        System.out.println(head.next);
        System.out.println(head.next.next);
        System.out.println(head.next.next.next);
        //        System.out.println(head.next.prev);
        //        System.out.println(head.prev);
    }

    public static DoublyLinkedNode insertAtPos(DoublyLinkedNode head, int data, int pos) {
        if (pos < 1) {
            return head;
        }

        if (pos == 1) {
            //insert at head
            DoublyLinkedNode temp = new DoublyLinkedNode(data);
            if (head == null) {
                return temp;
            }
            temp.next = head;
            head.prev = temp;
            head = temp;
            return head;
        }

        int position = 2;
        DoublyLinkedNode temp = head;
        while (position++ < pos) {
            if (temp.next != null) {
                temp = temp.next;
            } else {
                return head;
            }
        }
        DoublyLinkedNode tempNext = temp.next;
        DoublyLinkedNode newData = new DoublyLinkedNode(data);
        temp.next = newData;
        newData.prev = temp;
        newData.next = tempNext;
        return head;
    }
}
