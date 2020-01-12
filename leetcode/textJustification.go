package main

import "fmt"

// text needs to be fully left and right justified.
// You should pack your words in a greedy approach.
// Pack as many words as possible in each line. The
// last line can be unjustified.

func fullJustify(words []string, maxWidth int) []string {
	//every two word is going to be joined together with a space
	if len(words) == 0 {
		return []string{}
	}
	line := ""
	stuffing := true
	index := 0
	for stuffing && index < len(words) {
		if len(words[index])+len(line)+1 < maxWidth {
			if len(line) == 0 {
				line = line + words[index]
			} else {
				line = line + " " + words[index]
			}
			index = index + 1
		} else {
			stuffing = false
		}
	}
	answer := []string{line}
	return append(answer, fullJustify(words[index:], maxWidth)...)
}

func main() {
	fmt.Println(fullJustify([]string{"This", "is", "an", "example", "of", "text", "justification."}, 16))
}
