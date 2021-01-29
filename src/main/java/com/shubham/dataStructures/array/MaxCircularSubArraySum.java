package com.shubham.dataStructures.array;

public class MaxCircularSubArraySum {

  /*
  Given an array arr[] of N integers arranged in a circular fashion. Your task is to find the maximum contiguous subarray sum.

  Example 1:

  Input:
  N = 7
  arr[] = {8,-8,9,-9,10,-11,12}
  Output: 22
  Explanation:  Starting from the last
  element of the array, i.e, 12, and
  moving in a circular fashion, we
  have max subarray as 12, 8, -8, 9,
  -9, 10, which gives maximum sum
  as 22.

  Example 2:

  Input:
  N = 8
  arr[] = {10,-3,-4,7,6,5,-4,-1}
  Output: 23
  Explanation: Sum of the circular
  subarray with maximum sum is 23

   */

  public static void main(String[] args) {
    //int[] arr = {10, -3, -4, 7, 6, 5, -4, -1};
    int[] arr = {-12, -14};
    System.out.println(circularSubarraySum(arr, arr.length));
  }

  private static int circularSubarraySum(int arr[], int num) {

    // your code here

    // Case 1: get the maximum sum using standard kadane'
    // s algorithm
    int max_kadane = KadaneAlgo.maxSubarraySum(arr, arr.length);

    // Case 2: Now find the maximum sum that includes
    // corner elements.
    int max_wrap = 0;
    for (int i = 0; i < num; i++) {
      max_wrap += arr[i]; // Calculate array-sum
      arr[i] = -arr[i]; // invert the array (change sign)
    }

    // max sum with corner elements will be:
    // array-sum - (-max subarray sum of inverted array)
    max_wrap = max_wrap + KadaneAlgo.maxSubarraySum(arr, arr.length);

    // The maximum circular sum will be maximum of two sums
    if (max_wrap == 0) {
      return max_kadane;
    }
    return (max_wrap > max_kadane) ? max_wrap : max_kadane;
  }

}
