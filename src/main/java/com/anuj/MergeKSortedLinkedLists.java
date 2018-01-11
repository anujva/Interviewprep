package com.anuj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
    public static void main(String[] args) {
        ArrayList<ListNode> lists = new ArrayList<>();
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);
        ListNode head3 = new ListNode(5);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(13);
        head1.next.next.next = new ListNode(20);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(35);
        head2.next.next.next = new ListNode(40);
        head3.next = new ListNode(6);
        head3.next.next = new ListNode(12);
        head3.next.next.next = new ListNode(18);

        lists.add(head1);
        lists.add(head2);
        lists.add(head3);

        ListNode answer = mergeKLists(lists);

        while (answer != null) {
            System.out.println(answer.val);
            answer = answer.next;
        }
    }

    public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        ListNode[] arrIndices = new ListNode[lists.size()];
        PriorityQueue<ListNode> priorityQueueWrapper = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                if (o1.val > o2.val) return 1;
                return 0;
            }
        });
        //initialize arrIndices
        for (int i = 0; i < lists.size(); i++) arrIndices[i] = lists.get(i);
        //initialize the priorityqueue
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                priorityQueueWrapper.add(new ListNode(lists.get(i).val));
                lists.set(i, lists.get(i).next);
            }
        }
        boolean iteratedThroughAllElements = false;
        ListNode answerHead = priorityQueueWrapper.peek();
        ListNode answer = answerHead;
        while (!iteratedThroughAllElements) {
            iteratedThroughAllElements = true;
            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < lists.size(); i++) {
                iteratedThroughAllElements = iteratedThroughAllElements && lists.get(i) == null;
                if (lists.get(i) != null && min > lists.get(i).val) {
                    min = lists.get(i).val;
                    minIndex = i;
                }
            }
            if (!iteratedThroughAllElements && lists.get(minIndex) != null) {
                priorityQueueWrapper.add(new ListNode(lists.get(minIndex).val));
                answer.next = priorityQueueWrapper.poll();
                lists.set(minIndex, lists.get(minIndex).next);
                answer = answer.next;
            }
        }

        while (priorityQueueWrapper.size() > 0) {
            answer.next = priorityQueueWrapper.poll();
            answer = answer.next;
        }

        return answerHead;
    }

    private static class PriorityQueueWrapper {
        private final int maxSize;
        private PriorityQueue<ListNode> priorityQueue;

        PriorityQueueWrapper(int maxSize) {
            this.maxSize = maxSize;
            priorityQueue = new PriorityQueue<>((o1, o2) -> {
                if (o1.val < o2.val) return -1;
                if (o1.val > o2.val) return 1;
                return 0;
            });
        }

        public ListNode addListNode(ListNode node) {
            priorityQueue.add(node);
            ListNode minNode;
            if (priorityQueue.size() < maxSize) {
                minNode = null;
            } else {
                minNode = priorityQueue.poll();
            }
            return minNode;
        }

        public ListNode getMinAndRemoveFromQueue() {
            return priorityQueue.poll();
        }

        public int getQueueSize() {
            return priorityQueue.size();
        }

        public ListNode peek() {
            return priorityQueue.peek();
        }
    }
}
