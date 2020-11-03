package com.shubham.dataStructures.array;

public class MaxSumConfiguration {

  /*
    Given an array(0-based indexing), you have to find the max sum of i*A[i] where A[i] is the element at index i in the array. The only operation allowed is to rotate(clock-wise or counter clock-wise) the array any number of times.

  Example 1:

  Input:
  N = 4
  A[] = {8,3,1,2}
  Output: 29
  Explanation: Above the configuration
  possible by rotating elements are
  3 1 2 8 here sum is 3*0+1*1+2*2+8*3 = 29
  1 2 8 3 here sum is 1*0+2*1+8*2+3*3 = 27
  2 8 3 1 here sum is 2*0+8*1+3*2+1*3 = 17
  8 3 1 2 here sum is 8*0+3*1+1*2+2*3 = 11
  Here the max sum is 29
   */

  public static void main(String[] args) {
    int ar1[] = {8, 3, 1, 2};
    System.out.println(max_sum(ar1, ar1.length));
  }

  private static int max_sum(int A[], int n) {
    // Compute sum of all array elements
    int cum_sum = 0;
    for (int i = 0; i < n; i++) {
      cum_sum += A[i];
    }

    // Compute sum of i*arr[i] for
    // initial configuration.
    int curr_val = 0;
    for (int i = 0; i < n; i++) {
      curr_val += i * A[i];
    }

    // Initialize result
    int res = curr_val;

    // Compute values for other iterations
    for (int i = 1; i < n; i++) {
      // Compute next value using previous
      // value in O(1) time
      int next_val = curr_val - (cum_sum - A[i - 1]) + A[i - 1] * (n - 1);

      // Update current value
      curr_val = next_val;

      // Update result if required
      res = Math.max(res, next_val);
    }

    return res;
  }
}
