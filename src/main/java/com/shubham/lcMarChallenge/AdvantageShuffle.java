package com.shubham.lcMarChallenge;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class AdvantageShuffle {

  public static void main(String[] args) {
    int[] res = advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2});
  }

  public static int[] advantageCount(int[] A, int[] B) {

    int[] res = new int[A.length];
    int[] processed = new int[A.length];
    for (int i = 0; i < res.length; i++) {
      for (int j = 0; j < A.length; j++) {
        if (processed[j] == 0 && A[j] > B[i]) {
          res[i] = A[j];
          processed[j] = 1;
          break;
        }
      }
    }
    for (int j = 0; j < A.length; j++) {
      if (processed[j] == 0) {
        res[j] = A[j];
      }
    }
    return res;
  }

  public int[] advantageCountWorking(int[] A, int[] B) {
    int[] sortedA = A.clone();
    Arrays.sort(sortedA);
    int[] sortedB = B.clone();
    Arrays.sort(sortedB);

    // assigned[b] = list of a that are assigned to beat b
    Map<Integer, Deque<Integer>> assigned = new HashMap();
    for (int b : B) {
      assigned.put(b, new LinkedList());
    }

    // remaining = list of a that are not assigned to any b
    Deque<Integer> remaining = new LinkedList();

    // populate (assigned, remaining) appropriately
    // sortedB[j] is always the smallest unassigned element in B
    int j = 0;
    for (int a : sortedA) {
      if (a > sortedB[j]) {
        assigned.get(sortedB[j++]).add(a);
      } else {
        remaining.add(a);
      }
    }

    // Reconstruct the answer from annotations (assigned, remaining)
    int[] ans = new int[B.length];
    for (int i = 0; i < B.length; ++i) {
      // if there is some a assigned to b...
      if (assigned.get(B[i]).size() > 0) {
        ans[i] = assigned.get(B[i]).pop();
      } else {
        ans[i] = remaining.pop();
      }
    }
    return ans;
  }

}
