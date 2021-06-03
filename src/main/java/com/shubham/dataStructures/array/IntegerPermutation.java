package com.shubham.dataStructures.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerPermutation {

  public static void main(String[] args) {

    int num[] = {1, 2, 3};
    List<List<Integer>> res = permuteLC(num);
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

  public static List<List<Integer>> permuteLC(int[] nums) {
    List<List<Integer>> output = new ArrayList<>();

    List<Integer> l = new ArrayList<>();
    for (int num: nums){
      l.add(num);
    }

    int n = nums.length;
    backtrack(n, l, output, 0);
    return output;
  }

  public static void backtrack(int length, List<Integer> l, List<List<Integer>> output, int first) {
    if (first==length)
      output.add(new ArrayList<>(l));

    for (int i=first;i<length; i++) {
      Collections.swap(l, first, i);
      backtrack(length, l, output, first+1);
      Collections.swap(l, first, i);
    }
  }

}
