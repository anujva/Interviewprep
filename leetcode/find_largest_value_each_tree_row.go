package main

import "fmt"

// You need to find the largest value in each row of a binary tree.
//		1
//	   / \
//	  3   2
//	 / \ / \
//	5  3    9

// Output: [1, 3, 9]

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func largestValues(root *TreeNode) []int {
	if root == nil {
		return []int{}
	}

	left := largestValues(root.Left)
	right := largestValues(root.Right)

	// find the
	l, b := lessOf(len(left), len(right))
	var answer []int
	if b {
		answer = make([]int, len(left))
	} else {
		answer = make([]int, len(right))
	}

	i := 0
	for ; i < l; i++ {
		val := max(left[i], right[i])
		answer[i] = val
	}

	for ; i < len(answer); i++ {
		if b {
			answer[i] = left[i]
		} else {
			answer[i] = right[i]
		}
	}
	answer = append([]int{root.Val}, answer...)
	return answer
}

func max(x, y int) int {
	if x < y {
		return y
	}
	return x
}

func lessOf(x, y int) (int, bool) {
	if x < y {
		return x, false
	}
	return y, true
}

func main() {
	root := &TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 3,
			Left: &TreeNode{
				Val:   5,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   3,
				Left:  nil,
				Right: nil,
			},
		},
		Right: &TreeNode{
			Val:  2,
			Left: nil,
			Right: &TreeNode{
				Val:   9,
				Left:  nil,
				Right: nil,
			},
		},
	}
	fmt.Println(largestValues(root))
}
