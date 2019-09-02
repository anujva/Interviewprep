package main

import "fmt"

type NumArray struct {
	val  []int
	sums []int
}

func Constructor(nums []int) NumArray {
	numArray := NumArray{
		val: nums,
	}

	sums := make([]int, len(nums))
	sums[0] = nums[0]
	for i := 1; i < len(nums); i++ {
		sums[i] = nums[i] + sums[i-1]
	}
	numArray.sums = sums
	return numArray
}

func (this *NumArray) Update(i int, val int) {
	// update the value and the sums that we keep for each index
	difference := val - this.val[i]
	this.val[i] = val
	//
	for index := i; index < len(this.sums); index++ {
		this.sums[index] = this.sums[index] + difference
	}
}

func (this *NumArray) SumRange(i int, j int) int {
	if i == 0 {
		return this.sums[j]
	}

	return this.sums[j] - this.sums[i-1]
}

func main() {
	arr := Constructor([]int{7, 2, 7, 2, 0})
	fmt.Println(arr.sums)
	arr.Update(4, 6)
	fmt.Println(arr.sums)
	arr.Update(0, 2)
	fmt.Println(arr.sums)
	arr.Update(0, 9)
	fmt.Println(arr.sums)
}
