package com.shubham.dataStructures.hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class FourSum {

  /*
   * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in
   * nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the
   * sum of target.
   *
   * Note:
   *
   * The solution set must not contain duplicate quadruplets.
   *
   * Example:
   *
   * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
   *
   * A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
   *
   */

  public static void main(String[] args) {
    int[] nums = {-4, -3, -2, -1, 0, 0, 1, 2, 3, 4};
    System.out.println(fourSum(nums, 0));
  }

  private static List<List<Integer>> fourSum(int[] nums, int target) {

    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    TreeSet<String> set = new TreeSet<>();

    // Store sums of all pairs in a hash table
    HashMap<Integer, pair> mp = new HashMap<>();
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        mp.put(nums[i] + nums[j], new pair(i, j));
      }
    }

    // Traverse through all pairs and search
    // for X - (current pair sum).
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        int sum = nums[i] + nums[j];

        // If X - sum is present in hash table,
        if (mp.containsKey(target - sum)) {

          // Making sure that all elements are
          // distinct array elements and an element
          // is not considered more than once.
          pair p = mp.get(target - sum);
          if (p.first != i && p.first != j && p.second != i && p.second != j) {

            int a[] = {nums[i], nums[j], nums[p.first], nums[p.second]};
            Arrays.sort(a);

            String str = a[0] + ":" + a[1] + ":" + a[2] + ":" + a[3];

            if (!set.contains(str)) {
              List<Integer> r = new ArrayList<>();
              r.add(nums[i]);
              r.add(nums[j]);
              r.add(nums[p.first]);
              r.add(nums[p.second]);
              res.add(r);
              set.add(str);
            }
          }
        }
      }
    }

    return res;
  }

  private static class pair {

    int first, second;

    private pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

  public List<List<Integer>> fourSumSolution(int[] nums, int target) {
    Arrays.sort(nums);
    return kSum(nums, target, 0, 4);
  }

  public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (start == nums.length || nums[start] * k > target || target > nums[nums.length - 1] * k) {
      return res;
    }
    if (k == 2) {
      return twoSum(nums, target, start);
    }
    for (int i = start; i < nums.length; ++i) {
      if (i == start || nums[i - 1] != nums[i]) {
        for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
          res.add(new ArrayList<>(Arrays.asList(nums[i])));
          res.get(res.size() - 1).addAll(set);
        }
      }
    }
    return res;
  }

  public List<List<Integer>> twoSum(int[] nums, int target, int start) {
    List<List<Integer>> res = new ArrayList<>();
    Set<Integer> s = new HashSet<>();
    for (int i = start; i < nums.length; ++i) {
      if (res.isEmpty() || res.get(res.size() - 1).get(1) != nums[i]) {
        if (s.contains(target - nums[i])) {
          res.add(Arrays.asList(target - nums[i], nums[i]));
        }
      }
      s.add(nums[i]);
    }
    return res;
  }

  public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i : nums1) {
      for (int j : nums2) {
        map.put(i + j, map.getOrDefault(i + j, 0) + 1);
      }
    }
    int count = 0;
    for (int k : nums3) {
      for (int l : nums4) {
        count += map.getOrDefault(-(k + l), 0);
      }
    }
    return count;
  }

}
