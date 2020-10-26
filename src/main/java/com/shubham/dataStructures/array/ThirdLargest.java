package com.shubham.dataStructures.array;

  /*
  Given an array of distinct elements. Find the third largest element in it.

  Input:
  The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. The first line of each test case is N, size of the array. The second line of each test case contains N space separated values of the array a[].

  Output:
  Print the third largest element of the array. If the array has less than 3 elements print -1.

  Your Task:
  You don't need to read input or print anything. Your task is to complete the function thirdLargest() which takes the array a[] and the size of the array as inputs and returns the third largest element in the array. Return -1 if there are less than 3 elements in the input.

  Expected Time Complexity: O(N).
  Expected Auxiliary Space: O(1).

  Constraints:
  1 ≤ T ≤ 100
  1 ≤ N ≤ 105
  1 ≤ A[i] ≤ 105

  Example:
  Sample Input:
  2
  5
  2 4 1 3 5
  2
  10 2

  Sample Output:
  3
  -1
 */

public class ThirdLargest {

  public static void main(String[] args) {
    System.out.println(thirdLargest(new Long[]{1L, 2L, 3L, 4L, 5L}));
  }

  private static long thirdLargest(Long a[]) {
    if (a.length < 3) {
      return -1;
    }
    long first = Long.MIN_VALUE, second = Long.MIN_VALUE, third = Long.MIN_VALUE;
    for (int i = 0; i < a.length; i++) {
      if (a[i] > third) {
        if (a[i] > second) {
          third = second;
          if (a[i] > first) {
            second = first;
            first = a[i];
          } else {
            second = a[i];
          }
        } else {
          third = a[i];
        }
      }
    }
    return third;
  }

}
