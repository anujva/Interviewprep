package main

import (
	"fmt"
	"sort"
)

type SortableString struct {
	s []byte
}

func NewSortableString(s string) *SortableString {
	return &SortableString{
		s: []byte(s),
	}
}

func (s *SortableString) Len() int {
	return len(s.s)
}

func (a *SortableString) Swap(i, j int) {
	a.s[i], a.s[j] = a.s[j], a.s[i]
}

func (a *SortableString) String() string {
	return string(a.s)
}

func (a *SortableString) Less(i, j int) bool {
	return a.s[i] < a.s[j]
}

func checkinclusion(s1, s2 string) bool {
	if len(s2) < len(s1) {
		return false
	}
	s11 := NewSortableString(s1)
	sort.Sort(s11)
	for i := 0; i < len(s2)-len(s1)+1; i++ {
		sub := s2[i : i+len(s1)]
		fmt.Println(sub)
		if isAnagram(sub, string(s11.s)) {
			return true
		}
	}
	return false
}

func isAnagram(s, t string) bool {
	ss := NewSortableString(s)
	sort.Sort(ss)
	tt := NewSortableString(t)
	if string(ss.s) != string(tt.s) {
		return false
	}
	return true
}

func main() {
	fmt.Println(checkinclusion("adc", "dcda"))
}
