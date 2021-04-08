package com.shubham.dataStructures.string;

public class ScrambleString {

  public boolean isScramble(String s1, String s2) {
    int n = s1.length();
    boolean[][][] dp = new boolean[n + 1][n][n];
    char[] chars1 = s1.toCharArray(), chars2 = s2.toCharArray();
    for (int l = 1; l <= n; l++) {
      for (int i1 = 0; i1 + l - 1 < n; i1++) {
        for (int i2 = 0; i2 + l - 1 < n; i2++) {
          if (l == 1) {
            dp[l][i1][i2] = chars1[i1] == chars2[i2];
          }
          for (int k = i1; k < i1 + l - 1; k++) {
            int left = k - i1 + 1;
            dp[l][i1][i2] |= dp[left][i1][i2] && dp[l - left][i1 + left][i2 + left];
            dp[l][i1][i2] |= dp[left][i1][i2 + l - left] && dp[l - left][i1 + left][i2];
            if (dp[l][i1][i2]) {
              break;
            }
          }
        }
      }
    }
    return dp[n][0][0];
  }

}
