package main

import "fmt"

func areSentencesSimilar(words1 []string, words2 []string, pairs [][]string) bool {
	if len(words1) != len(words2) {
		return false
	}

	m := convertPairsToMap(pairs)

	for i, word1 := range words1 {
		word2 := words2[i]
		// check if word1 is similar to word2
		if !checkSimilar(word1, word2, m) {
			return false
		}
	}

	return true
}

func convertPairsToMap(pairs [][]string) map[string][]string {
	m := make(map[string][]string)
	for _, pair := range pairs {
		if v, ok := m[pair[0]]; !ok {
			m[pair[0]] = []string{pair[1]}
		} else {
			for _, val := range v {
				if val == pair[1] {
					continue
				}
			}
			m[pair[0]] = append(v, pair[1])
		}
		if v, ok := m[pair[1]]; !ok {
			m[pair[1]] = []string{pair[0]}
		} else {
			for _, val := range v {
				if val == pair[0] {
					continue
				}
			}
			m[pair[1]] = append(v, pair[0])
		}
	}
	return m
}

func checkSimilar(word1, word2 string, m map[string][]string) bool {
	if word1 == word2 {
		return true
	}

	if v, ok := m[word1]; !ok {
		return false
	} else {
		for _, val := range v {
			if val == word2 {
				return true
			}
		}
		return false
	}
}

func main() {
	fmt.Println(areSentencesSimilar([]string{"great"}, []string{"great"}, [][]string{}))
}
