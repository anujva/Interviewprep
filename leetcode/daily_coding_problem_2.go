package main

import (
	"errors"
	"fmt"
)

// Given an array of integers, return a new array such that each element at index i of the new array is the product of
// all the numbers in the original array except the one at i
func productExceptIndex(arr []int64) ([]int64, error) {
	// find the product of all the elements in the array, that is not zero.
	// if there are two zeros, there is no way there is going to be a product
	// that will a non zero
	prod := arr[0]
	zeroFound := 0
	zeroIndex := -1
	for i := 1; i < len(arr); i++ {
		if arr[i] == 0 {
			zeroFound = zeroFound + 1
			zeroIndex = i
			continue
		}
		prod = prod * arr[i]
	}
	// I have found the product
	if zeroFound > 1 {
		answer := make([]int64, len(arr))
		for i := 0; i < len(arr); i++ {
			answer[i] = 0
		}
		return answer, nil
	}

	if zeroFound == 1 {
		answer := make([]int64, len(arr))
		for i := 0; i < len(arr); i++ {
			if i != zeroIndex {
				answer[i] = 0
			} else {
				answer[i] = prod
			}
		}
		return answer, nil
	}

	if zeroFound == 0 {
		answer := make([]int64, len(arr))
		for i := 0; i < len(arr); i++ {
			answer[i] = prod / arr[i]
		}
		return answer, nil
	}
	return []int64{0}, errors.New("Cannot be converted to class")
}

func main() {
	answer1, _ := productExceptIndex([]int64{1, 2, 3, 4, 5})
	fmt.Println(answer1)
	answer2, _ := productExceptIndex([]int64{1, 0, 3, 4, 5})
	fmt.Println(answer2)
	answer3, _ := productExceptIndex([]int64{1, 0, 0, 4, 5})
	fmt.Println(answer3)
}
