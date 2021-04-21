package com.shubham.dataStructures.numbers;

import java.util.List;

public class Triangle {

  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();

    int[] dp = new int[n];

    for (int r = n - 1; r >= 0; r--) {
      // Start from the lowest row and work upwards
      List<Integer> row = triangle.get(r);
      for (int i = 0; i < row.size(); i++) {
        if (r == n - 1) {
          // For the last row the path is trivial
          dp[i] = row.get(i);
        } else {
          // Since we are moving to a higher row every time, Only dp[0]....dp[r] is needed
          // Before modification, dp[i] and dp[i+1] tell us the answer for the lower row r + 1
          dp[i] = Math.min(dp[i], dp[i + 1]) + row.get(i);
        }
      }
    }

    return dp[0];
  }

}
