package main

import "fmt"

//In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL", a move consists of either replacing one occurrence of "XL" with "LX", or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end, return True if and only if there exists a sequence of moves to transform one string to the other.

//Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
//Output: True
//Explanation:
//We can transform start to end following these steps:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX

func canTransform(start string, end string) bool {
	// get the first two characters in start and end.
	if len(start) != len(end) {
		return false
	}

	if start == end {
		return true
	}

	index := -1
	for i := 0; i < len(start); i++ {
		if start[i] != end[i] {
			index = i
			break
		}
	}

	// index would either be -1 (which would mean the strings are equal all the way)
	if index == -1 {
		return true
	}

	// otherwise.. the strings are the same till the index
	start2word := start[index:]
	// this would mean that there is no more string left to even try for the switches
	if len(start2word) < 2 {
		return false
	}

	if start[index:index+2] == "RX" {
		start = start[0:index] + "XR" + start[index+2:]
		return canTransform(start, end)
	}

	if start[index:index+2] == "XL" {
		start = start[0:index] + "LX" + start[index+2:]
		return canTransform(start, end)
	}

	//This would mean that we just try to find a possibility in the start string
	// to see if there is an occourence of either RX or XL

	for i := 0; i < len(start)-1; i++ {
		if start[i:i+2] == "RX" {
			start = start[0:i] + "XR" + start[i+2:]
			return canTransform(start, end)
		} else if start[i:i+2] == "XL" {
			start = start[0:i] + "LX" + start[i+2:]
			return canTransform(start, end)
		}
	}

	return false
}

func main() {
	fmt.Println(canTransform("XXXXXLXXXX", "LXXXXXXXXX"))
	fmt.Println(canTransform("RXXLRXRXL", "XRLXXRRLX"))
}
