package main

import "fmt"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
*/
type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func longestUnivaluePath(root *TreeNode) int {
	if root == nil {
		return 0
	}
	_, _ , maxLength := getLength(root)
	return maxLength
}

func getLength(root *TreeNode) (*int, int, int) {
	if root == nil {
		return nil, 0, 0
	}
	valRight, lengthRight, maxLengthRight := getLength(root.Right)
	valLeft, lengthLeft, maxLengthLeft := getLength(root.Left)

	if valRight != nil && root.Val == *valRight {
		lengthRight = lengthRight + 1
	}

	if valLeft != nil && root.Val == *valLeft {
		lengthLeft = lengthLeft + 1
	}

	length := 1
	if lengthLeft > lengthRight {
		if length < lengthLeft {
			length = lengthLeft
		}
	} else {
		if length < lengthRight {
			length = lengthRight
		}
	}
	maxLength := 0
	if maxLengthLeft > maxLengthRight {
		if length > maxLengthLeft {
			maxLength = length
		} else {
			maxLength = maxLengthLeft
		}
	} else {
		if length > maxLengthRight {
			maxLength = length
		} else {
			maxLength = maxLengthRight
		}
	}
	return intPtr(root.Val), length, maxLength
}

func intPtr(i int) *int {
	return &i
}

func main() {
	root := &TreeNode{
		Val: 5,
		Left: &TreeNode {
			Val: 4,
			Left: &TreeNode {
				Val: 1,
				Left: nil,
				Right: nil,
			},
			Right: &TreeNode {
				Val: 1,
				Left: nil,
				Right: nil,
			},
		},
		Right: &TreeNode{
			Val: 5,
			Left: nil,
			Right: &TreeNode{
				Val: 5,
				Left: nil,
				Right: nil,
			},
		},
	}

	fmt.Println(longestUnivaluePath(root))
}
