package main

import "fmt"

func removeInvalidParentheses(s string) []string {
	fmt.Println(s)
	answer := make(map[string]bool, 0)
	if isValid(s) {
		answer[s] = true
		return getKeysAsList(answer)
	}

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
		answers := make([]string, 0)
		for i := 0; i < len(s); i++ {
			if !(s[i] == '(' || s[i] == ')') {
				continue
			}
			str := s[0:i] + s[i+1:]
			answers = append(answers, removeInvalidParentheses(str))
		}
		max := 0
		longestAnswers := make([]string, 0)
		for i := 0; i < len(answers); i++ {
			if len(answers[i]) > max {
				max = len(answers[i])
				longestAnswers = make([]string, 0)
			} else if len(answers[i]) == max {
				longestAnswers = append(longestAnswers, answers[i])
			}
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

type stack struct {
	values []int
}

func (s *stack) push(v int) {
	s.values = append(s.values, v)
}

func (s *stack) pop() *int {
	if len(s.values) == 0 {
		return nil
	}
	v := s.values[len(s.values)-1]
	s.values = s.values[:len(s.values)-1]
	return intPtr(v)
}

func intPtr(v int) *int {
	return &v
}

func (s *stack) isEmpty() bool {
	return len(s.values) == 0
}

// The correct way of finding if the string has valid braces
// is to neglect the values with it and just look at the opening
// and closing braces
func isValid(s string) bool {
	stk := stack{}
	for i := 0; i < len(s); i++ {
		if s[i] == '(' {
			stk.push(1)
		} else if s[i] == ')' {
			v := stk.pop()
			if v == nil {
				return false
			}
		}
	}
	return stk.isEmpty()
}

func main() {
	//fmt.Println(removeInvalidParentheses("(a)())()"))
	//fmt.Println(removeInvalidParentheses("()())()"))
	fmt.Println(removeInvalidParentheses("(j))("))
	//fmt.Println(removeInvalidParentheses(""))
}
