package main

import "fmt"

var m = map[byte]byte{
	'{': '}',
	'[': ']',
	'(': ')',
}

var results map[string]string

func isValid(s string) bool {
	if len(s) == 0 {
		return true
	}

	if s[0] == '(' || s[0] == '{' || s[0] == '[' {
		for i := 1; i < len(s); i++ {
			if s[i] == m[s[0]] {
				if isValid(s[1:i]) && isValid(s[i+1:]) {
					return true
				}
			}
		}
	}
	return false
}

func isValidMemoized(s string, results map[string]string) bool {
	if len(s) == 0 {
		return true
	}

	if s[0] == '(' || s[0] == '{' || s[0] == '[' {
		for i := 1; i < len(s); i++ {
			if s[i] == m[s[0]] {
				v1, ok := results[s[1:i]], !ok{}
				if isValid(s[1:i]) && isValid(s[i+1:]) {
					return true
				}
			}
		}
	}
	return false
}

func main() {
	fmt.Println(isValid("{}"))
	fmt.Println(isValid("}"))
	fmt.Println(isValid("{"))
	fmt.Println(isValid("(([]){})"))
}
