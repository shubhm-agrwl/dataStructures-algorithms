package com.shubham.algorithms.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationalSum {

  /*
  Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

  The same repeated number may be chosen from candidates unlimited number of times.

  Note:

      All numbers (including target) will be positive integers.
      The solution set must not contain duplicate combinations.

  Example 1:

  Input: candidates = [2,3,6,7], target = 7,
  A solution set is:
  [
    [7],
    [2,2,3]
  ]

  Example 2:

  Input: candidates = [2,3,5], target = 8,
  A solution set is:
  [
    [2,2,2,2],
    [2,3,3],
    [3,5]
  ]
  */

  public static void main(String[] args) {
    int[] candidates = {2, 3, 6, 7};
    System.out.println(combinationSum(candidates, 7));
  }

  private static List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> r = new ArrayList<>();
    findNumbers(candidates, target, res, r, 0);
    return res;
  }

  private static void findNumbers(int[] candidates, int sum, List<List<Integer>> res,
      List<Integer> r, int i) {

    // If  current sum becomes negative
    if (sum < 0) {
      return;
    }

    // if we get exact answer
    if (sum == 0) {
      List<Integer> r2 = new ArrayList<>(r);
      res.add(r2);
      return;
    }

    // Recur for all remaining elements that have value smaller than sum.
    while (i < candidates.length && sum - candidates[i] >= 0) {

      // Till every element in the array starting from i which can contribute to the sum
      r.add(candidates[i]); // add them to list

      // recur for next numbers
      findNumbers(candidates, sum - candidates[i], res, r, i);
      i++;

      // remove number from list (backtracking)
      r.remove(r.size() - 1);
    }
  }

}
