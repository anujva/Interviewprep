package main

func solve(board [][]byte) {
	rows := len(board)
	cols := len(board[0])

	connectedToEnd := make([][]boolean, rows)
	for i := 0; i < cols; i++ {
		connectedToEnd[i] = make([]bool, cols)
	}

	for i := 0; i < cols; i++ {
		if board[0][i] == 'O' {
			// make all connected spots true
		}

		if board[row-1][i] == 'O' {
			connectedToEnd[row-1][i] = true
		}
	}

}

// row, col are the max lengths, I could use the board for the
// row and col
func makeBoardTrue(booleanBoard [][]bool, i, j, row, col int) {

}

func main() {

}
