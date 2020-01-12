package main

func gardenNoAdj(N int, paths [][]int) []int {
	// paths are the connections to and from the nodes
	// Put it in a map for easy lookup of connected
	// gardens. The connection is bidirectional as well.
	answer := make([]int, N) // total number of gardens
	m := getPathsAsMap(paths)
}

func getPathsAsMap(paths [][]int) map[int][]int {

}
