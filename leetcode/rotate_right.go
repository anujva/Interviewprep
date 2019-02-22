package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func rotateRight(head *ListNode, k int) *ListNode {
	// Traversal and then rotating the list once to the right
	// till k drops to 0, could work
	if k == 0 {
		return head
	}

	// find the tail and the one before the tail
	var tail, beforeTail *ListNode
	current := head
	for current.Next != nil {
		beforeTail = current
		current = current.Next
		tail = current
	}

	// When the loop exits tail is pointing to the last element
	// beforeTail is pointing to tail
	// head is pointing to the head
	beforeTail.Next = nil
	tail.Next = head
	head = tail
	return rotateRight(head, k-1)
}

func printList(head *ListNode) {
	for head != nil {
		fmt.Println(head.Val)
		head = head.Next
	}
}

func main() {
	head := &ListNode{Val: 5, Next: &ListNode{
		Val: 6, Next: nil,
	},
	}
	printList(head)
	printList(rotateRight(head, 3))
}
