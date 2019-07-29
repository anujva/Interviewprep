package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func zigzagLevelOrder(root *TreeNode) [][]int {
	answer := make([][]int, 0)

	if root == nil {
		return answer
	}

	getZigZagLevelOrder(root, 0, &answer)
	return answer
}

func getZigZagLevelOrder(root *TreeNode, level int, answer *[][]int) {
	if root == nil {
		return
	}

	if len(*answer) == level {
		*answer = append(*answer, []int{})
	}

	if level%2 == 0 {
		(*answer)[level] = append((*answer)[level], root.Val)
	} else {
		(*answer)[level] = append([]int{root.Val}, (*answer)[level]...)
	}

	getZigZagLevelOrder(root.Left, level+1, answer)
	getZigZagLevelOrder(root.Right, level+1, answer)
}

func main() {
	root := &TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val:   9,
			Left:  nil,
			Right: nil,
		},
		Right: &TreeNode{
			Val: 20,
			Left: &TreeNode{
				Val:   15,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   7,
				Left:  nil,
				Right: nil,
			},
		},
	}

	fmt.Println(zigzagLevelOrder(root))
}
