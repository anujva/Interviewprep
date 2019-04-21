package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
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
			Val: 5,
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

	fmt.Println(longestUnivaluePath2(root1))
	fmt.Println(longestUnivaluePath2(root2))
}

func longestUnivaluePath2(root *TreeNode) int {
	if root == nil {
		return 0
	}
	_, maxLength := longestUniValuePath2SubRoutine(root)
	return maxLength
}

func longestUniValuePath2SubRoutine(root *TreeNode) (int, int) {
	if root == nil {
		return 0, 0
	}

	lengthLeft, maxLengthLeft := longestUniValuePath2SubRoutine(root.Left)
	lengthRight, maxLengthRight := longestUniValuePath2SubRoutine(root.Right)

	length := 1
	maxLength := 1
	if root.Right != nil && root.Val == root.Right.Val && root.Left != nil && root.Val == root.Left.Val {
		// test for the maxLength
		maxLength = maxOf3(maxLengthLeft, maxLengthRight, lengthLeft+lengthRight+1)
	} else {
		maxLength = max(maxLengthLeft, maxLengthRight)
	}

	if root.Right != nil && root.Val == root.Right.Val {
		lengthRight = lengthRight + 1
	} else {
		lengthRight = 1
	}

	if root.Left != nil && root.Val == root.Left.Val {
		lengthLeft = lengthLeft + 1
	} else {
		lengthLeft = 1
	}

	length = max(lengthLeft, lengthRight)

	if maxLength < length {
		maxLength = length
	}

	return length, maxLength
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}

func maxOf3(x, y, z int) int {
	if x < y {
		return max(y, z)
	} else {
		return max(x, z)
	}
}
