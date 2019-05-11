package main

import (
	"fmt"
	"strconv"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	str1 := getStringLeft(root.Left)
	str2 := getStringRight(root.Right)
	fmt.Println("String 1: ", str1, " String 2: ", str2)
	return str1 == str2
}

func getStringLeft(root *TreeNode) string {
	if root == nil {
		return "*"
	}

	return getStringLeft(root.Left) + strconv.Itoa(root.Val) + getStringLeft(root.Right)
}

func getStringRight(root *TreeNode) string {
	if root == nil {
		return "*"
	}

	if root.Left == nil && root.Right == nil {
		return strconv.Itoa(root.Val)
	}

	return getStringRight(root.Right) + strconv.Itoa(root.Val) + getStringRight(root.Left)
}

func main() {
	fmt.Println(isSymmetric(&TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val:   2,
				Left:  nil,
				Right: nil,
			},
			Right: nil,
		},
		Right: &TreeNode{
			Val: 2,
			Left: &TreeNode{
				Val:   2,
				Left:  nil,
				Right: nil,
			},
			Right: nil,
		},
	}))
}
