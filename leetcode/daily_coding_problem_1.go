package main

import "fmt"

func sum(arr []int, k int) bool {
	m := make(map[int]bool)

	for i := 0; i < len(arr); i++ {
		//check before putting the value in to the map
		if m[k-arr[i]] {
			return true
		}
		m[arr[i]] = true
	}
	return false
}

func main() {
	arr := []int{10, 15, 3, 7}
	fmt.Println(sum(arr, 10))
}
