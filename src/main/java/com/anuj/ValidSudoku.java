package com.anuj;

/**
 * Created by anuj on 5/29/17.
 */
public class ValidSudoku {
    public static void main(String[] args) {
        //each row must have the numbers 1-9 occurring just once.
        //each column must have the numbers 1-9 occurring just once.
        //each of the 9 sub-boxes should have the numbers 1-9 occurring just once.
        String[] board = new String[]{
                ".87654321", "2........", "3........", "4........", "5........", "6........", "7........", "8........", "9........"
        };
        char[][] boardCharArray = new char[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                boardCharArray[i][j] = board[i].charAt(j);
            }
        }
        System.out.println(isValidSudoku(boardCharArray));
    }

    private static boolean[] initializeAllFalse() {
        boolean[] values = new boolean[]{
                false, false, false, false, false, false, false, false, false, false
        };
        return values;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            boolean[] values = initializeAllFalse();
            boolean[] values2 = initializeAllFalse();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == '.') {
                    //nothing to do.
                } else {
                    if (Character.getNumericValue(board[i][j]) > 0 &&
                            Character.getNumericValue(board[i][j]) < 10 &&
                            !values[Character.getNumericValue(board[i][j])]) {
                        values[Character.getNumericValue(board[i][j])] = true;
                    } else {
                        //found a duplicate value or board value not in range
                        return false;
                    }
                }
                if (board[j][i] == '.') {
                    //nothing to do.
                } else {
                    if (Character.getNumericValue(board[j][i]) > 0 && Character.getNumericValue(board[j][i]) < 10
                            && !values2[Character.getNumericValue(board[j][i])]) {
                        values2[Character.getNumericValue(board[j][i])] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i += 3) {
            for (int j = 0; j < board.length; j += 3) {
                boolean[] values = initializeAllFalse();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (board[i + k][j + l] == '.') {
                            continue;
                        }
                        if (Character.getNumericValue(board[i + k][j + l]) > 0 &&
                                Character.getNumericValue(board[i + k][j + l]) < 10 &&
                                !values[Character.getNumericValue(board[i + k][j + l])]) {
                            values[Character.getNumericValue(board[i + k][j + l])] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
