package main

import "fmt"

func removeInvalidParentheses(s string) []string {
	answer := make(map[string]bool, 0)
	for i := 0; i < len(s); i++ {
		//remove the string at the index, and then check if the string
		// is still valid. If it is valid, then check how many values
		// needed to be removed to make the value correct
		if !(s[i] == '(' || s[i] == ')') {
			continue
		}
		str := s[0:i] + s[i+1:]
		if !answer[str] && isValid(str) {
			answer[str] = true
		}
	}

	// if there are no valid strings formed in this iteration
	if len(answer) == 0 {
		for i := 0; i < len(s); i++ {
			str := s[0:i] + s[i+1:]
			return removeInvalidParenthesis(str)
		}
	}
	return getKeysAsList(answer)
}

func getKeysAsList(m map[string]bool) []string {
	l := make([]string, 0)
	for k, _ := range m {
		l = append(l, k)
	}
	return l
}

func isValid(s string) bool {
	if len(s) == 0 {
		return true
	}

	if len(s) == 1 {
		return false
	}

	if s[0] != '(' {
		return false
	}

	for i := 1; i < len(s); i++ {
		if s[i] == ')' {
			if isValid(stringBetween(s, 0, i)) && isValid(stringBetween(s, i, len(s))) {
				return true
			}
		}
	}
	return false
}

func stringBetween(s string, beginIndex int, endIndex int) string {
	if endIndex-beginIndex < 2 {
		return ""
	}

	if beginIndex >= len(s) {
		return ""
	}

	if endIndex > len(s) {
		endIndex = len(s)
	}

	return s[beginIndex+1 : endIndex]
}

func main() {
	fmt.Println(removeInvalidParenthesis("(a)())()"))
	//fmt.Println(removeInvalidParenthesis("(()"))
}
