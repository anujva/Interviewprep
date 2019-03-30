package main

import "fmt"

func largestRectangleArea(heights []int) int {
	maxSeenSoFar := -1
	for i := 0; i < len(heights); i++ {
		if maxSeenSoFar < maxPossibleHeight(i, heights) {
			maxSeenSoFar = maxPossibleHeight(i, heights)
		}
	}

	return maxSeenSoFar
}

// Max possible height from the index i
func maxPossibleHeight(index int, heights []int) int {
	minHeight := heights[index]
	maxArea := -1
	width := 1
	for i := index; i > -1; i-- {
		if heights[i] < minHeight {
			minHeight = heights[i]
		}
		if minHeight*width > maxArea {
			maxArea = minHeight * width
		}
		width = width + 1
	}

	return maxArea
}

func main() {
	fmt.Println(largestRectangleArea([]int{2, 1, 5, 6, 3, 3}))
}
