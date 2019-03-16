package main

import "fmt"
import "strconv"

//Node is of type struct and stores values in a graph
type Node struct {
	val   int
	left  *Node
	right *Node
}

func serialize(node *Node) string {
	if node == nil {
		return ""
	}

	return strconv.Itoa(node.val) + serialize(node.left) + serialize(node.right)
}

func main() {
	node := &Node{
		1,
		&Node{
			2,
			nil,
			nil,
		},
		&Node{
			3,
			nil,
			nil,
		},
	}

	fmt.Println(serialize(node))
}
