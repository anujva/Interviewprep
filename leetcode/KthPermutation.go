package main

import "os"

func getSliceOfIntegers(n int) []int {
	sliceOfIntegers := make([]int, 0)
	for i := 0; i < n; i++ {
		sliceOfIntegers = append(sliceOfIntegers, i)
	}
	return sliceOfIntegers
}

// KthPermutationSequence does the Kth Permutations
func KthPermutationSequence(int n) {
	sliceOfIntegers := getSliceOfIntegers(n)
}

func main() {
	args := os.Args[1:]
}
