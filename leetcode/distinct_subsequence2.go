package main

import "fmt"

// Need to memoize this solution otherwise no chance
func distinctSubseqII(S string) int {
	m := make(map[string]bool) // will keep a track of the distinct ones
	m2 := make(map[string][]string)
	l := distinctSubseqSubroutine(S, m2)

	for _, v := range l {
		if !m[v] {
			m[v] = true
		}
	}
	fmt.Println(m)
	return len(m)
}

func distinctSubseqSubroutine(S string, m map[string][]string) []string {
	if len(S) == 1 {
		m[S] = true
		return []string{S}
	}

	var fromRecursion []string
	if v, ok := m[S]; ok {
		fromRecursion = m[S]
	} else {
		fromRecursion := distinctSubseqSubroutine(S[1:])
		addToMap(fromRecursion, m, S)
	}
	// current first letter S[0:1]
	answerInThisRecursion := []string{S[0:1]}
	// append the first letter in all the places in the string contained in fromRecursion
	answerInThisRecursion = append(answerInThisRecursion, (appendAllValues(S[0:1], fromRecursion))...)
	answerInThisRecursion = append(answerInThisRecursion, fromRecursion...)
	// add all the strings in the map
	return answerInThisRecursion
}

func addToMap(answer []string, m map[string][]string, first string) {
	for _, s := range answer {
		m[s] = true
	}
}

func appendAllValues(s string, fromRecursion []string) []string {
	answer := []string{}
	for _, recString := range fromRecursion {
		answer = append(answer, s+recString)
	}
	return answer
}

func main() {
	//quickly test appendAllValues
	fmt.Println(distinctSubseqII("abc"))
	fmt.Println(distinctSubseqII("aba"))
	fmt.Println(distinctSubseqII("aaa"))
}
