package com.shubham.dataStructures.ddArray;

public class SurroundedRegions {

  public void solve(char[][] board) {
    int row = board.length;
    int col = board[0].length;

    // Go through all cells and for any land by boarder, mark them by updating 'O' to 'E'
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++)
      // the land on border & it is a land
      {
        if ((r == 0 || c == 0 || r == row - 1 || c == col - 1) && board[r][c] == 'O') {
          setTheBorderLands(board, row, col, r, c);
        }
      }
    }

    // Go through all cells again,
    // if they are 'O', they are land but not conected to boarder so set them to 'X'
    // if they are 'E', they are land contected to boarder so update them to 'O'
    for (int r = 0; r < row; r++) {
      for (int c = 0; c < col; c++) {
        if (board[r][c] == 'O') {
          board[r][c] = 'X';
        }
        if (board[r][c] == 'E') {
          board[r][c] = 'O';
        }
      }
    }
  }

  private void setTheBorderLands(char[][] board, int row, int col, int r, int c) {
    if (r < 0 || c < 0 || r >= row || c >= col || board[r][c] != 'O') {
      return;
    }

    board[r][c] = 'E';

    if (r >= 0 && c >= 0 && r < row && c < col) {
      setTheBorderLands(board, row, col, r + 1, c);
      setTheBorderLands(board, row, col, r - 1, c);
      setTheBorderLands(board, row, col, r, c + 1);
      setTheBorderLands(board, row, col, r, c - 1);
    }
  }

}
