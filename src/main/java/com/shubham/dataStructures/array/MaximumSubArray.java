package com.shubham.dataStructures.array;

  /*
  Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

  Example:

  Input: [-2,1,-3,4,-1,2,1,-5,4],
  Output: 6
  Explanation: [4,-1,2,1] has the largest sum = 6.

 */

public class MaximumSubArray {

  public static void main(String[] args) {
    int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
  }

  private static int maxSubArray(int[] nums) {

    int maxSoFar = nums[0];
    int currMax = nums[0];

    for (int i = 1; i < nums.length; i++) {
      currMax = Math.max(nums[i], currMax + nums[i]);
      maxSoFar = Math.max(maxSoFar, currMax);
    }
    return maxSoFar;
  }

}
