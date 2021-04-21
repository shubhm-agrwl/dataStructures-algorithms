package com.shubham.lcAprilChallenge;

import java.util.Arrays;

public class CombinationSum4 {

  public int dp[];

  public int combinationSum4(int[] nums, int target) {
    dp = new int[target + 1];
    Arrays.fill(dp, -1);
    return Solve(nums, target);
  }

  public int Solve(int nums[], int sum) {
    if (sum == 0) {
      return 1;
    }
    if (sum < 0) {
      return 0;
    }
    if (dp[sum] != -1) {
      return dp[sum];
    }
    int count = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] <= sum) {
        count += Solve(nums, sum - nums[i]);
      }
    }
    return dp[sum] = count;
  }

  public int combinationSum4BottomUp(int[] nums, int target) {
    int dp[] = new int[target + 1];
    dp[0] = 1;
    for (int tar = 1; tar < target + 1; tar++) {
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] <= tar) {
          dp[tar] += dp[tar - nums[i]];
        }
      }
    }
    return dp[target];
  }

}
