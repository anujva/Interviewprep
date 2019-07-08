package main

import "fmt"

func wordBreakII(s string, wordDict []string) []string {
	dicMap := map[string]bool{}

	for _, word := range wordDict {
		dicMap[word] = true
	}

	return wordBreakIISub(s, dicMap)
}

func wordBreakIISub(s string, dicMap map[string]bool) []string {
	answers := make([]string, 0)
	if len(s) == 0 {
		return answers
	}
	for i := 1; i < len(s)+1; i++ {
		if dicMap[s[0:i]] {
			// this word is in the dictionary
			subWordString := wordBreakIISub(s[i:], dicMap)
			for _, subWord := range subWordString {
				answers = append(answers, s[0:i]+" "+subWord)
			}

			if i == len(s) {
				answers = append(answers, s)
			}
		}
	}

	return answers
}

func main() {
	fmt.Println(wordBreakII("catsanddog", []string{"cat", "dog", "cats", "sand", "and"}))
	fmt.Println(wordBreakII("pineapplepenapple", []string{"apple", "pen", "applepen", "pine", "pineapple"}))
}
