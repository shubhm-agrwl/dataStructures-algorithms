package com.shubham.dataStructures.array;

  /*
  Given two sorted arrays A and B, such that the arrays may have some common elements. Find the sum of the maximum sum path to reach from the beginning of any array to end of any of the two arrays. We can switch from one array to another array only at the common elements.

  Example 1:

  Input:
  M = 5, N = 4
  A[] = {2,3,7,10,12}
  B[] = {1,5,7,8}
  Output: 35
  Explanation: The path will be 1+5+7+10+12
  = 35.

  Example 2:

  Input:
  M = 3, N = 3
  A[] = {1,2,4}
  B[] = {1,2,7}
  Output: 10
  Explanation: The path will be 1+2+7=10.
 */

public class MaxPathSum {

  public static void main(String[] args) {
    int ar1[] = {2, 3, 7, 10, 12};
    int ar2[] = {1, 5, 7, 8};
    System.out.println(maxPathSum(ar1, ar2));
  }

  private static int maxPathSum(int ar1[], int ar2[]) {
    // initialize indexes for ar1[] and ar2[]
    int i = 0, j = 0;

    // Initialize result and current sum through ar1[]
    // and ar2[].
    int result = 0, sum1 = 0, sum2 = 0;

    // Below 3 loops are similar to merge in merge sort
    while (i < ar1.length && j < ar2.length) {
      // Add elements of ar1[] to sum1
      if (ar1[i] < ar2[j]) {
        sum1 += ar1[i++];
      }

      // Add elements of ar2[] to sum2
      else if (ar1[i] > ar2[j]) {
        sum2 += ar2[j++];
      }

      // we reached a common point
      else {
        // Take the maximum of two sums and add to
        // result
        result += max(sum1, sum2);

        // Update sum1 and sum2 for elements after
        // this intersection point
        sum1 = 0;
        sum2 = 0;

        // Keep updating result while there are more
        // common elements
        int temp = i;
        while (i < ar1.length && ar1[i] == ar2[j]) {
          sum1 += ar1[i++];
        }

        while (j < ar2.length && ar1[temp] == ar2[j]) {
          sum2 += ar2[j++];
        }

        result += max(sum1, sum2);

        sum1 = 0;
        sum2 = 0;
      }
    }

    // Add remaining elements of ar1[]
    while (i < ar1.length) {
      sum1 += ar1[i++];
    }

    // Add remaining elements of ar2[]
    while (j < ar2.length) {
      sum2 += ar2[j++];
    }

    // Add maximum of two sums of remaining elements
    result += max(sum1, sum2);

    return result;
  }

  // Utility function to find maximum of two integers
  private static int max(int x, int y) {
    return (x > y) ? x : y;
  }

}
