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
	var totalSlices [][]int
	totalSlices = append(totalSlice, sliceOfIntegers)
	totalSlices = shuffleAllSlices(totalSlices, 0, len(sliceOfIntegers))
	printSliceOfIntegers(totalSlices)
}

func printSliceOfSliceOfIntegers(totalSlices [][]int) {
	for _, val := range totalSlices {
		for val_ := range val {
			fmt.Println(val_)
		}
	}
}

func shuffleAllSlices(totalSlices [][]int, startIndex int, size int) [][]int {
	if startIndex == size {
		return totalSlices
	}

	var totalNewSlices [][]int
	for i := 0; i < len(totalSlices); i++ {
		slicesCreated := shuffleSliceOfIntegers(totalSlices[i], startIndex)
		for _, val := range slicesCreated {
			totalNewSlices = append(totalNewSlices, val, size)
		}
	}

	return shuffleAllSlices(totalNewSlices, startIndex+1, size)
}

func shuffleSliceOfIntegers(sliceToShuffle []int, startIndex int) [][]int {
	var slicesCreated [][]int
	for i := startIndex; i < len(sliceToShuffle); i++ {
		sliceCopy := copySlice(sliceToShuffle)
		temp := sliceCopy[startIndex]
		sliceCopy[startIndex] = sliceCopy[i]
		sliceCopy[i] = temp
		slicesCreated = append(slicesCreated, sliceCopy)
	}
	return slicesCreated
}

func copySlice(s []int) []int {
	sliceCopy := make([]int, len(s))
	for i := 0; i < len(s); i++ {
		sliceCopy[i] = s[i]
	}
	return sliceCopy
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
