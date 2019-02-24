package main

import "testing"

func TestPlaceQueenOnBoard(t *testing.T) {
	chessBoard := NewChessBoard(4)
	placeQueenOnBoard(chessBoard, 1, 2)

	// Will check what the board looks like right now.
	printBoard(chessBoard)
}
