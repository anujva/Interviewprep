package main

import "fmt"

type AutoNode struct {
	val         string
	isRepeating bool
	Next        *AutoNode
}

func (a *AutoNode) printAutoNodes() {
	temp := a
	for temp != nil {
		if temp.isRepeating {
			fmt.Print(temp.val + "*, ")
		} else {
			fmt.Print(temp.val + ", ")
		}
		temp = temp.Next
	}
	fmt.Println()
}

// The idea is that the pattern will be converted to automaton
func isMatch(s, p string) bool {
	start := convertToAutomaton(p)
	return isMatchAutomaton(s, start)
}

func isMatchAutomaton(s string, start *AutoNode) bool {
	if len(s) == 0 && start == nil {
		return true
	}

	if len(s) == 0 && start != nil && start.isRepeating && start.Next == nil {
		return true
	}

	if len(s) == 0 && start != nil && start.isRepeating && start.Next != nil {
		return isMatchAutomaton(s, start.Next)
	}

	if len(s) == 0 && start != nil && !start.isRepeating {
		return false
	}

	if len(s) != 0 && start == nil {
		return false
	}

	if start.val == "." && start.isRepeating && start.Next == nil {
		return true
	}

	if start.val == s[0:1] || start.val == "." {
		if isMatchAutomaton(s[1:], start.Next) {
			return true
		}

		if start.isRepeating {
			if isMatchAutomaton(s[1:], start) {
				return true
			}

			if isMatchAutomaton(s, start.Next) {
				return true
			}
		}
	} else if start.isRepeating {
		if isMatchAutomaton(s, start.Next) {
			return true
		}

		if isMatchAutomaton(s[1:], start) {
			return true
		}
	}

	return false
}

func convertToAutomaton(p string) *AutoNode {
	if len(p) == 0 {
		return nil
	}

	repeating := testIfRepeating(p)
	var node *AutoNode
	if repeating {
		node = &AutoNode{
			val:         p[0:1],
			isRepeating: true,
			Next:        convertToAutomaton(p[2:]),
		}
	} else {
		node = &AutoNode{
			val:         p[0:1],
			isRepeating: false,
			Next:        convertToAutomaton(p[1:]),
		}
	}

	return node
}

func testIfRepeating(p string) bool {
	if len(p) < 2 {
		return false
	}

	if p[1:2] == "*" {
		return true
	}
	return false
}

func main() {
	//fmt.Println(isMatch("apesht", "ape*sh*t"))
	//fmt.Println(isMatch("apeeeeesht", "ape*sh*t"))
	//fmt.Println(isMatch("apeshit", "ape*sh*t"))
	//fmt.Println(isMatch("apeshit", ".*"))
	//fmt.Println(isMatch("apeshit", ".pesh.t"))
	//fmt.Println(isMatch("apeshit", "......."))
	//fmt.Println(isMatch("aab", "c*a*b"))
	//fmt.Println(isMatch("", "a*"))
	//fmt.Println(isMatch("ab", ".*"))
	//fmt.Println(isMatch("mississippi", "mis*is*p*."))
	fmt.Println(isMatch("", "c*c*"))
}
