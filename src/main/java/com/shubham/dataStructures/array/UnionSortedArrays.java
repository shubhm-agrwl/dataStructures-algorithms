package com.shubham.dataStructures.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UnionSortedArrays {

  /*

  Given two sorted arrays arr[] and brr[] of size N and M respectively. The task is to find the union of these two arrays.
  Union of two arrays can be defined as the common and distinct elements in the two arrays.

  Example 1:

  Input:
  N = 5, arr1[] = {1, 2, 3, 4, 5}
  M = 3, arr2 [] = {1, 2, 3}
  Output: 1 2 3 4 5
  Explanation: Distinct elements including
  both the arrays are: 1 2 3 4 5.

  Example 2:

  Input:
  N = 5, arr1[] = {2, 2, 3, 4, 5}
  M = 5, arr2[] = {1, 1, 2, 3, 4}
  Output: 1 2 3 4 5
  Explanation: Distinct elements including
  both the arrays are: 1 2 3 4 5.

  Example 3:

  Input:
  N = 5, arr1[] = {1, 1, 1, 1, 1}
  M = 5, arr2[] = {2, 2, 2, 2, 2}
  Output: 1 2
  Explanation: Distinct elements including
  both the arrays are: 1 2.

   */

  public static void main(String[] args) {

  }

  private static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
    // add your code here
    Set<Integer> res = new HashSet<>();

    int f = 0, s = 0;
    while (f < n && s < m) {
      if (arr1[f] < arr2[s]) {
        res.add(arr1[f++]);
      } else if (arr2[s] < arr1[f]) {
        res.add(arr2[s++]);
      } else {
        res.add(arr2[s++]);
        f++;
      }
    }

    while (f < n) {
      res.add(arr1[f++]);
    }
    while (s < m) {
      res.add(arr2[s++]);
    }

    ArrayList<Integer> r = new ArrayList<>(res);
    Collections.sort(r);
    return r;
  }

}
