package com.shubham.lcAprilChallenge;

public class OnesZeroes {

  public int findMaxForm(String[] strs, int m, int n) {
    int[][] dp = new int[m + 1][n + 1];
    for (String str : strs) {
      int zeros = 0, ones = 0;
      char[] charArr = str.toCharArray();
      for (char c : charArr) {
        if (c == '0') {
          zeros++;
        } else {
          ones++;
        }
      }
      for (int i = m; i >= zeros; i--) {
        for (int j = n; j >= ones; j--) {
          dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
        }
      }
    }
    return dp[m][n];
  }

}
