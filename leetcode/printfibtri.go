package main

import "fmt"

func generateTriangle(n int) {
	block := make([][]int, n)
	for i := 0; i < n; i++ {
		block[i] = make([]int, n)
	}

	// start by finding the middle
	block[0][n-1] = 1

	for i := 1; i < n; i++ {
		for j := 0; j < n; j++ {
			if j+1 >= n {
				block[i][j] = block[i-1][j]
			} else {
				block[i][j] = block[i-1][j] + block[i-1][j+1]
			}
		}
	}

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			fmt.Print(block[i][j], " ")
		}
		fmt.Println()
	}
}

func main() {
	generateTriangle(10)
}
