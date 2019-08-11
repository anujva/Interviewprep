package main

import "fmt"

func customSortString(S string, T string) string {
	// need to be able to quicky say where to put the character

	charsInT, charsNotInT, count := subStringInT(T, S)

	if count == 0 {
		return T
	}
	answer := make([]byte, count)

	index := 0
	for i := 0; i < len(S); i++ {
		if v, ok := charsInT[S[i]]; ok {
			for j := 0; j < v; j++ {
				answer[index] = S[i]
				index++
			}
		}
	}

	if index != count {
		fmt.Println("Not possible")
	}

	return string(answer) + string(charsNotInT)
}

func subStringInT(T, S string) (map[byte]int, []byte, int) {
	m := make(map[byte]bool)

	for i := 0; i < len(S); i++ {
		if !m[S[i]] {
			m[S[i]] = true
		}
	}

	m2 := make(map[byte]int)
	charsNotInT := []byte{}
	count := 0
	for i := 0; i < len(T); i++ {
		if m[T[i]] {
			if v, ok := m2[T[i]]; !ok {
				m2[T[i]] = 1
			} else {
				m2[T[i]] = v + 1
			}
			count++
		} else {
			charsNotInT = append(charsNotInT, T[i])
		}
	}
	return m2, charsNotInT, count
}

func main() {
	fmt.Println(customSortString("cba", "abcd"))
}
