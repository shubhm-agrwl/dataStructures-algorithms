package com.shubham.dataStructures.string;

import java.util.Arrays;

public class PalindromePartioning2 {

  static int dp[];

  public int minCut(String s) {
    dp = new int[s.length() + 1];
    Arrays.fill(dp, -1);
    return find_min(s, 0) - 1;
  }

  public static int find_min(String s, int curr) {
    if (s.length() == 0) {
      return 0;
    }
    if (dp[curr] != -1) {
      return dp[curr];
    }
    int minimize = 2002;
    for (int i = 0; i < s.length(); i++) {
      if (is_pallindrome(s.substring(0, i + 1))) {
			/*
			curr+i+1 is the start position of the current substring in the original string
			example: abacba
			so curr+i+1 for 2nd b will be 4
			*/
        minimize = Math.min(1 + find_min(s.substring(i + 1), curr + i + 1), minimize);
      }
    }
    return dp[curr] = minimize;
  }

  public static boolean is_pallindrome(String s) {
    int l = s.length();
    for (int i = 0; i < l / 2; i++) {
      if (s.charAt(i) != s.charAt(l - i - 1)) {
        return false;
      }
    }
    return true;
  }

}
