package com.anuj;

public class BoggleBoard {
    public static void main(String[] args) {

    }

    public static boolean boggleSearch(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    //begin the search
                    boolean found = searchForWord(board, word, i, j, 1);
                    if (found) return true;
                }
            }
        }
        return false;
    }

    public static boolean searchForWord(char[][] board, String word, int i,
                                        int j, int wordIndex) {
        if (wordIndex < word.length()) {
            if (i > -1 && i < board.length - 1 && j > -1 && j < board[0]
                    .length && word.charAt(wordIndex) == board[i + 1][j]) {

            } else if (word.charAt(wordIndex) == board[i][j + 1]) {

            } else if (word.charAt(wordIndex) == board[i - 1][j]) {

            } else if (i > -1 && i < board.length && j > 0 && j < board[0]
                    .length && word.charAt(wordIndex) == board[i][j - 1]) {

            }
        }
        return false;
    }
}
