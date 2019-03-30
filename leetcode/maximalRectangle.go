package main

// Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle
// containing only 1's and returns its area.
func maximalRectangle(matrix [][]byte) int {
	// The idea would be to find the largest rectangle
	// from every starting index
	largestRectangle := 0
	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			// start from this index and try to find the largest rectangle
			k := getLargestRectangeAtIndex(i, j, matrix)
			if largestRectangle < k {
				largestRectangle = k
			}
		}
	}
	return largestRectangle
}

func largestRectangleAtIndex(i, j int, matrix [][]byte) int {
	for row := i; row < len(matrix); row++ {

	}
}
