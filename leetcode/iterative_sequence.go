package main

import "fmt"

var m map[int]int

func findMaxIterativeSeq() (int, int) {
	num := 10000000
	max := iterativeSequence(num)
	for i := num; i > 1; i-- {
		if max < iterativeSequence(i) {
			max = iterativeSequence(i)
			num = i
		}
	}
	return max, num
}

func iterativeSequence(n int) int {
	if m == nil {
		m = make(map[int]int)
	}

	if v, ok := m[n]; ok {
		return v
	}

	if n == 1 {
		return 1
	}

	// even
	if n%2 == 0 {
		m[n] = 1 + iterativeSequence(n/2)
		return m[n]
	}

	m[n] = 1 + iterativeSequence(3*n+1)
	return m[n]
}

func main() {
	fmt.Println(findMaxIterativeSeq())
}
