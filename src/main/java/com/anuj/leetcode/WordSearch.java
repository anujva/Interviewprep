package com.anuj.leetcode;

import java.util.HashSet;
import java.util.Set;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'a', 'a'}
        };
        System.out.println(exists(board, "aaa"));
    }

    private static boolean foundFullWord(String word, int wordIndex,
        char[][] board, int row, int col, Set<String> visitedRowCol) {
        if (wordIndex < word.length()) {
            if (row > -1 && col > -1 && row < board.length && col < board[0].length) {
                if (!visitedRowCol.contains(row + "" + col) && board[row][col] == word
                    .charAt(wordIndex)) {
                    visitedRowCol.add(row + "" + col);
                    boolean top = foundFullWord(word, wordIndex + 1,
                        board, row - 1, col, new HashSet<>(visitedRowCol));
                    boolean bottom = foundFullWord(word, wordIndex + 1,
                        board, row + 1, col, new HashSet<>(visitedRowCol));
                    boolean left = foundFullWord(word, wordIndex + 1,
                        board, row, col - 1, new HashSet<>(visitedRowCol));
                    boolean right = foundFullWord(word, wordIndex + 1,
                        board, row, col + 1, new HashSet<>(visitedRowCol));
                    return top || bottom || left || right;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public static boolean exists(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    Set<String> visitedRowCol = new HashSet<>();
                    if (foundFullWord(word, 0, board, i, j, visitedRowCol)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
