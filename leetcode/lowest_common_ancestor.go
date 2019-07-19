package main

import "fmt"

func lowestCommonAncestor(root, p, q *TreeNode) *TreeNode {
	// can find all the ancestors of p.
	// find the ancestors of q.
	// the first one that matches is the lowestCommonAncestor

	ancestorsOfp := getAncestors(root, p)
	ancestorsOfq := getAncestors(root, q)
	m := map[*TreeNode]bool{}
	for _, v := range ancestorsOfp {
		m[v] = true
	}

	for _, v := range ancestorsOfq {
		if m[v] {
			return v
		}
	}
	return nil
}

func getAncestors(root, node *TreeNode) []*TreeNode {
	if root == nil {
		return nil
	}

	if root == node {
		return []*TreeNode{node}
	}

	left := getAncestors(root.Left, node)
	if left != nil {
		return append(left, root)
	}
	right := getAncestors(root.Right, node)
	if right != nil {
		return append(right, root)
	}
	return nil
}

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func (t *TreeNode) String() string {
	return fmt.Sprintf("%d", t.Val)
}

func main() {
	root := &TreeNode{
		Val: 3,
		Left: &TreeNode{
			Val: 5,
			Left: &TreeNode{
				Val:   6,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val: 2,
				Left: &TreeNode{
					Val:   7,
					Left:  nil,
					Right: nil,
				},
				Right: &TreeNode{
					Val:   4,
					Right: nil,
					Left:  nil,
				},
			},
		},
		Right: &TreeNode{
			Val: 1,
			Left: &TreeNode{
				Val:   0,
				Left:  nil,
				Right: nil,
			},
			Right: &TreeNode{
				Val:   8,
				Left:  nil,
				Right: nil,
			},
		},
	}

	fmt.Printf("%+v", getAncestors(root, root.Left.Right.Left))
}
