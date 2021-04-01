package com.shubham.algorithms.problems.dp;

public class MinimumPathSum {

  public static void main(String[] args) {
//    System.out.println(minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    System.out.println(minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}}));
  }

  public static int minPathSum(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int dp[][] = new int[m][n];

    dp[0][0] = grid[0][0];

    for (int i = 1; i < n; i++) {
      dp[0][i] = grid[0][i] + dp[0][i - 1];
    }

    for (int i = 1; i < m; i++) {
      dp[i][0] = grid[i][0] + dp[i - 1][0];
    }

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = Math.min(grid[i][j] + dp[i - 1][j], grid[i][j] + dp[i][j - 1]);
      }
    }

    return dp[m - 1][n - 1];

  }

}
