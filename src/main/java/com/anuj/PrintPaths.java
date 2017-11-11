
package com.anuj;

import java.util.ArrayList;

public class PrintPaths {
    public static void main(String[] args) {
        char[][] board = { { 'A', 'B', 'C', 'D' }, { 'E', 'F', 'G', 'H' }, { 'I', 'J', 'K', 'L' } };
        ArrayList<String> paths = printPaths(board);
        for (int i = 0; i < paths.size(); i++) {
            System.out.println(paths.get(i));
        }
    }

    public static ArrayList<String> printPaths(char[][] board) {
        if (board == null || (board.length == 0 && board[0].length == 0)) {
            return new ArrayList<>();
        }
        ArrayList<String> paths = new ArrayList<>();
        printPath(0, 0, board, paths, new StringBuffer());
        return paths;
    }

    public static void printPath(int i, int j, char[][] board, ArrayList<String> paths, StringBuffer stringBuffer) {
        if (i > board.length - 1) {
            return;
        }
        if (j > board[0].length - 1) {
            return;
        }
        if (i < board.length && j < board[0].length) {
            stringBuffer.append(board[i][j]);
        }
        if (i < board.length) {
            printPath(i + 1, j, board, paths, new StringBuffer(stringBuffer));
        }
        if (j < board[0].length) {
            printPath(i, j + 1, board, paths, new StringBuffer(stringBuffer));
        }
        if (i == board.length - 1 && j == board[0].length - 1) {
            paths.add(stringBuffer.toString());
        }
    }
}
