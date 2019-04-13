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
	checkForZero, err := strconv.Atoi(message)
	if err != nil {
		panic("Only numbers expected")
	}
	if checkForZero == 0 {
		return 0
	}
	return numDecodingsSubroutine(message)
}

func numDecodingsSubroutine(message string) int {
	if len(message) == 0 {
		return 1
	}

	if len(message) == 1 {
		return 1
	}

	if len(message) > 1 {
		// take the first two values
		firstTwo := message[0:2]
		intValue, err := strconv.Atoi(firstTwo)
		if err != nil {
			panic("this should never not be numbers")
		}
		if intValue > 0 && intValue < 27 {
			return numDecodingsSubroutine(message[1:]) + numDecodingsSubroutine(message[2:])
		}
	}
	return numDecodingsSubroutine(message[1:])
}

func main() {
	fmt.Println(numDecodings("12"))
}
