package com.anuj;

public class BoggleBoard {
    public static void main(String[] args) {

    }

    public static boolean boggleSearch(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    //begin the search
                    boolean found = searchForWord(board, word, i, i);
                    if (found) return true;
                }
            }
        }
        return false;
    }

    public static boolean searchForWord(char[][] board, String word, int i, int j) {

        return false;
    }
}
