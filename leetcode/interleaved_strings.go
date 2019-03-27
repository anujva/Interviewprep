package main

func isInterleave(s1 string, s2 string, s3 string) bool {
	if len(s3) == 0 && len(s1) == 0 && len(s2) == 0 {
		return true
	}

	if len(s3) == 0 && (len(s1) != 0 || len(s2) != 0) {
		return false
	}

	var interleave1 bool
	if len(s1) > 0 {
		if s3[0] == s1[0] {
			if len(s1) > 1 {
				interleave1 = isInterleave(s1[1:], s2, s3[1:])
			} else {
				interleave1 = isInterleave("", s2, s3[1:])
			}
		}
	}

	var interleave2 bool
	if len(s2) > 0 {
		if s3[0] == s2[0] {
			if len(s1) > 1 {
				interleave2 = isInterleave(s1, s2[1:], s3[1:])
			} else {
				interleave2 = isInterleave(s1, "", s3[1:])
			}
		}
	}

	return interleave1 || interleave2
}

func main() {

}
