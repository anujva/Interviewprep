package main

import "fmt"

type RLEIterator struct {
	arr       []int
	currIndex int // always even
}

func Constructor(A []int) RLEIterator {
	return RLEIterator{
		arr:       A,
		currIndex: 0,
	}
}

func (this *RLEIterator) Next(n int) int {
	if this.currIndex >= len(this.arr) {
		return -1
	}

	numElems := this.arr[this.currIndex]
	if numElems < n {
		this.currIndex = this.currIndex + 2
		return this.Next(n - numElems)
	}
	this.arr[this.currIndex] = numElems - n
	return this.arr[this.currIndex+1]
}

func main() {
	rle := Constructor([]int{3, 8, 0, 9, 2, 5})
	fmt.Println(rle.Next(2))
	fmt.Println(rle.Next(1))
	fmt.Println(rle.Next(1))
	fmt.Println(rle.Next(2))
}
