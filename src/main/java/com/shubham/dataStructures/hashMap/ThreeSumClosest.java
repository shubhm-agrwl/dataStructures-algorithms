package com.shubham.dataStructures.hashMap;

import java.util.Arrays;

public class ThreeSumClosest {

  /*
   * Given an array nums of n integers and an integer target, find three integers in nums such that
   * the sum is closest to target. Return the sum of the three integers. You may assume that each
   * input would have exactly one solution.
   *
   * Example:
   *
   * Given array nums = [-1, 2, 1, -4], and target = 1.
   *
   * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
   *
   *
   */

  public static void main(String[] args) {
    //int[] nums = {-1, 2, 1, -4};
    int[] nums = {-1, 2, 1, -4};
    threeSumClosest2(nums, 1);
    //System.out.println(threeSumClosest(nums, 1));
  }

  private static int threeSumClosest(int[] nums, int target) {

    int sum = Integer.MIN_VALUE;
    int diff = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          int isum = nums[i] + nums[j] + nums[k];
          int idiff = Math.abs(target - isum);
          if (idiff < diff) {
            sum = isum;
            diff = idiff;
          }
        }
      }
    }
    return sum;
  }

  private static int threeSumClosest2(int[] nums, int target) {
    int diff = Integer.MAX_VALUE, sz = nums.length;
    Arrays.sort(nums);
    for (int i = 0; i < sz && diff != 0; ++i) {
      int lo = i + 1, hi = sz - 1;
      while (lo < hi) {
        int sum = nums[i] + nums[lo] + nums[hi];
        if (Math.abs(target - sum) < Math.abs(diff)) {
          diff = target - sum;
        }
        if (sum < target) {
          ++lo;
        } else {
          --hi;
        }
      }
    }
    return target - diff;
  }

}
