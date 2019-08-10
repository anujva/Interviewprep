package main

import "fmt"

func canJump(nums []int) bool {
	// depending on the index I am at
	return canJumpIndex(nums, 0, 0)
}

func canJumpIndex(nums []int, index int, level int) bool {
	fmt.Println("Index: ", index, "level: ", level)
	if index >= len(nums)-1 {
		return true
	}

	for i := 1; i <= nums[index]; i++ {
		if canJumpIndex(nums, index+i, level+1) {
			return true
		}
	}

	return false
}

func canJumpTake2(nums []int) bool {
	//starting from the first we need to see if we are able to get to the last
	if len(nums) == 1 {
		return true
	}

	m := make([]bool, len(nums))
	m[len(nums)-1] = true

	for i := len(nums) - 2; i > -1; i-- {
		for j := 1; j <= nums[i]; j++ {
			if i+j < len(nums) && m[i+j] {
				m[i] = true
				break
			}
		}
	}

	return m[0]
}

func main() {
	fmt.Println(canJumpTake2([]int{2, 3, 1, 1, 4}))
	fmt.Println(canJumpTake2([]int{3, 2, 1, 0, 4}))
}
