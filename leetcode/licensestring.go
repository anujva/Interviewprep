package main

import (
	"fmt"
	"strings"
)

func licenseKeyFormatting(S string, K int) string {
	// start backwards.. start adding dashes at the kth index..
	// if dashes are seen before, just remove them
	sUpper := strings.ToUpper(S)
	formattedString := ""
	currentString := ""

	for i := len(sUpper) - 1; i > -1; i-- {
		// get 4 non dash worthy characters
		if sUpper[i] != '-' {
			currentString = string(sUpper[i]) + currentString
		}

		if len(currentString) == K {
			if len(formattedString) == 0 {
				formattedString = currentString
			} else {
				formattedString = currentString + "-" + formattedString
			}
			currentString = ""
		}
	}

	if len(currentString) != 0 && len(formattedString) == 0 {
		formattedString = currentString
	} else if len(currentString) != 0 {
		formattedString = currentString + "-" + formattedString
	}

	return formattedString
}

func main() {
	fmt.Println(licenseKeyFormatting("2", 4))

}
