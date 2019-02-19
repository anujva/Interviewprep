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

func solveNQueen(n int) [][]string {
	// Once we have the chessboard initialized,
	// we want to pass the chessboard and the queens
	// down placing a queen on the board in each iteration
	allPositions = make([]queenPositions, 0)
	solveNQueenSubroutine(0, n, NewChessBoard(n))
	return nil
}

type queenPositions struct {
	i int
	j int
}

var allPositions []queenPositions
var allFinalPositions [][]queenPositions

func solveNQueenSubroutine(queenNum int, totQueens int, chessBoard ChessBoard) bool {
	if queenNum == totQueens {
		// All queens have been placed on the board
		return true
	}

	// find an empty place and place the queen
	for i := 0; i < totQueens; i++ {
		for j := 0; j < totQueens; j++ {
			if !chessBoard.board[i][j] {
				// place the current queen here and
				chessBoardCopy := makeACopy(chessBoard)
				placeQueenOnBoard(chessBoardCopy, i, j)
				allPositions = append(allPositions, queenPositions{i: i, j: j})
				done := solveNQueenSubroutine(queenNum+1, totQueens, chessBoardCopy)
				// This will return only one arrangement that has the queen's in place
				if done {
					if queenNum == totQueens-1 {
						allFinalPositions = append(allFinalPositions, allPositions)
						return true
					}
				}
				allPositions = allPositions[0 : len(allPositions)-1]
			}
		}
	}
	return false
}

func makeACopy(chessBoard ChessBoard) ChessBoard {
	chessBoardNew := NewChessBoard(chessBoard.size)
	for i := 0; i < chessBoard.size; i++ {
		for j := 0; j < chessBoard.size; j++ {
			chessBoardNew.board[i][j] = chessBoard.board[i][j]
		}
	}
	return chessBoardNew
}

func placeQueenOnBoard(chessBoard ChessBoard, i int, j int) {
	chessBoard.board[i][j] = true
	for index := 0; index < chessBoard.size; index++ {
		chessBoard.board[i][index] = true
		chessBoard.board[index][j] = true

		// Set the diagonals to also be true
		if i+index < chessBoard.size && j+index < chessBoard.size {
			chessBoard.board[i+index][j+index] = true
		}

		if i-index > -1 && j-index > -1 {
			chessBoard.board[i-index][j-index] = true
		}
	}
}

func main() {
	solveNQueen(4)
	fmt.Println(allFinalPositions)
}
