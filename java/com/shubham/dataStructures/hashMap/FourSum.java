package com.shubham.dataStructures.hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

  public static void FourSumMain() {
    int[] nums = {-4, -3, -2, -1, 0, 0, 1, 2, 3, 4};
    System.out.println(fourSum(nums, 0));
  }

  private static List<List<Integer>> fourSum(int[] nums, int target) {

    Arrays.sort(nums);
    int n = nums.length;
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    TreeSet<String> set = new TreeSet<String>();

    // Store sums of all pairs in a hash table
    HashMap<Integer, pair> mp = new HashMap<Integer, pair>();
    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++)
        mp.put(nums[i] + nums[j], new pair(i, j));

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
              List<Integer> r = new ArrayList<Integer>();
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

  static class pair {
    int first, second;

    public pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }

}
