package main

import "fmt"

func subarraySum(nums []int, k int) int {
	count := 0
	memoize := make([][]int, len(nums))
	for i := 0; i < len(nums); i++ {
		memoize[i] = make([]int, len(nums))
	}

	for i := 0; i < len(nums); i++ {
		memoize[i][i] = nums[i]
	}

	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			memoize[i][j] = memoize[i][j-1] + nums[j]
			if memoize[i][j] == k {
				count = count + 1
			}
		}
	}
	fmt.Println(memoize)
	return count
}

func main() {
	fmt.Println(subarraySum([]int{1, 1, 1}, 2))
}
