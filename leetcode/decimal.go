package main

import (
	"fmt"
	"strconv"
)

func fractionToDecimal(numerator int, denominator int) string {
	if denominator == 0 {
		return ""
	}

	if denominator == 1 {
		return strconv.Itoa(numerator)
	}

	positive := true
	if numerator < 0 {
		positive = false
		numerator = -1 * numerator
	}

	if denominator < 0 {
		if positive {
			positive = false
		} else {
			positive = true
		}
		denominator = -1 * denominator
	}

	quotient := numerator / denominator
	remainder := numerator % denominator

	if remainder == 0 {
		// we are done
		return strconv.Itoa(quotient)
	} else if remainder*10 == numerator {
		// got a repeating remainder
		return strconv.Itoa(quotient) + ".(" + strconv.Itoa(quotient) + ")"
	}

	if positive {
		return strconv.Itoa(quotient) + "." + handleRemainder(remainder*10, denominator, "", map[int]string{})
	}
	return "-" + strconv.Itoa(quotient) + "." + handleRemainder(remainder*10, denominator, "", map[int]string{})
}

func handleRemainder(numerator, denominator int, numSoFar string, remaindersSoFar map[int]string) string {
	quotient := numerator / denominator
	remainder := numerator % denominator

	if remainder == 0 {
		return numSoFar + strconv.Itoa(quotient)
	}

	if remainder*10 == numerator {
		return numSoFar + "(" + strconv.Itoa(quotient) + ")"
	}

	if v, ok := remaindersSoFar[remainder]; ok {
		fmt.Println("Remainder: ", remainder, " V: ", v)

		return getStringRepeated(v, numSoFar+strconv.Itoa(quotient))
	}

	remaindersSoFar[remainder] = numSoFar + strconv.Itoa(quotient)
	return handleRemainder(remainder*10, denominator, numSoFar+strconv.Itoa(quotient), remaindersSoFar)
}

func getStringRepeated(str1, str2 string) string {
	// minimum this should be 1
	length := len(str2) - len(str1)
	fmt.Println(str1, str2)
	startIndex := len(str2) - length - 1
	endIndex := len(str2) - 1
	return str2[0:startIndex] + "(" + str2[startIndex:endIndex] + ")"
}

func main() {
	//fmt.Println(fractionToDecimal(1, 2))
	//fmt.Println(fractionToDecimal(1, 333))
	//fmt.Println(fractionToDecimal(4, 333))
	//fmt.Println(fractionToDecimal(37, 300))
	fmt.Println(fractionToDecimal(89, 270))
}
