package main

func findBottomLeftValue(root *TreeNode) int {
	// need a way to find the depth and the value.
	// from each node, return the value that has the
	// ghihgest depth and the leftmost value
	_, val := findBottomSubroutine(root, 0)
	return *val
}

func findBottomSubroutine(root *TreeNode, height int) (int, *int) {
	if root == nil {
		return height, nil
	}

	leftHeight, leftValue := findBottomSubroutine(root.Left, height+1)
	rightHeight, rightValue := findBottomSubroutine(root.Right, height+1)

	if leftHeight > rightHeight {
		if leftValue != nil {
			return leftHeight, leftValue
		}

		if rightValue != nil {
			return rightHeight, rightValue
		}
	}

	if leftHeight < rightHeight {
		if rightValue != nil {
			return rightHeight, rightValue
		}

		if leftValue != nil {
			return leftHeight, leftValue
		}
	}

	if leftHeight == rightHeight {
		if leftValue != nil {
			return leftHeight, leftValue
		}

		if rightValue != nil {
			return rightHeight, rightValue
		}
	}

	// this would mean that both the leftValue and rightValue were nil
	return height, root.Val
}

func intPtr(v int) *int {
	return &v
}
