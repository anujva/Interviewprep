package main

import "fmt"

var m map[string]bool

func updateMatrix(matrix [][]int) [][]int {
	// if the current value of the cell is 0, return 0
	// if current value is not 0, then search for the
	// closest 0 value using BFS and return when you hit
	final := make([][]int, len(matrix))
	m = make(map[string]bool)
	for i := 0; i < len(matrix); i++ {
		final[i] = make([]int, len(matrix[0]))
	}

	for i := 0; i < len(matrix); i++ {
		for j := 0; j < len(matrix[0]); j++ {
			if matrix[i][j] == 0 {
				final[i][j] = 0
			} else {
				//start bfs and update
				final[i][j] = bfs(matrix, i, j)
			}
		}
	}
	return final
}

const (
	MaxInt8   = 1<<7 - 1
	MinInt8   = -1 << 7
	MaxInt16  = 1<<15 - 1
	MinInt16  = -1 << 15
	MaxInt32  = 1<<31 - 1
	MinInt32  = -1 << 31
	MaxInt64  = 1<<63 - 1
	MinInt64  = -1 << 63
	MaxUint8  = 1<<8 - 1
	MaxUint16 = 1<<16 - 1
	MaxUint32 = 1<<32 - 1
	MaxUint64 = 1<<64 - 1
)

func bfs(matrix [][]int, i, j int) int {
	if matrix[i][j] == 0 {
		return 0
	}
	var v1, v2, v3, v4 int
	v1 = MaxInt64 - 1000000000
	v2 = MaxInt64 - 1000000000
	v3 = MaxInt64 - 1000000000
	v4 = MaxInt64 - 1000000000

	if i+1 < len(matrix) && !m[string(i+1)+string(j)] {
		m[string(i+1)+string(j)] = true
		v1 = bfs(matrix, i+1, j)
		m[string(i+1)+string(j)] = false
	}

	if i-1 > -1 && !m[string(i-1)+string(j)] {
		m[string(i-1)+string(j)] = true
		v2 = bfs(matrix, i-1, j)
		m[string(i-1)+string(j)] = false
	}

	if j-1 > -1 && !m[string(i)+string(j-1)] {
		m[string(i)+string(j-1)] = true
		v3 = bfs(matrix, i, j-1)
		m[string(i)+string(j-1)] = false
	}

	if j+1 < len(matrix[0]) && !m[string(i)+string(j+1)] {
		m[string(i)+string(j+1)] = true
		v4 = bfs(matrix, i, j+1)
		m[string(i)+string(j+1)] = false
	}

	minVal := findMin(v1, findMin(v2, findMin(v3, v4)))

	return minVal + 1
}

func findMin(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func main() {
	fmt.Println(updateMatrix([][]int{
		{0, 0, 0},
		{0, 1, 0},
		{1, 1, 1},
	}))
}
