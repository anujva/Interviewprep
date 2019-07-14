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

func isAnagram(s string, t string) bool {
	ss := NewSortableString(s)
	sort.Sort(ss)
	tt := NewSortableString(t)
	sort.Sort(tt)
	fmt.Println(ss)
	fmt.Println(tt)
	return true
}

func main() {
	isAnagram("anagram", "nagaram")
}
