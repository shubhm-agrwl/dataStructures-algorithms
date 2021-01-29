package com.shubham.dataStructures.array;

import java.util.ArrayList;
import java.util.List;

public class IntegerPermutation {

  public static void main(String[] args) {

    int num[] = {1, 2, 3};
    List<List<Integer>> res = permute(num);
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> current = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      current.add(nums[i]);
    }
    permuteRec(res, current, new ArrayList<>());
    return res;
  }

  public static void permuteRec(
      List<List<Integer>> res,
      List<Integer> current,
      List<Integer> permutation) {
    int n = current.size();
    if (n == 0) {
      res.add(new ArrayList<>(permutation));
      return;
    }
    for (int i = 0; i < n; i++) {
      int x = current.get(i);
      current.remove(i);
      permutation.add(x);
      permuteRec(res, current, permutation);
      permutation.remove(new Integer(x));
      current.add(i, x);
    }
  }

}
