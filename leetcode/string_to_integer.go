package main

import "fmt"

//Implement atoi which converts a string to an integer.
//
//The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
//
//The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
//
//If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
//
//If no valid conversion could be performed, a zero value is returned.
//
//Note:
//
//    Only the space character " " is considered as whitespace character.
//    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
//
//Example 1:
//
//Input: "42"
//Output: 42
//
//Example 2:
//
//Input: "   -42"
//Output: -42
//Explanation: The first non-whitespace character is "-", which is the minus sign.
//             Then take as many numerical digits as possible, which gets 42.
//
//Example 3:
//
//Input: "4193 with words"
//Output: 4193
//Explanation: Conversion stops at digit "3" as the next character is not a numerical digit.
//
//Example 4:
//
//Input: "words and 987"
//Output: 0
//Explanation: The first non-whitespace character is "w", which is not a numerical
//             digit or a +/- sign. Therefore no valid conversion could be performed.
//
//Example 5:
//
//Input: "-91283472332"
//Output: -2147483648
//Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
//             Thefore INT_MIN (−231) is returned.
//

func myAtoi(str string) int {
	s := removeWhitespaces(str)
	v := onlyNumbers(s)
	return int(int32(strconv.AtoI(v)))
}

func onlyNumbers(str string) string {
	index := -1
	start := 0
	if string(str[0]) == "-" {
		start = 1
	}
	for i := start; i < len(str); i++ {
		if !(string(str[i]) == "0" || string(str[i]) == "1" || string(str[i]) == "2" || string(str[i]) == "3" ||
			string(str[i]) == "4" || string(str[i]) == "5" || string(str[i]) == "6" || string(str[i]) == "7" ||
			string(str[i]) == "8" || string(str[i]) == "9") {
			index = i
			fmt.Println("Value: ", string(str[i]))
			break
		}
	}

	fmt.Println("The index: ", index)

	if index == -1 {
		return str
	}
	return str[0:index]
}

func removeWhitespaces(str string) string {
	index := -1
	for i := 0; i < len(str); i++ {
		if !(string(str[i]) == " " || string(str[i]) == "\t" || string(str[i]) == "\r" || string(str[i]) == "\n") {
			index = i
			break
		}
	}

	if index == -1 {
		return str
	}
	return str[index:]
}

func main() {
	fmt.Println(removeWhitespaces("     p23232432"))
	fmt.Println(onlyNumbers(removeWhitespaces("     23232432a;lksdjfladsjfasdfasdfasdfklajsdkfj      ")))
}
