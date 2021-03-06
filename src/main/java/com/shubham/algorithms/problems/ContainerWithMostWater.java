package com.shubham.algorithms.problems;

public class ContainerWithMostWater {

  /*
   * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i,
   * ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
   * Find two lines, which together with x-axis forms a container, such that the container contains
   * the most water.
   *
   * Note: You may not slant the container and n is at least 2.
   *
   * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max
   * area of water (blue section) the container can contain is 49.
   *
   * Example:
   *
   * Input: [1,8,6,2,5,4,8,3,7] Output: 49
   */

  public static void main(String[] args) {
    int nums[] = {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(nums));
  }

  private static int maxArea(int[] height) {
    int maxarea = 0, l = 0, r = height.length - 1;
    while (l < r) {
      maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
      if (height[l] < height[r]) {
        l++;
      } else {
        r--;
      }
    }
    return maxarea;
  }

  public static int maxAreaBruteForce(int[] height) {
    int maxarea = 0;
    for (int i = 0; i < height.length; i++) {
      for (int j = i + 1; j < height.length; j++) {
        maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
      }
    }
    return maxarea;
  }

}
