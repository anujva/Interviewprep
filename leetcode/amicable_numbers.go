package main

import "fmt"

func amicableNumber(n int) {
	m := make(map[int]bool)
	answer := make(map[int]int)
	for i := 1; i <= n; i++ {
		if !m[i] {
			dnum := d(i)
			if i == d(dnum) {
				m[i] = true
				m[dnum] = true
				if i != dnum {
					answer[i] = dnum
				}
			}
		}
	}

	for k, v := range answer {
		fmt.Printf("%d %d\n", k, v)
	}
}

func d(n int) int {
	sum := 0
	for i := 1; i <= n/2; i++ {
		if n%i == 0 {
			sum = sum + i
		}
	}

	return sum
}

func main() {
	amicableNumber(10000)
}
