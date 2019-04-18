package main

import "fmt"

/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 * There was a fundamental flaw in my understanding of the question. When the values are being returned from
 * two separate branches, that is the length of the final path and shouldn't be set the length
 */
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func longestUnivaluePath(root *TreeNode) int {
	if root == nil {
		return 0
	}
	_, _, maxLength := getLength(root)
	return maxLength - 1
}

func getLength(root *TreeNode) (*int, int, int) {
	if root == nil {
		return nil, 0, 0
	}

	valRight, lengthRight, maxLengthRight := getLength(root.Right)
	valLeft, lengthLeft, maxLengthLeft := getLength(root.Left)

	length := 0
	lengthLeftRight := 0
	if valRight != nil && valLeft != nil && root.Val == *valRight && root.Val == *valLeft {
		lengthLeftRight = lengthLeft + lengthRight + 1
	}

	if valRight != nil && root.Val == *valRight {
		lengthRight = lengthRight + 1
	}

	if valLeft != nil && root.Val == *valLeft {
		lengthLeft = lengthLeft + 1
	}

	if lengthRight < lengthLeft {
		length = lengthLeft
	} else {
		length = lengthRight
	}

	maxLength := length
	if maxLength < maxLengthLeft {
		maxLength = maxLengthLeft
	}
	if maxLength < maxLengthRight {
		maxLength = maxLengthRight
	}
	if maxLength < lengthLeftRight {
		maxLength = lengthLeftRight
	}
	return intPtr(root.Val), length, maxLength
}

func intPtr(i int) *int {
	return &i
}

func main() {
	root1 := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 4,
			Left: &TreeNode{
				Val:   4,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   4,
				Left:  nil,
				Right: nil,
			},
		},
		Right: &TreeNode{
			Val:  5,
			Left: &TreeNode{
				Val:   5,
				Left:  nil,
				Right: nil,
			},
			Right: nil,
		},
	}

	root2 := &TreeNode{
		Val:  1,
		Left: nil,
		Right: &TreeNode{
			Val: 1,
			Left: &TreeNode{
				Val: 1,
				Left: &TreeNode{
					Val:   1,
					Left:  nil,
					Right: nil,
				},
				Right: &TreeNode{
					Val:   1,
					Left:  nil,
					Right: nil,
				},
			},
			Right: &TreeNode{
				Val: 1,
				Left: &TreeNode{
					Val:   1,
					Left:  nil,
					Right: nil,
				},
				Right: nil,
			},
		},
	}

	fmt.Println(longestUnivaluePath(root1))
	fmt.Println(longestUnivaluePath(root2))
}
