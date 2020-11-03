package com.shubham.dataStructures.array;

import java.util.ArrayList;

public class SortedSubsequenceSize3 {

  /*
  Given an array A of N integers, find any 3 elements in it such that A[i] < A[j] < A[k] and i < j < k.

  Example 1:

  Input:
  N = 5
  A[] = {1,2,1,1,3}
  Output: 1
  Explanation: a sub-sequence 1 2 3 exist.

  Example 2:

  Input:
  N = 3
  A[] = {1,1,3}
  Output: 0
  Explanation: no such sub-sequence exist.
   */

  public static void main(String[] args) {
    ArrayList<Integer> input = new ArrayList<>();
    input.add(1);
    input.add(2);
    input.add(1);
    input.add(1);
    input.add(3);
    ArrayList<Integer> res = find3Numbers(input, input.size());
    for (Integer r : res) {
      System.out.println(r);
    }
  }

  private static ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
    // add code here.
    ArrayList<Integer> res = new ArrayList<>();

    int max = n - 1;

    // Index of minimum element
    // from left side
    int min = 0;
    int i;

    // Create an array that will store
    // index of a smaller element on left side.
    // If there is no smaller element on left
    // side, then smaller[i] will be -1.
    int[] smaller = new int[n];

    // first entry will always be -1
    smaller[0] = -1;
    for (i = 1; i < n; i++) {
      if (arr.get(i) <= arr.get(min)) {
        min = i;
        smaller[i] = -1;
      } else {
        smaller[i] = min;
      }
    }

    // Create another array that will
    // store index of a greater element
    // on right side. If there is no greater
    // element on right side, then greater[i]
    // will be -1.
    int[] greater = new int[n];

    // last entry will always be -1
    greater[n - 1] = -1;
    for (i = n - 2; i >= 0; i--) {
      if (arr.get(i) >= arr.get(max)) {
        max = i;
        greater[i] = -1;
      } else {
        greater[i] = max;
      }
    }

    // Now find a number which has
    // both greater number on right
    // side and smaller number on left side
    for (i = 0; i < n; i++) {
      if (smaller[i] != -1 && greater[i] != -1) {
        res.add(arr.get(smaller[i]));
        res.add(arr.get(i));
        res.add(arr.get(greater[i]));
        return res;
      }
    }

    // If we reach number, then there
    // are no such 3 numbers
    System.out.println("No such triplet found");
    return res;

  }
}
