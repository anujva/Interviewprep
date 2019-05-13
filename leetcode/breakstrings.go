package main

import "fmt"

func breakString(s string, k int) []string {
	if len(s) == 0 {
		return []string{}
	}

	// find the next word, which would either be ending in space or
	// just ending the entire string.
	index := make([]int, 0)
	for i := 0; i < k && i < len(s); i++ {
		if s[i] == " " {
			index = append(index, i)
		}
	}

}

func main() {
	fmt.Println(breakString("The quick brown fox jumped over the lazy dog", 10))
}
