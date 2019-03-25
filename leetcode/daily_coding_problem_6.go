package main

import "fmt"

/**
* Problem statement
	The idea of the problem is to find the max value of the sum of non-adjacent numbers in an array.
	If the array is [5, 1, 9, 5]

	Implementation is complete, memoization is probably the next step
*/

func maxSumNonAdjacent(arr []int) int {
	if len(arr) == 0 {
		return 0
	}

	if len(arr) == 1 {
		return arr[0]
	}

	if len(arr) == 2 {
		return max(arr[0], arr[1])
	}

	return max(arr[0]+maxSumNonAdjacent(arr[2:]), maxSumNonAdjacent(arr[1:]))
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	fmt.Println(maxSumNonAdjacent([]int{5, 1, 9, 5}))
}
