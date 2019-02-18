package main

import "fmt"

//ChessBoard describes a chess board
type ChessBoard struct {
	board [][]bool
	size  int
}

// NewChessBoard returns an initialized chess board
func NewChessBoard(n int) ChessBoard {
	board := make([][]bool, n)
	for i := 0; i < n; i++ {
		board[i] = make([]bool, n)
	}

	return ChessBoard{
		board: board,
		size:  n,
	}
}

func solveNQueen(int n) [][]string {
	// Once we have the chessboard initialized,
	// we want to pass the chessboard and the queens
	// down placing a queen on the board in each iteration
}

func solveNQueenSubroutine(queenNum int, totQueens int, chessBoard ChessBoard) (bool, ChessBoard) {
	if queenNum == totQueens {
		// All queens have been placed on the board
		return true, chessBoard
	}

	// find an empty place and place the queen
	for i := 0; i < totQueens; i++ {
		for j := 0; j < totQueens; j++ {
			if chessBoard[i][j] {
				// place the current queen here and
				chessBoardCopy = makeACopy(chessBoard)
				placeQueenOnBoard(chessBoardCopy)
			}
		}
	}
}

func placeQueenOnBoard(chessBoard ChessBoard, i int, j int) {
	chessBoard.board[i][j] = true
	for index := 0; index < chessBoard.size; index++ {

	}
}

func main() {
	fmt.Println("vim-go")
}
