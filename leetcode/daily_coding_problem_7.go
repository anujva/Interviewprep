package main

import (
	"fmt"
	"strconv"
)

/*
This problem was asked by Facebook.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */

func numDecodings(message string) int {
	if len(message) == 0 {
		return 0
	}

	if len(message) == 1 && message == "0" {
		return 0
	}

	if len(message) == 1 && message != "0" {
		return 1
	}

	// take the first digit
	firstDigit := message[0:1]
	wordFormed := 0
	if firstDigit != "0" {
		wordFormed = wordFormed + numDecodings(message[1:])
	}

	if len(message) == 2 {
		firstTwoDigits := message[0:2]
		intValue, err := strconv.Atoi(firstTwoDigits)
		if err != nil {
			panic("Not possible")
		}
		if intValue > 9 && intValue < 27 {
			wordFormed = wordFormed + 1
		}
	}

	if len(message) >= 2 {
		firstTwoDigits := message[0:2]
		intValue, err := strconv.Atoi(firstTwoDigits)
		if err != nil {
			panic("Not possible")
		}
		if intValue > 9 && intValue < 27 {
			wordFormed = wordFormed + numDecodings(message[2:])
		}
	}
	return wordFormed
}

func main() {
	fmt.Println(numDecodings("1111"))
}
