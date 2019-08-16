package main

import (
	"fmt"
	"strconv"
)

func findMissingRanges(nums []int, lower int, upper int) []string {
	missingRanges := make([]string, 0)
	nums = append([]int{lower - 1}, nums...)
	nums = append(nums, upper+1)
	for i := 1; i < len(nums); i++ {
		if nums[i]-nums[i-1] > 1 {
			// there are some missing numbers
			if nums[i]-nums[i-1] == 2 {
				missingRanges = append(missingRanges, strconv.Itoa(nums[i-1]+1))
			} else {
				missingRanges = append(missingRanges, strconv.Itoa(nums[i-1]+1)+"->"+strconv.Itoa(nums[i]-1))
			}
		}
	}

	return missingRanges
}

func main() {
	fmt.Println(findMissingRanges([]int{0, 1, 3, 50, 75}, 0, 99))
}
