package com.shubham.dataStructures.string;

public class DecodeWays {

  public int numDecodings(String s) {
    int[] dp = new int[s.length() + 1];
    dp[0] = 1; // empty string
    dp[1] = s.charAt(0) != '0' ? 1 : 0;
    for (int i = 2; i <= s.length(); i++) {
      String first = s.substring(i - 1, i);
      String second = s.substring(i - 2, i);
      if (isValid(first)) {
        dp[i] += dp[i - 1];
      }
      if (isValid(second)) {
        dp[i] += dp[i - 2];
      }
    }
    return dp[s.length()];
  }

  public boolean isValid(String s) {
    if (s.length() == 0) {
      return true;
    }
    return s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5")
        || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("10")
        || s.equals("11") || s.equals("12") || s.equals("13") || s.equals("14") || s.equals("15")
        || s.equals("16") || s.equals("17") || s.equals("18") || s.equals("19") || s.equals("20")
        || s.equals("21") || s.equals("22") || s.equals("23") || s.equals("24") || s.equals("25")
        || s.equals("26");
  }

}
