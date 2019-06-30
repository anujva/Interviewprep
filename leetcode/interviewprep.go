package main

import "fmt"

func numTilePossibilities(tiles string) int {
	results := make(map[string]bool)
	allCombs := allPossibleCombinations(tiles)
	fmt.Println(allCombs)
	for i := 0; i < len(allCombs); i++ {
		if !results[allCombs[i]] {
			results[allCombs[i]] = true
		}
	}

	return len(results)
}

func allPossibleCombinations(s string) []string {
	// we need to have all possible combinations
	// of all lengths
	if len(s) == 1 {
		return []string{s}
	}
	answerAll := []string{s[0:1]}
	answer := allPossibleCombinations(s[1:])
	for i := 0; i < len(answer); i++ {
		answerAll = append(answerAll, s[0:1] + answer[i])
		for j := 1; j < len(answer[i])+1; j++ {
			answerAll = append(answerAll, answer[i][0:j] + s[0:1] + answer[i][j:])
		}
	}
	answerAll = append(answerAll, answer...)
	return answerAll
}

func main() {
	fmt.Println(numTilePossibilities("AAB"))
}
