package com.shubham.dataStructures.hashMap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static int[] twoSum(int[] nums, int target) {

    for (int i = 0; i < nums.length; i++) {
      for (int j = 1; j < nums.length; j++) {
        if ((i != j) && (nums[i] + nums[j]) == target) {
          int[] sol = {i, j};
          return sol;
        }
      }
    }

    return null;

  }

  public static int[] twoSumUsingHashTwoPass(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement) && map.get(complement) != i) {
        return new int[] {i, map.get(complement)};
      }
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static int[] twoSumUsingHashOnePass(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[] {map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

  public static void twoSumMain() {
    
    /*
     * 
     * Problem 1: Given an array of integers, return indices of the two numbers such that they add
     * up to a specific target.
     * 
     * You may assume that each input would have exactly one solution, and you may not use the same
     * element twice.
     * 
     * Example:
     * 
     * Given nums = [2, 7, 11, 15], target = 9,
     * 
     * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
     */


    int nums[] = {2, 7, 11, 15};

    int sol[] = TwoSum.twoSum(nums, 9);
    
    for (int sols : sol)
      System.out.println(sols);

  }

}
