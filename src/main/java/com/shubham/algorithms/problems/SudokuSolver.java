package com.shubham.algorithms.problems;

import java.util.Arrays;

public class SudokuSolver {

  /*
  Write a program to solve a Sudoku puzzle by filling the empty cells.

  A sudoku solution must satisfy all of the following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.

  */

  public static void main(String[] args) {
    char[][] board = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    };

    solveSudoku(board);
  }

  private static char[][] board = new char[9][9];

  private static void solveSudoku(char[][] board) {
    int[][] sudoku = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (board[i][j] == '.') {
          sudoku[i][j] = 0;
        } else {
          sudoku[i][j] = Character.getNumericValue(board[i][j]);
        }
      }
    }

    board = solveSudokuTemp(sudoku);
    for (char[] row : board) {
      System.out.println(Arrays.toString(row));
    }
  }

  private static char[][] solveSudokuTemp(int[][] sudoku) {
    solveSudoku(sudoku);
    return board;
  }

  private static boolean solveSudoku(int[][] sudoku) {
    int row = -1;
    int col = -1;
    boolean isEmpty = true;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        if (sudoku[i][j] == 0) {
          row = i;
          col = j;

          // we still have some remaining
          // missing values in Sudoku
          isEmpty = false;
          break;
        }
      }
      if (!isEmpty) {
        break;
      }
    }

    // no empty space left
    if (isEmpty) {
      for (int r = 0; r < 9; r++) {
        for (int c = 0; c < 9; c++) {
          board[r][c] = (char) (sudoku[r][c] + '0');
        }
      }
      return true;
    }

    // else for each-row backtrack
    for (int num = 1; num <= 9; num++) {
      if (isSafe(sudoku, row, col, num)) {
        sudoku[row][col] = num;
        if (solveSudoku(sudoku)) {
          // print(board, n);
          return true;
        } else {
          sudoku[row][col] = 0; // replace it
        }
      }
    }
    return false;
  }

  private static boolean isSafe(int[][] board, int row, int col, int num) {

    // row has the unique (row-clash)
    for (int d = 0; d < board.length; d++) {
      // if the number we are trying to
      // place is already present in
      // that row, return false;
      if (board[row][d] == num) {
        return false;
      }
    }

    // column has the unique numbers (column-clash)
    for (int r = 0; r < board.length; r++) {
      // if the number we are trying to
      // place is already present in
      // that column, return false;

      if (board[r][col] == num) {
        return false;
      }
    }

    // corresponding square has
    // unique number (box-clash)
    int sqrt = (int) Math.sqrt(board.length);
    int boxRowStart = row - row % sqrt;
    int boxColStart = col - col % sqrt;

    for (int r = boxRowStart;
        r < boxRowStart + sqrt; r++) {
      for (int d = boxColStart;
          d < boxColStart + sqrt; d++) {
        if (board[r][d] == num) {
          return false;
        }
      }
    }

    // if there is no clash, it's safe
    return true;
  }

}
