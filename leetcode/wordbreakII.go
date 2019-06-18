package main

import "fmt"

var mapOfWords map[string]bool

func wordBreak(s string, wordDict []string) []string {
	if len(s) == 0 {
		return []string{}
	}

	if mapOfWords == nil {
		mapOfWords = make(map[string]bool)
		for _, word := range wordDict {
			mapOfWords[word] = true
		}
	}
	return wordBreakSubroutine(s, mapOfWords)
}

func wordBreakSubroutine(s string, mapOfWords map[string]bool) []string {
	answer := []string{}
	if mapOfWords[s] {
		answer = append(answer, s)
	}
	for i := 1; i <= len(s); i++ {
		sub := s[0:i]
		if mapOfWords[sub] {
			sentences := wordBreakSubroutine(s[i:], mapOfWords)
			// sentences should be non empty otherwise it will just return
			// and not add anything to the array
			for _, sentence := range sentences {
				answer = append(answer, sub+" "+sentence)
			}
		}
	}
	return answer
}

func main() {
	//answers := wordBreak("pineapplepenapple", []string{"apple", "pen", "applepen", "pine", "pineapple"})
	answers := wordBreak("catsanddogs", []string{"cats", "cat", "and", "sand", "dogs"})
	fmt.Println(len(answers))
	for _, answer := range answers {
		fmt.Println(answer)
	}
}
