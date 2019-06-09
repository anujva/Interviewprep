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

// This seems like it will work but it doesn't
// There are multiple different ways in which the string that
// is generated by traversing the tree can lead to the same string
// even though they are not mirrors
func isSymmetricWrong(root *TreeNode) bool {
	str1 := getStringLeft(root)
	str2 := getStringRight(root)
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

func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}

	return isEqual(root.Left, root.Right)
}

func isEqual(left *TreeNode, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	}

	if left == nil {
		return false
	}

	if right == nil {
		return false
	}

	if left.Val != right.Val {
		return false
	}

	return isEqual(left.Left, right.Right) && isEqual(left.Right, right.Left)
}

func main() {
	fmt.Println(isSymmetricWrong(&TreeNode{
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
