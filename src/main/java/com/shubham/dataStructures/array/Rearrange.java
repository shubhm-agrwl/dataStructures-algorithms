package com.shubham.dataStructures.array;

import java.util.HashMap;

public class Rearrange {

  /*
  Given an array arr[] of size N where every element is in the range from 0 to n-1. Rearrange the given array so that arr[i] becomes arr[arr[i]].

  Example 1:

  Input:
  N = 2
  arr[] = {1,0}
  Output: 0 1
  Explanation: arr[0] = 1 and arr[arr[0]]
  = 0.Also, arr[1] = 0 and arr[arr[1]] = 1.
  So, rearranging elements, we get array
  as, 0 1.

  Example 2:

  Input:
  N = 5
  arr[] = {4,0,2,1,3}
  Output: 3 4 2 0 1
  Explanation: arr[0] = 4 and arr[arr[0]]
  = 3. Also, arr[1] = 0 and arr[arr[1]]
  = 4 and so on. So, rearranging elements,
  we get array as 3 4 2 0 1.
   */

  public static void main(String[] args) {

    long arr[] = {4, 0, 2, 1, 3};
    arrange(arr, arr.length);
  }

  private static void arrange(long arr[], int n) {
    // your code here
    // First step: Increase all values by (arr[arr[i]]%n)*n
    for (int i = 0; i < n; i++)
      arr[i] += (arr[(int)arr[i]] % n) * n;

    // Second Step: Divide all values by n
    for (int i = 0; i < n; i++)
      arr[i] /= n;
  }

}
