package com.shubham.algorithms.problems;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

  /*
  Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
  */

  public static void main(String[] args) {
    char[][] board = {
        {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
    };

    System.out.println(isValidSudoku(board));
  }

  private static boolean isValidSudoku(char[][] board) {
    for (int i = 0; i < 9; i++) {
      if (!(validRow(i, board) && validCol(i, board))) {
        return false;
      }
    }
    return validSubSquares(board);
  }

  private static boolean validSubSquares(char[][] board) {
    for (int row = 0; row < 9; row = row + 3) {
      for (int col = 0; col < 9; col = col + 3) {
        Set<Character> set = new HashSet<>();
        for (int r = row; r < row + 3; r++) {
          for (int c = col; c < col + 3; c++) {
            if (board[r][c] != '.') {
              if (set.add(board[r][c]) == false) {
                return false;
              }
            }
          }
        }
      }
    }
    return true;
  }

  private static boolean validCol(int col, char[][] board) {
    Set<Character> set = new HashSet<>();
    for (int i = 0; i < 9; i++) {
      if (board[i][col] != '.') {
        if (set.add(board[i][col]) == false) {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean validRow(int row, char[][] board) {
    char temp[] = board[row];
    Set<Character> set = new HashSet<>();
    for (char value : temp) {
      if (value != '.') {
        if (set.add(value) == false) {
          return false;
        }
      }
    }
    return true;
  }

}
