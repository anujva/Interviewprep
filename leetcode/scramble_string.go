package main

func isScramble(s1, s2 string) bool {
	if len(s1) != len(s2) {
		return false
	}

	if len(s1) == 0 || s1 == s2 {
		return true
	}

	//the scrambling point can start anywhere
	for i := 1; i < len(s1); i++ {
		//What is the point of doing this?
	}
}
