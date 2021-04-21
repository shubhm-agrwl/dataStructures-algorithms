package com.shubham.lcAprilChallenge;

import java.util.HashMap;

public class SubMatricesSumtoTarget {

  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    HashMap<Integer, Integer> count = new HashMap();
    int[] dp = new int[matrix[0].length];
    int res = 0;
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix.length; j++) {
        count.put(0, 1);
        res += numSubmatrixSumTarget(i, j, matrix, target, count, dp);
        count.clear();
      }
    }
    return res;
  }

  private int numSubmatrixSumTarget(int first, int second, int[][] matrix, int target,
      HashMap<Integer, Integer> count, int[] dp) {
    int res = 0;
    int sum = 0;
    for (int i = 0; i < matrix[first].length; i++) {
      sum += matrix[second][i];
      dp[i] = sum + (first == second ? 0 : dp[i]);
      res += count.getOrDefault(dp[i] - target, 0);
      count.put(dp[i], count.getOrDefault(dp[i], 0) + 1);
    }
    return res;
  }

}
