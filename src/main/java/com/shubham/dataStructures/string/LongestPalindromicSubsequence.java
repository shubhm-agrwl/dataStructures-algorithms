package com.shubham.dataStructures.string;

public class LongestPalindromicSubsequence {

  public static void main(String[] args) {
    System.out.println(longestPalindromeSubseq("affg"));
  }

  public static int longestPalindromeSubseq(String s) {
    int[][] dp = new int[s.length() + 1][s.length() + 1];
    int len = s.length();
    if (len < 2) {
      return len;
    }
    String reverse = new StringBuilder(s).reverse().toString();

    for (int i = 1; i <= len; i++) {
      for (int j = 1; j <= len; j++) {
        if (s.charAt(i - 1) == reverse.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[len][len];

  }

}
