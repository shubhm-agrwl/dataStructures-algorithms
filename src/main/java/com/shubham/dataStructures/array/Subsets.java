package com.shubham.dataStructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

  List<List<Integer>> output = new ArrayList();
  int n, k;

  public void backtrack(int first, ArrayList<Integer> curr, int[] nums) {
    // if the combination is done
    if (curr.size() == k) {
      output.add(new ArrayList(curr));
      return;
    }
    for (int i = first; i < n; ++i) {
      // add i into the current combination
      curr.add(nums[i]);
      // use next integers to complete the combination
      backtrack(i + 1, curr, nums);
      // backtrack
      curr.remove(curr.size() - 1);
    }
  }

  public List<List<Integer>> subsets(int[] nums) {
    n = nums.length;
    for (k = 0; k < n + 1; ++k) {
      backtrack(0, new ArrayList<Integer>(), nums);
    }
    return output;
  }

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();

    if (nums == null || nums.length < 1) {
      result.add(new ArrayList<>());
      return result;
    }

    Arrays.sort(nums);

    iterate(0, nums, result, new ArrayList<>());

    return result;
  }

  private void iterate(int index, int[] nums, List<List<Integer>> result, List<Integer> list) {
    result.add(new ArrayList<>(list));

    Integer prev = null;

    for (int i = index; i < nums.length; i++) {
      if (prev == null || prev != nums[i]) {
        list.add(nums[i]);
        iterate(i + 1, nums, result, list);
        list.remove(list.size() - 1);
      }
      prev = nums[i];
    }
  }
}
