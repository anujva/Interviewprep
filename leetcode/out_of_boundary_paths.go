package main

import "fmt"

func findPaths(m, n, N, i, j int) int {
	if N == 0 {
		return 0
	}

	count := 0
	if i-1 < 0 {
		count = count + 1
	}

	if j-1 < 0 {
		count = count + 1
	}

	if i+1 >= m {
		count = count + 1
	}

	if j+1 >= n {
		count = count + 1
	}

	if i-1 > -1 {
		count = count + findPaths(m, n, N-1, i-1, j)
	}

	if j-1 > -1 {
		count = count + findPaths(m, n, N-1, i, j-1)
	}

	if i+1 < m {
		count = count + findPaths(m, n, N-1, i+1, j)
	}

	if j+1 < n {
		count = count + findPaths(m, n, N-1, i, j+1)
	}

	return count
}

func main() {
	fmt.Println(findPaths(2, 2, 2, 0, 0))
	fmt.Println(findPaths(1, 3, 3, 0, 1))
}
