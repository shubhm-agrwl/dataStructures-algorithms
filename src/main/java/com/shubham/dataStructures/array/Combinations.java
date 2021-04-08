package com.shubham.dataStructures.array;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

  private List<List<Integer>> backtrack(List<List<Integer>> level, int n, int k) {
    if (level.get(0).size() == k) {
      return level;
    }

    List<List<Integer>> next_level = new ArrayList<List<Integer>>();

    for (int i = 0; i < level.size(); i++) {
      List<Integer> temp_arr = level.get(i);

      // Add number from the last number in the array to n
      for (int j = temp_arr.get(temp_arr.size() - 1) + 1; j <= n; j++) {
        // Copy the array
        List<Integer> sub_arr = new ArrayList<Integer>(level.get(i));

        sub_arr.add(j);
        next_level.add(sub_arr);
      }
    }

    return backtrack(next_level, n, k);
  }

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> first_level = new ArrayList<List<Integer>>();

    // Initialize the first level of the tree
    for (int i = 1; i <= (n - k + 1); i++) {
      List<Integer> sub_arr = new ArrayList<Integer>();
      sub_arr.add(i);
      first_level.add(sub_arr);
    }

    return backtrack(first_level, n, k);
  }

}
