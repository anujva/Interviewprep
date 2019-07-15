package main

import "fmt"

func findLength(A []int, B []int) int {
	max := 0
	dp := make([][]int, len(A))
	for i := 0; i < len(A); i++ {
		dp[i] = make([]int, len(B))
	}

	for i := 0; i < len(A); i++ {
		for j := 0; j < len(B); j++ {
			if i-1 < 0 || j-1 < 0 {
				if A[i] == B[j] {
					dp[i][j] = 1
				} else {
					dp[i][j] = 0
				}
			} else {
				if A[i] == B[j] {
					dp[i][j] = dp[i-1][j-1] + 1
				} else {
					dp[i][j] = 0
				}
			}
			if max < dp[i][j] {
				max = dp[i][j]
			}
		}
	}
	return max
}

func main() {
	fmt.Println(findLength([]int{0, 1, 1, 1, 1}, []int{1, 0, 1, 0, 1}))
}
