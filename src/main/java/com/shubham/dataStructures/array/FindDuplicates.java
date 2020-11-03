package com.shubham.dataStructures.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class FindDuplicates {

  /*
  Given an array a[] of size N which contains elements from 0 to N-1, you need to find all the elements occurring more than once in the given array.

  Example 1:

  Input:
  N = 4
  a[] = {0,3,1,2}
  Output: -1
  Explanation: N=4 and all elements from 0
  to (N-1 = 3) are present in the given
  array. Therefore output is -1.

  Example 2:

  Input:
  N = 5
  a[] = {2,3,1,2,3}
  Output: 2 3
  Explanation: 2 and 3 occur more than once
  in the given array.

  GeeksForGeeks Solution:
  https://www.geeksforgeeks.org/find-duplicates-in-on-time-and-constant-extra-space/
   */

  public static void main(String[] args) {
    int ar1[] = {2, 3, 1, 2, 3};
    ArrayList<Integer> res = duplicates(ar1, ar1.length);
    for (Integer r : res) {
      System.out.println(r);
    }
  }

  public static ArrayList<Integer> duplicates(int arr[], int n) {
    Set<Integer> res = new HashSet<>();
    ArrayList<Integer> array = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (array.contains(arr[i])) {
        res.add(arr[i]);
      } else {
        array.add(arr[i]);
      }
    }
    if (res.isEmpty()) {
      res.add(-1);
    }
    ArrayList<Integer> r = new ArrayList<>(res);
    Collections.sort(r);
    return r;
  }
}
