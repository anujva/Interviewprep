package main

func longestValidParentheses(s string) int {
	pMap := make(map[string]bool)
	for _, c := range s {

	}
	return longestValidParenthesesSubroutine(s, pMap)
}

func longestValidParenthesesSubroutine(s string, pMap map[string]bool) int {
	if len(s) == 0 {
		return 0
	}

	if b, ok := pMap[s[1:len(s)-1]]; ok {
		// found the value in the map
		// if the value is true then there is a palindrome
		// do what you need to.
	} else {
		// check if the substring inside is a palindrome
	}
}

func main() {
	//Have to deal with ranges. The values are all ranges that will be used to see if the
	// current string forms a palindrome or not or we can just memoize the calls
}
