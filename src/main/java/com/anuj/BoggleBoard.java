package com.anuj;

public class BoggleBoard {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'O', 'L'},
                {'D', 'E', 'L'},
                {'G', 'H', 'I'},
        };

        System.out.println(boggleSearch(board, "HELLO"));
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
            boolean found = false;
            if (i > -1 && i < board.length - 1 && j > -1 && j < board[0]
                    .length && word.charAt(wordIndex) == board[i + 1][j]) {
                found = searchForWord(board, word, i + 1, j, wordIndex + 1);
            }

            if (!found) {
                if (i > -1 && i < board.length && j > -1 && j < board[0]
                        .length - 1 && word.charAt(wordIndex) == board[i][j +
                        1]) {

                    found = searchForWord(board, word, i, j + 1, wordIndex + 1);
                }
            }

            if (!found) {
                if (i > 0 && i < board.length && j > -1 && j < board[0]
                        .length && word.charAt(wordIndex) == board[i - 1][j]) {
                    found = searchForWord(board, word, i - 1, j, wordIndex +
                            1);
                }
            }

            if (!found) {
                if (i > -1 && i < board.length && j > 0 && j < board[0]
                        .length && word.charAt(wordIndex) == board[i][j - 1]) {
                    found = searchForWord(board, word, i, j - 1, wordIndex +
                            1);
                }
            }

            return found;
        } else if (wordIndex == word.length()) {
            return true;
        }
        return false;
    }
}
