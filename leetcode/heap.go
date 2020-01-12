package main

import "fmt"

var defaultSize int = 10

type Heap struct {
	arr         []int
	length      int
	initialSize int
}

// New returns a new Heap
func New(arr []int) *Heap {
	// storing the passed reference in the new struct
	if arr == nil {
		arr = make([]int, defaultSize)
	}

	return &Heap{
		arr:    arr,
		length: len(arr),
	}
}

// Heapify does the operation that will keep the invariant property intact
func (h *Heap) Heapify() {
	// this will run the heapify algorithm on the internal
	// array
	if h.length > 0 {
		for i := 0; i < h.length; i++ {
			heapifySubroutine(h, i)
		}
	}
}

func heapifySubroutine(h *Heap, index int) {
	if index >= h.length {
		return
	}

	heapifySubroutine(h, 2*index+1)
	heapifySubroutine(h, 2*index+2)

	if 2*index+2 < h.length {
		m, minindex := min(h.arr[2*index+1], h.arr[2*index+2], 2*index+1, 2*index+2)
		//if min and minindex remain the same as the current
		m, minindex = min(h.arr[index], m, index, minindex)
		// swap
		temp := h.arr[index]
		h.arr[index] = m
		h.arr[minindex] = temp
	} else if 2*index+1 < h.length {
		m, minindex := min(h.arr[index], h.arr[2*index+1], index, 2*index+1)
		//swap
		temp := h.arr[index]
		h.arr[index] = m
		h.arr[minindex] = temp
	}
}

func min(x, y, xindex, yindex int) (int, int) {
	if x < y {
		return x, xindex
	}
	return y, yindex
}

func main() {
	h := New([]int{20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1})
	h.Heapify()
	fmt.Println(h.arr)
}
