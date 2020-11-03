package com.shubham.dataStructures.array;

import java.util.ArrayList;
import javafx.util.Pair;

public class MountainSubarray {

  /*
  We are given an array of integers and a range, we need to find whether the subarray which falls in this range has values in the form of a mountain or not. All values of the subarray are said to be in the form of a mountain if either all values are increasing or decreasing or first increasing and then decreasing. More formally a subarray [a1, a2, a3 … aN] is said to be in form of a mountain if there exists an integer K, 1 <= K <= N such that,
  a1 <= a2 <= a3 .. <= aK >= a(K+1) >= a(K+2) …. >= aN
  You have to process Q queries. In each query you are given two integer L and R, denoting starting and last index of the subarrays respectively.

  Example 1:

  Input:
  N = 8
  a[] = {2,3,2,4,4,6,3,2}
  Q = 2
  Queries = (0,2), (1,3)
  Output:
  Yes
  No
  Explanation: For L = 0 and R = 2, a0 = 2,
  a1 = 3 and a2 = 2, since they are in the
  valid order,answer is Yes.
  For L = 1 and R = 3, a1 = 3, a2 = 2 and
  a3 = 4, since a1 > a2 and a2 < a4 the
  order isn't valid, hence the answer is
  No.
   */

  public static void main(String[] args) {
    int ar1[] = {2, 3, 2, 4, 4, 6, 3, 2};
    ArrayList<Pair> queries = new ArrayList<>();
    queries.add(new Pair(0, 2));
    queries.add(new Pair(1, 3));
    ArrayList<Boolean> res = processQueries(ar1, ar1.length, queries, queries.size());
    for (Boolean r : res) {
      System.out.println(r);
    }
  }

  private static ArrayList<Boolean> processQueries(int[] a, int n, ArrayList<Pair> queries, int q) {
    // code here

    int[] left = lpreprocess(a, n, new int[n]);
    int[] right = rpreprocess(a, n, new int[n]);
    ArrayList<Boolean> res = new ArrayList<>();
    for (Pair p : queries) {
      int s = (int) p.getKey();
      int e = (int) p.getValue();
      if (right[s] >= left[e]) {
        res.add(true);
      } else {
        res.add(false);
      }
    }
    return res;
  }

  private static int[] lpreprocess(int arr[], int N, int left[]) {
    // initialize first left index as that index only
    left[0] = 0;
    int lastIncr = 0;

    for (int i = 1; i < N; i++) {
      // if current value is greater than previous,
      // update last increasing
      if (arr[i] > arr[i - 1]) {
        lastIncr = i;
      }
      left[i] = lastIncr;
    }

    return left;
  }

  private static int[] rpreprocess(int arr[], int N, int right[]) {
    // initialize last right index as that index only
    right[N - 1] = N - 1;
    int firstDecr = N - 1;

    for (int i = N - 2; i >= 0; i--) {
      // if current value is greater than next,
      // update first decreasing
      if (arr[i] > arr[i + 1]) {
        firstDecr = i;
      }
      right[i] = firstDecr;
    }
    return right;
  }

}
