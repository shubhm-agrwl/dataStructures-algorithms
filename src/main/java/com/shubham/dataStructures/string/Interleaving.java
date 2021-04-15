package com.shubham.dataStructures.string;

public class Interleaving {

  public static void main(String[] args) {
    System.out.println(isInterleaveWorking("aabcc", "dbbca", "aadbbcbcac"));
  }

  public static boolean isInterleave(String s1, String s2, String s3) {

    if (!(Math.abs(s1.length() - s2.length()) <= 1)) {
      return false;
    }

    if (s3.length() != s1.length() + s2.length()) {
      return false;
    }

    int s1p = 0;
    int s2p = 0;
    int s3p = 0;
    while (s1p < s1.length() || s2p < s2.length()) {
      if (s1p < s1.length() && (s3.charAt(s3p) == s1.charAt(s1p))) {
        s3p++;
        s1p++;
        continue;
      }
      if (s2p < s2.length() && (s3.charAt(s3p) == s2.charAt(s2p))) {
        s3p++;
        s2p++;
        continue;
      }
      return false;
    }
    return true;
  }

  public static boolean isInterleaveWorking(String s1, String s2, String s3) {
    if (s3.length() != s1.length() + s2.length()) {
      return false;
    }
    boolean dp[] = new boolean[s2.length() + 1];
    for (int i = 0; i <= s1.length(); i++) {
      for (int j = 0; j <= s2.length(); j++) {
        if (i == 0 && j == 0) {
          dp[j] = true;
        } else if (i == 0) {
          dp[j] = dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
        } else if (j == 0) {
          dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
        } else {
          dp[j] = (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[j - 1]
              && s2.charAt(j - 1) == s3.charAt(i + j - 1));
        }
      }
    }
    return dp[s2.length()];
  }

}
