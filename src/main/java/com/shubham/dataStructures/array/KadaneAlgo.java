package com.shubham.dataStructures.array;

public class KadaneAlgo {

  public static void main(String[] args) {

  }

  public static int maxSubarraySum(int arr[], int n) {

    int max_so_far = Integer.MIN_VALUE,
        max_ending_here = 0, start = 0,
        end = 0, s = 0;

    for (int i = 0; i < n; i++) {
      max_ending_here += arr[i];

      if (max_so_far < max_ending_here) {
        max_so_far = max_ending_here;
        start = s;
        end = i;
      }

      if (max_ending_here < 0) {
        max_ending_here = 0;
        s = i + 1;
      }
    }

    return max_so_far;

  }

  public int maxProduct(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }

    int result = Integer.MIN_VALUE;
    int cur = 0;

    for (int i = 0; i < nums.length; i++) {
      if (cur == 0) {
        cur = nums[i];
      } else {
        cur *= nums[i];
      }
      result = Math.max(result, cur);
    }

    cur = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      if (cur == 0) {
        cur = nums[i];
      } else {
        cur *= nums[i];
      }
      result = Math.max(result, cur);
    }

    return result;
  }

}
