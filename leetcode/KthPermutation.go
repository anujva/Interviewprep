package main

import (
	"fmt"
)

func getSliceOfIntegers(n int) []int {
	sliceOfIntegers := make([]int, 0)
	for i := 0; i < n; i++ {
		sliceOfIntegers = append(sliceOfIntegers, i)
	}
	return sliceOfIntegers
}

// KthPermutationSequence does the Kth Permutations
func KthPermutationSequence(n int) {
	sliceOfIntegers := getSliceOfIntegers(n)
	printSliceOfIntegers(sliceOfIntegers)
}

func printSliceOfIntegers(si []int) {
	for _, val := range si {
		fmt.Printf("%v ", val)
	}
	fmt.Println()
}

func main() {
	KthPermutationSequence(4)
}
