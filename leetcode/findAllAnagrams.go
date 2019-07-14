package main

import (
	"fmt"
	"sort"
)

func findAnagrams(s string, p string) []int {
	if len(s) < len(p) {
		return []int{}
	}

	pp := NewSortableString(p)
	sort.Sort(pp) // this is the anagram
	answer := []int{}
	for i := 0; i < len(s)-len(p)+1; i++ {
		sub := s[i : i+len(p)]
		if isAnagram(sub, string(pp.s)) {
			answer = append(answer, i)
		}
	}
	return answer
}

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

func isAnagram(s string, t string) bool {
	ss := NewSortableString(s)
	sort.Sort(ss)
	tt := NewSortableString(t)
	if string(ss.s) != string(tt.s) {
		return false
	}
	return true
}

func main() {
	fmt.Println(findAnagrams("cbaebabacd", "abc"))
	fmt.Println(findAnagrams("abab", "ab"))
}
