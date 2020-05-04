package com.shubham.algorithms.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSumUnique {

  /*
  Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

  Each number in candidates may only be used once in the combination.

  Note:

      All numbers (including target) will be positive integers.
      The solution set must not contain duplicate combinations.

  Example 1:

  Input: candidates = [10,1,2,7,6,1,5], target = 8,
  A solution set is:
  [
    [1, 7],
    [1, 2, 5],
    [2, 6],
    [1, 1, 6]
  ]

  Example 2:

  Input: candidates = [2,5,2,1,2], target = 5,
  A solution set is:
  [
    [1,2,2],
    [5]
  ]
   */

  public static void main(String[] args) {

    int[] candidates = {10, 1, 2, 7, 6, 1, 5};
    System.out.println(combinationSum(candidates, 8));
  }

  private static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> r = new ArrayList<>();
    findNumbers(candidates, target, res, r, -1);
    return res;
  }

  private static void findNumbers(int[] candidates, int sum,
      List<List<Integer>> res, List<Integer> r, int i) {

    // If  current sum becomes negative
    if (sum < 0) {
      return;
    }

    // if we get exact answer
    if (sum == 0) {
      List<Integer> r2 = new ArrayList<>(r);
      if (!res.contains(r2)) {
        res.add(r2);
      }
      return;
    }

    // Recur for all remaining elements that have value smaller than sum.
    while (i < candidates.length - 1) {
      i++;

      // Till every element in the array starting from i which can contribute to the sum
      r.add(candidates[i]); // add them to list

      // recur for next numbers
      findNumbers(candidates, sum - candidates[i], res, r, i);

      // remove number from list (backtracking)
      r.remove(r.size() - 1);
    }
  }

}
