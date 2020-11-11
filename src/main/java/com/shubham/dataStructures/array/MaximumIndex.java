package com.shubham.dataStructures.array;

public class MaximumIndex {

  /*
  Given an array A[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of A[i] <= A[j].

  Example 1:

  Input:
  N = 2
  A[] = {1,10}
  Output: 1
  Explanation: A[0]<=A[1] so (j-i)
  is 1-0 = 1.

  Example 2:

  Input:
  N = 9
  A[] = {34,8,10,3,2,80,30,33,1}
  Output: 6
  Explanation: In the given array
  A[1] < A[7] satisfying the required
  condition(A[i] <= A[j]) thus giving
  the maximum difference of j - i
  which is 6(7-1).
   */

  public static void main(String[] args) {
    int arr[] = {9, 2, 3, 4, 5, 6, 7, 8, 18, 0};
    int n = arr.length;
    int maxDiff = maxIndexDiff(arr, n);
    System.out.println(maxDiff);
  }

  private static int maxIndexDiff(int arr[], int n) {
    int maxDiff;
    int i, j;

    int RMax[] = new int[n];
    int LMin[] = new int[n];

        /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
    LMin[0] = arr[0];
    for (i = 1; i < n; ++i) {
      LMin[i] = min(arr[i], LMin[i - 1]);
    }

        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
    RMax[n - 1] = arr[n - 1];
    for (j = n - 2; j >= 0; --j) {
      RMax[j] = max(arr[j], RMax[j + 1]);
    }

        /* Traverse both arrays from left to right to find optimum j - i
           This process is similar to merge() of MergeSort */
    i = 0;
    j = 0;
    maxDiff = -1;
    while (j < n && i < n) {
      if (LMin[i] < RMax[j]) {
        maxDiff = max(maxDiff, j - i);
        j = j + 1;
      } else {
        i = i + 1;
      }
    }

    return maxDiff;
  }

  private static int max(int x, int y) {
    return x > y ? x : y;
  }

  private static int min(int x, int y) {
    return x < y ? x : y;
  }

}
