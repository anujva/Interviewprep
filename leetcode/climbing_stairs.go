package main

import "fmt"

// This will need to be memoized for sure, otherwise this is exponential time
var m map[int]int

func climbStairs(n int) int {
	if n == 0 || n == 1 {
		return 1
	}
	var n1, n2 int
	if val, ok := m[n-1]; !ok {
		n1 = climbStairs(n - 1)
		m[n-1] = n1
	} else {
		n1 = val
	}
	if val, ok := m[n-2]; !ok {
		n2 = climbStairs(n - 2)
		m[n-2] = n2
	} else {
		n2 = val
	}

	return n1 + n2
}

func main() {
	fmt.Println(climbStairs(3))
}
