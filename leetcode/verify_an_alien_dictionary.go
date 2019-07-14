package main

import "fmt"

//In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
//
//Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if the given words are sorted lexicographicaly in this alien language.
//
//
//
//Example 1:
//
//Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
//Output: true
//Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
//
//Example 2:
//
//Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
//Output: false
//Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
//
//Example 3:
//
//Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
//Output: false
//Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less than any other character (More info).
//

func isAlienSorted(words []string, order string) bool {
	if len(words) == 0 {
		return false
	}
	m := getMapFromOrder(order)
	for i := 1; i < len(words); i++ {
		if !checkWordSorting(words[i-1], words[i], m) {
			return false
		}
	}
	return true
}

func checkWordSorting(s1, s2 string, orderMap map[string]map[string]bool) bool {
	for i := 0; i < min(len(s1), len(s2)); i++ {
		if orderMap[string(s1[i])][string(s2[i])] {
			return true
		} else if s1[i] == s2[i] {
			continue
		} else {
			return false
		}
	}
	return false
}

func min(x, y int) int {
	if x < y {
		return x
	}
	return y
}

func getMapFromOrder(order string) map[string]map[string]bool {
	m := make(map[string]map[string]bool)
	for i := 0; i < len(order); i++ {
		for j := i + 1; j < len(order); j++ {
			if m[string(order[i])] == nil {
				m[string(order[i])] = make(map[string]bool)
			}
			m[string(order[i])][string(order[j])] = true
		}
	}
	return m
}

func main() {
	fmt.Println(isAlienSorted([]string{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"))
	fmt.Println(isAlienSorted([]string{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"))
	fmt.Println(isAlienSorted([]string{"word", "world", "row"}, "abcdefghijklmnopqrstuvwxyz"))
}
