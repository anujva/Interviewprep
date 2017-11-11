
package com.anuj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class NQueens {
  public static void main(String[] args) {
    System.out.println(solveNQueens(1));
  }

  public static void solveNQueensSubroutine(boolean[][] board, int n, Set<List<String>> solutions,
      Set<RowColumn> queensPosition) {
    if (n < 0) {
      return;
    }

    if (n == 0) {
      //whatever is the state of the board right now.. we have placed the queens correctly, and we should
      //update the solution array.
      //deduplicate possible same solutions.
      List<String> temp = new ArrayList<>();
      for (int i = 0; i < board.length; i++) {
        String tempString = "";
        for (int j = 0; j < board.length; j++) {
          if (queensPosition.contains(new RowColumn(i, j))) {
            tempString = tempString.concat("Q");
          } else {
            tempString = tempString.concat(".");
          }
        }
        temp.add(tempString);
      }
      solutions.add(temp);
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board.length; j++) {
        //if there is a false place the queen there.
        if (board[i][j] == false && n != 0) {
          //placing the queen there.. will turn all the horizontal vertical and
          //diagonal columns to true.
          boolean[][] oldBoard = board;
          board = turnAllValuesTrue(board, i, j);
          Set<RowColumn> queensPositionAddition = new HashSet<>();
          queensPositionAddition.addAll(queensPosition);
          queensPositionAddition.add(new RowColumn(i, j));
          solveNQueensSubroutine(board, n - 1, solutions, queensPositionAddition);
          board = oldBoard;
        }
      }
    }
  }

  public static boolean[][] turnAllValuesTrue(boolean[][] board, int i, int j) {
    boolean[][] boardNew = new boolean[board.length][board.length];
    for (int idx = 0; idx < board.length; idx++) {
      System.arraycopy(board[idx], 0, boardNew[idx], 0, board[idx].length);
    }
    //turn the row at index i,j true;
    for (int column = 0; column < board.length; column++) {
      boardNew[i][column] = true;
    }
    //turn the column at index i,j true;
    for (int row = 0; row < board.length; row++) {
      boardNew[row][j] = true;
    }
    //turn the right diagonal at index i, j true;
    for (int index = 0; index < board.length; index++) {
      if (i - index > -1 && j - index > -1) {
        boardNew[i - index][j - index] = true;
      }

      if (i + index < board.length && j - index > -1) {
        boardNew[i + index][j - index] = true;
      }

      if (i + index < board.length && j + index < board.length) {
        boardNew[i + index][j + index] = true;
      }

      if (i - index > -1 && j + index < board.length) {
        boardNew[i - index][j + index] = true;
      }
    }
    //turn the left diagonal at index i, j true;
    return boardNew;
  }

  public static List<List<String>> solveNQueens(int n) {
    //Get the board state and propagate it to the
    boolean[][] board = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        board[i][j] = false;
      }
    }
    Set<List<String>> solutions = new HashSet<>();
    Set<RowColumn> queensPosition = new HashSet<>();
    solveNQueensSubroutine(board, n, solutions, queensPosition);
    List<List<String>> solutionsList = solutions.parallelStream().collect(Collectors.toList());
    return solutionsList;
  }

  private static class RowColumn {
    int row;
    int column;

    RowColumn(int i, int j) {
      row = i;
      column = j;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      RowColumn rowColumn = (RowColumn)o;
      return row == rowColumn.row && column == rowColumn.column;
    }

    @Override
    public int hashCode() {
      return Objects.hash(row, column);
    }
  }
}
