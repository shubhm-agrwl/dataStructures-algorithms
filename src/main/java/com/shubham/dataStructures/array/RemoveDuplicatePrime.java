package com.shubham.dataStructures.array;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatePrime {

  /*
    Given an array consisting of only prime numbers, remove all duplicate numbers from it.
  Note: Retain the first occurrence of the duplicate element.

  Example 1:

  Input:
  N = 6
  A[] = {2,2,3,3,7,5}
  Output: 2 3 7 5
  Explanation: After removing the duplicate
  2 and 3 we get 2 3 7 5.
     */

  public static void main(String[] args) {

    int ar1[] = {2, 2, 3, 3, 7, 5};
    int res[] = removeDuplicate(ar1, 6);
    for (int i : res) {
      System.out.println(i);
    }

  }

  private static int[] removeDuplicate(int arr[], int n) {
    // code here
    Set<Integer> result = new HashSet<>();
    for (int i : arr) {
      result.add(i);
    }
    return result.stream().mapToInt(Number::intValue).toArray();
  }

}
