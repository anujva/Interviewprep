package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func nextLargerNodes(head *ListNode) []int {
	answer := make([]int, 0)
	for temp := head; temp != nil; temp = temp.Next {
		t := temp.Next
		added := false
		for t != nil {
			if t.Val > temp.Val {
				answer = append(answer, t.Val)
				added = true
				break
			}
			t = t.Next
		}
		if !added {
			answer = append(answer, 0)
		}
	}

	return answer
}

func main() {
	fmt.Println(nextLargerNodes(head))
}
