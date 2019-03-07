package main

import "fmt"

func isValid(s string) bool {
	if len(s) == 0 {
		return true
	}

	if s[0] == '(' {
		// find the index of a closing bracket
		closingBracket := false
		index := -1
		for i := 1; i < len(s); i++ {
			if s[i] == ')' {
				closingBracket = true
				index = i
				break
			}
		}

		if !closingBracket {
			return false
		}

		return isValid(s[1:index]) && isValid(s[index+1:])
	} else if s[0] == '{' {
		// find the index of a closing bracket
		closingBracket := false
		index := -1
		for i := 1; i < len(s); i++ {
			if s[i] == '}' {
				closingBracket = true
				index = i
				break
			}
		}

		if !closingBracket {
			return false
		}

		return isValid(s[1:index]) && isValid(s[index+1:])
	} else if s[0] == '[' {
		// find the index of a closing bracket
		closingBracket := false
		index := -1
		for i := 1; i < len(s); i++ {
			if s[i] == ']' {
				closingBracket = true
				index = i
				break
			}
		}

		if !closingBracket {
			return false
		}

		return isValid(s[1:index]) && isValid(s[index+1:])
	}
	return false
}

func main() {
	fmt.Println(isValid("()"))
	fmt.Println(isValid(""))
	fmt.Println(isValid("("))
	fmt.Println(isValid("(["))
	fmt.Println(isValid("([]"))
	fmt.Println(isValid("([])"))
	fmt.Println(isValid("([]))"))
}
