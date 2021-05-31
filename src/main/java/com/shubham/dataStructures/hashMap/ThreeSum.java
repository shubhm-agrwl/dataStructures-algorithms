package com.shubham.dataStructures.hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ThreeSum {

  /*
   * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
   * Find all unique triplets in the array which gives the sum of zero.
   *
   * Note:
   *
   * The solution set must not contain duplicate triplets.
   *
   * Example:
   *
   * Given array nums = [-1, 0, 1, 2, -1, -4],
   *
   * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
   *
   */

  public static void main(String[] args) {
    int[] nums = {-1, 0, 1, 2, -1, -4};
    System.out.println(threeSumUnique(nums));
  }

  private static List<List<Integer>> threeSumNotUnique(int[] nums) {

    List<List<Integer>> res = new ArrayList<>();
    TreeSet<String> ss = new TreeSet<>();
    for (int i = 0; i < nums.length - 1; i++) {

      HashSet<Integer> s = new HashSet<>();
      for (int j = i + 1; j < nums.length; j++) {
        int x = -(nums[i] + nums[j]);
        if (s.contains(x)) {
          String str = nums[i] + ":" + nums[j] + ":" + x;
          if (!ss.contains(str)) {
            List<Integer> r = new ArrayList<>();
            r.add(nums[i]);
            r.add(nums[j]);
            r.add(x);
            res.add(r);
            ss.add(str);
          }
        } else {
          s.add(nums[j]);
        }
      }
    }
    return res;
  }

  private static List<List<Integer>> threeSumUnique(int[] nums) {
    /* Sort the elements */
    Arrays.sort(nums);

    List<List<Integer>> pair = new ArrayList<>();
    TreeSet<String> set = new TreeSet<>();
    List<Integer> triplets = new ArrayList<>();

    /*
     * Iterate over the array from the start and consider it as the first element
     */
    for (int i = 0; i < nums.length - 2; i++) {

      // index of the first element in the
      // remaining elements
      int j = i + 1;

      // index of the last element
      int k = nums.length - 1;

      while (j < k) {

        if (nums[i] + nums[j] + nums[k] == 0) {

          String str = nums[i] + ":" + nums[j] + ":" + nums[k];

          if (!set.contains(str)) {

            // To check for the unique triplet
            triplets.add(nums[i]);
            triplets.add(nums[j]);
            triplets.add(nums[k]);
            pair.add(triplets);
            triplets = new ArrayList<>();
            set.add(str);
          }

          j++; // increment the second value index
          k--; // decrement the third value index

        } else if (nums[i] + nums[j] + nums[k] < 0) {
          j++;
        } else // nums[i] + nums[j] + nums[k] > sum
        {
          k--;
        }
      }
    }
    return pair;
  }

  public List<List<Integer>> threeSum(int[] nums) {
    if (nums.length < 3) {
      return new ArrayList();
    }
    Set<List<Integer>> set = new HashSet<>();
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (sum == 0) {
          set.add(Arrays.asList(nums[i], nums[j++], nums[k--]));
        } else if (sum > 0) {
          k--;
        } else {
          j++;
        }
      }
    }
    return new ArrayList(set);
  }

  public int threeSumClosest(int[] nums, int target) {
    int diff = Integer.MAX_VALUE;
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n - 2; i++) {
      int j = i + 1;
      int k = n - 1;
      while (j < k) {
        int sum = nums[i] + nums[j] + nums[k];
        if (Math.abs(target - sum) < Math.abs(diff)) {
          diff = target - sum;
        }
        if (sum > target) {
          k--;
        } else {
          j++;
        }
      }
    }
    return target - diff;
  }

}
