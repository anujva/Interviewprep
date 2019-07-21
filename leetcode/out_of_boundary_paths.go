package main

import "fmt"

var m_ = map[string]int{}

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
		if v, ok := m_[fmt.Sprintf("%d%d%d", N-1, i-1, j)]; ok {
			count = count + v
		} else {
			m_[fmt.Sprintf("%d%d%d", N-1, i-1, j)] = findPaths(m, n, N-1, i-1, j)
			count = count + m_[fmt.Sprintf("%d%d%d", N-1, i-1, j)]
		}
	}

	if j-1 > -1 {
		if v, ok := m_[fmt.Sprintf("%d%d%d", N-1, i, j-1)]; ok {
			count = count + v
		} else {
			m_[fmt.Sprintf("%d%d%d", N-1, i, j-1)] = findPaths(m, n, N-1, i, j-1)
			count = count + m_[fmt.Sprintf("%d%d%d", N-1, i, j-1)]
		}
	}

	if i+1 < m {
		if v, ok := m_[fmt.Sprintf("%d%d%d", N-1, i+1, j)]; ok {
			count = count + v
		} else {
			m_[fmt.Sprintf("%d%d%d", N-1, i+1, j)] = findPaths(m, n, N-1, i+1, j)
			count = count + m_[fmt.Sprintf("%d%d%d", N-1, i+1, j)]
		}
	}

	if j+1 < n {
		if v, ok := m_[fmt.Sprintf("%d%d%d", N-1, i, j+1)]; ok {
			count = count + v
		} else {
			m_[fmt.Sprintf("%d%d%d", N-1, i, j+1)] = findPaths(m, n, N-1, i, j+1)
			count = count + m_[fmt.Sprintf("%d%d%d", N-1, i, j+1)]
		}
	}

	return count
}

func main() {
	fmt.Println(findPaths(2, 2, 2, 0, 0))
	fmt.Println(findPaths(1, 3, 3, 0, 1))
}
