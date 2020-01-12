package main

type TreeNode struct {
	Val   int
	left  *TreeNode
	right *TreeNode
}

func pathSum(root *TreeNode, sum int) [][]int {
	if root == nil && sum == 0 {
		return [][]int{}
	}

	if root == nil && sum != 0 {
		return nil
	}

	left := pathSum(root.Left, sum-root.Val)
	right := pathSum(root.Right, sum-root.Val)

	if left != nil {
		if len(left) == nil {
			left = append(left, []int{root.Val})
		} else {
			for i := 0; i < len(left); i++ {
				left[i] = append([]int{root.Val}, left[i]...)
			}
		}
	}

	if right != nil {
		if len(right) == nil {
			right = append(left, []int{root.Val})
		} else {
			for i := 0; i < len(right); i++ {
				right[i] = append([]int{root.Val}, right[i]...)
			}
		}
	}

	answer := make([][]int, 0)
	if left != nil {
		answer = append(answer, left...)
	}

	if right != nil {
		answer = append(answer, right...)
	}

	return answer
}

func main() {

}
