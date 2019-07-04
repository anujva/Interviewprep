package main

import "fmt"

// Need to memoize this solution otherwise no chance
func distinctSubseqII(S string) int {
	m := make(map[string]bool) // will keep a track of the distinct ones
	l := distinctSubseqSubroutine(S, m)

	for _, v := range l {
		if !m[v] {
			m[v] = true
		}
	}
	fmt.Println(m)
	return len(m)
}

var recursionDepth int = 0

func distinctSubseqSubroutine(S string, m map[string]bool) []string {
	if len(S) == 1 {
		m[S] = true
		return []string{S}
	}

	fromRecursion := distinctSubseqSubroutine(S[1:], m)
	fmt.Println("FromRecursion: ", fromRecursion)
	// current first letter S[0:1]
	answerInThisRecursion := []string{S[0:1]}
	// append the first letter in all the places in the string contained in fromRecursion
	answerInThisRecursion = append(answerInThisRecursion, (appendAllValues(S[0:1], fromRecursion))...)
	answerInThisRecursion = append(answerInThisRecursion, fromRecursion...)
	// add all the strings in the map
	aDedup := addToMap(answerInThisRecursion, m)
	return aDedup
}

func addToMap(answer []string, m map[string]bool) []string {
	for _, ans := range answer {
		if !m[ans] {
			m[ans] = true
		}
	}

	a := []string{}
	for k, _ := range m {
		a = append(a, k)
	}
	return a
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
	fmt.Println(distinctSubseqII("pcrdhwdxmqdznbenhwjsenjhvulyve"))
}
