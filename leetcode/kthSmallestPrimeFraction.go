package main

type Fraction struct {
	numerator   int
	denominator int
}

// This function returns -1 if the fraction is less than other
// returns 0 if they are equal, 1 if its greater than other.
func (f *Fraction) compareTo(other *Fraction) int {
	val := f.numerator*other.denominator - other.numerator*f.denominator
	if val > 0 {
		return 1
	} else if val < 0 {
		return -1
	}
	return 0
}

// Sort a list of fractions in sorted order
func sort(l []*Fraction) {
	for i, val := range l {
		min := val
		index := 0
		for j := i; j < len(l); j++ {
			//find the minimum in this array;
			if min.compareTo(l[j]) == 1 {
				min = l[j]
				index = j
			}
		}
		temp := l[i]
		l[i] = min
		l[index] = temp
	}
	// at this point the array is sorted
}
