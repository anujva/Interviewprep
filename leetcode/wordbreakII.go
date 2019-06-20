package main

import "fmt"

func wordBreak(s string, wordDict []string) []string {
	if len(s) == 0 {
		return []string{}
	}

	mapOfWords := make(map[string]bool)
	for _, word := range wordDict {
		mapOfWords[word] = true
	}
	memoize := make(map[string][]string)
	return wordBreakSubroutine(s, mapOfWords, memoize)
}

func wordBreakSubroutine(s string, mapOfWords map[string]bool, memoize map[string][]string) []string {
	if sens, ok := memoize[s]; ok {
		return sens
	}
	answer := []string{}
	if mapOfWords[s] {
		answer = append(answer, s)
	}
	for i := 1; i <= len(s); i++ {
		sub := s[0:i]
		if mapOfWords[sub] {
			sentences := wordBreakSubroutine(s[i:], mapOfWords, memoize)
			// sentences should be non empty otherwise it will just return
			// and not add anything to the array
			for _, sentence := range sentences {
				answer = append(answer, sub+" "+sentence)
			}
		}
	}
	memoize[s] = answer
	return answer
}

func main() {
	answers := wordBreak("pineapplepenapple", []string{"apple", "pen", "applepen", "pine", "pineapple"})
	//answers := wordBreak("catsanddogs", []string{"cats", "cat", "and", "sand", "dogs"})
	fmt.Println(len(answers))
	for _, answer := range answers {
		fmt.Println(answer)
	}
}
