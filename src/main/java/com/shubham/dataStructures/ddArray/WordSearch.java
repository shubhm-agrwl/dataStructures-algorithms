package com.shubham.dataStructures.ddArray;

public class WordSearch {

  public boolean exist(char[][] board, String word) {

    char w = word.charAt(0);

    int m = board.length;
    int n = board[0].length;

    for (int i = 0; i < m; ++i) {
      for (int j = 0; j < n; ++j) {

        char c = board[i][j];

        if (c == w) {

          boolean[][] status = new boolean[m][n];

          boolean result = helper(board, i, j, m, n, word, 0, status);

          if (result)
            return true;
        }
      }
    }
    return false;
  }

  private boolean helper(char[][] board, int i, int j, int m, int n, String word, int index, boolean[][] status) {

    if (i < 0 || i == m || j < 0 || j == n || index == word.length())
      return false;

    if (status[i][j])
      return false;

    char c = word.charAt(index);

    if (board[i][j] != c)
      return false;

    if (index == word.length()-1)
      return true;

    status[i][j] = true;

    boolean result = false;

    result = helper(board, i-1, j, m, n, word, index+1, status);
    if (result)
      return true;

    result = helper(board, i+1, j, m, n, word, index+1, status);
    if (result)
      return true;

    result = helper(board, i, j-1, m, n, word, index+1, status);
    if (result)
      return true;

    result = helper(board, i, j+1, m, n, word, index+1, status);
    if (result)
      return true;

    status[i][j] = false;
    return false;
  }

}
