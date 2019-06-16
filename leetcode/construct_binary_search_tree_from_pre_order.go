package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func bstFromPreorder(preorder []int) *TreeNode {
	if len(preorder) == 0 {
		return nil
	}

	// TreeNode for the head.
	head := &TreeNode{
		Val: preorder[0],
	}

	// divide the array into two parts. one part with all values less than the value at [0]
	index := -1
	for i := 1; i < len(preorder); i++ {
		if preorder[i] > preorder[0] {
			index = i
			break
		}
	}

	// index is the point where we have the values that go to the right of the bst;
	if index != -1 {
		preOrderLeft := preorder[1:index]
		preOrderRight := preorder[index:]
		head.Right = bstFromPreorder(preOrderRight)
		head.Left = bstFromPreorder(preOrderLeft)
	} else {
		// there are no values left that are bigger than the current node value
		// all values will be to the left
		preOrderLeft := preorder[1:]
		head.Left = bstFromPreorder(preOrderLeft)
	}

	return head
}

func PrintTreePreOrder(head *TreeNode) {
	if head == nil {
		return
	}

	fmt.Println(head.Val)
	PrintTreePreOrder(head.Left)
	PrintTreePreOrder(head.Right)
}

func main() {
	head := bstFromPreorder([]int{8, 5, 1, 7, 10, 12})
	PrintTreePreOrder(head)
	fmt.Println("")
	head = bstFromPreorder([]int{4, 2, 1})
	PrintTreePreOrder(head)
}
