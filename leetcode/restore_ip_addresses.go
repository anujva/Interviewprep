package main

import (
	"fmt"
	"strconv"
)

func restoreIPAddresses(s string) []string {
	return restoreIPAddressesSubroutine(s, 0)
}

func restoreIPAddressesSubroutine(s string, level int) []string {
	answer := make([]string, 0)
	if isValidIPRange(s) && level == 3 {
		answer = append(answer, s)
		return answer
	}

	if level >= 3 {
		return []string{}
	}

	for i := 1; i < len(s); i++ {
		if isValidIPRange(s[0:i]) {
			answerFromLower := restoreIPAddressesSubroutine(s[i:], level+1)
			for j := 0; j < len(answerFromLower); j++ {
				answer = append(answer, s[0:i]+"."+answerFromLower[j])
			}
		}
	}
	return answer
}

func isValidIPRange(s string) bool {
	address, err := strconv.Atoi(s)
	if err != nil {
		return false
	}
	if address < 255 && len(s) >= 4 {
		return false
	}
	if address < 100 && len(s) >= 3 {
		return false
	}
	if address < 10 && len(s) >= 2 {
		return false
	}
	if address < 0 || address > 255 {
		return false
	}
	return true
}

func main() {
	fmt.Println(restoreIPAddresses("010010"))
}
