package main

import "fmt"

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func levelOrder(root *TreeNode) [][]int {
	// I want to find the nodes in level order
	m := make(map[int][]int, 0)
	levelOrderWithAnswer(root, m, 0)

	//convert the map to [][] 2d array
	answer := make([][]int, len(m))
	for k, v := range m {
		answer[k] = v
	}
	return answer
}

func levelOrderWithAnswer(root *TreeNode, answer map[int][]int, level int) {
	if root == nil {
		return
	}

	if v, ok := answer[level]; ok {
		answer[level] = append(v, root.Val)
	} else {
		answer[level] = []int{root.Val}
	}

	//continue with the name map downwards
	levelOrderWithAnswer(root.Left, answer, level+1)
	levelOrderWithAnswer(root.Right, answer, level+1)
}

func combine(answer [][]int, answerLeft [][]int, answerRight [][]int) {

}

func main() {
	fmt.Println(levelOrder(&TreeNode{
		Val: 1,
		Left: &TreeNode{
			Val: 2,
		},
		Right: &TreeNode{
			Val: 4,
		},
	}))
}
