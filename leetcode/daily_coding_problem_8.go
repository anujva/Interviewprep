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

	length := 0
	if valRight != nil && valLeft != nil && root.Val == *valRight && root.Val == *valLeft {
		length = lengthRight + lengthLeft + 2
	} else if valRight != nil && root.Val == *valRight {
		length = lengthRight + 1
	} else if valLeft != nil && root.Val == *valLeft {
		length = lengthLeft + 1
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
	root1 := &TreeNode{
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

	root2 := &TreeNode{
		Val: 1,
		Left: nil,
		Right: &TreeNode{
			Val: 1,
			Left: &TreeNode{
				Val: 1,
				Left: &TreeNode{
					Val: 1,
					Left: nil,
					Right: nil,
				},
				Right: &TreeNode{
					Val: 1,
					Left: nil,
					Right: nil,
				},
			},
			Right: &TreeNode{
				Val: 1,
				Left: &TreeNode{
					Val: 1,
					Left: nil,
					Right: nil,
				},
				Right: nil,
			},
		},
	}

	fmt.Println(longestUnivaluePath(root1))
	fmt.Println(longestUnivaluePath(root2))
}
