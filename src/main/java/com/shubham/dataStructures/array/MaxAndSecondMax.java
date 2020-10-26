package com.shubham.dataStructures.array;

  /*
  Given an array arr[] of size N of positive integers which may have duplicates. The task is to find the maximum and second maximum from the array, and both of them should be distinct, so If no second max exists, then the second max will be -1.

  Input Format:
  The first line of input contains the number of test cases T. For each test case, the first line of input contains the size of array N, the next line contains array elements.

  Output Format:
  For each test case, print the maximum and second maximum from the array. IF no second max exists, print "-1" for the second max.

  User Task:
  The task is to complete the function largestAndSecondLargest(), which should return maximum and second maximum element from the array with first element as maximum element and second element as second maximum.

  Expected Time Complexity: O(N).
  Expected Auxiliary Space: O(1).

  Constraints:
  1 <= T <= 100
  1 <= N <= 106
  1 <= arr[i] <= 106

  Example:
  Input:
  3
  5
  1 2 3 4 5
  3
  2 1 2
  2
  5 5

  Output:
  5 4
  2 1
  5 -1
 */

import java.util.ArrayList;

public class MaxAndSecondMax {

  public static void main(String[] args) {

    for (int i : largestAndSecondLargest(5, new int[]{1, 2, 3, 4, 5})) {
      System.out.println(i);
    }
  }

  private static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]) {
    Integer first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
    for (int i = 0; i < sizeOfArray; i++) {
      if (arr[i] > second && arr[i] != first) {
        if (arr[i] > first) {
          second = first;
          first = arr[i];
        } else {
          second = arr[i];
        }
      }
    }

    if (second == Integer.MIN_VALUE) {
      second = -1;
      if (first == Integer.MIN_VALUE) {
        first = -1;
      }
    }
    ArrayList<Integer> res = new ArrayList<>();
    res.add(first);
    res.add(second);
    return res;
  }

}
