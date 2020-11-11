package com.shubham.dataStructures.array;

public class EquillibriumPoint {

  /*
    Given an array A of N positive numbers. The task is to find the first Equilibium Point in the array.
  Equilibrium Point in an array is a position such that the sum of elements before it is equal to the sum of elements after it.

  Example 1:

  Input:
  N = 1
  A[] = {1}
  Output: 1
  Explanation: Since its the only
  element hence its the only equilibrium
  point.

  Example 2:

  Input:
  N = 5
  A[] = {1,3,5,2,2}
  Output: 3
  Explanation: For second test case
  equilibrium point is at position 3
  as elements before it (1+3) =
  elements after it (2+2).
   */

  public static void main(String[] args) {
    long ar1[] = {1, 3, 5, 2, 2};
    System.out.println(equilibriumPoint(ar1, ar1.length));
  }

  private static int equilibriumPoint(long arr[], int n) {

    // Your code here

    if (n == 1) {
      return 1;
    }

    int totalSum = 0;
    for (int i = 0; i < n; i++) {
      totalSum += arr[i];
    }

    long leftSum = 0;
    long rightSum;

    for (int i = 1; i < n; i++) {
      leftSum += arr[i - 1];
      rightSum = totalSum - leftSum - arr[i];
      if (leftSum == rightSum) {
        return i + 1;
      }
    }

    return -1;
  }
}
