package main

import "strconv"
import "fmt"

func numWays(s string) int {
	if len(s) == 0 {
		return 1
	}

	if len(s) == 1 {
		return 1
	}

	numways := 0

	val, _ := strconv.Atoi(s[0:2])

	if val != 0 && val == 10 {
		numways = numways + 1
	}

	if val != 10 && val < 27 {
		numways = numways + 1
	}

	return numways
}

func main() {
	fmt.Println(numWays("01"))
	fmt.Println(numWays("1"))
	fmt.Println(numWays("10"))
	fmt.Println(numWays("12"))
	fmt.Println(numWays("1234")) // numWays(12) + numWays(34)
	fmt.Println(numWays("123"))
}
