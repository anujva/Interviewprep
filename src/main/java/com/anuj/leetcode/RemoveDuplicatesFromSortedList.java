package com.anuj.leetcode;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        ListNode duplicatedList = new ListNode(1, new ListNode(4, new ListNode(4)));
        ListNode head = deleteDuplicates(duplicatedList);

        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode prevCurrentNode = null;
        ListNode currentNode = head;
        boolean duplicates = false;
        //how to keep track of the head;
        //the head of the list is going to be when the first time
        //prevCurrentNode is set to not null value;
        while (currentNode != null) {
            if (currentNode.next != null) {
                if (currentNode.data != currentNode.next.data) {
                    //if the current data is not equal to next data.
                    //we have to see if the case is:
                    // 4 -> 5 or 4-> 5 -> 5 -> 6
                    //or 5-> 5-> 6
                    if (!duplicates) {
                        if (prevCurrentNode == null) {
                            head = currentNode;
                        }
                        prevCurrentNode = currentNode;
                        currentNode = currentNode.next;
                    } else {
                        if (prevCurrentNode == null) {
                            //there are duplicates and prevCurrentNode is still null
                            //this would mean that we have only met duplicates
                            //till now and not enough infomation to set the prevCurrentNode
                            currentNode = currentNode.next;
                        } else {
                            prevCurrentNode.next = currentNode.next;
                            currentNode.next = null;
                            currentNode = prevCurrentNode.next;
                        }
                        duplicates = false;
                    }
                } else {
                    duplicates = true;
                    currentNode = currentNode.next;
                }
            } else {
                //currentNode is pointing to the end of the list right now
                if (duplicates) {
                    if (prevCurrentNode == null) {
                        return null;
                    } else {
                        prevCurrentNode.next = null;
                    }
                } else {
                    if (prevCurrentNode == null) {
                        prevCurrentNode = currentNode;
                        head = currentNode;
                    }
                }
                currentNode = currentNode.next;
            }
        }
        return head;
    }
}
