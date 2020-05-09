package com.shubham.algorithms.problems;

  /*
  Given n non-negative integers representing an elevation map where the width of each bar is 1,
  compute how much water it is able to trap after raining.

  Example:

  Input: [0,1,0,2,1,0,1,3,2,1,2,1]
  Output: 6
 */

public class TrappingRainWater {

  public static void main(String[] args) {
    int nums[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    System.out.println(trap(nums));

  }

  private static int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int ans = 0;
    int leftMax = 0, rightMax = 0;
    while (left < right) {
      if (height[left] < height[right]) {
        if (height[left] >= leftMax) {
          leftMax = height[left];
        } else {
          ans += leftMax - height[left];
        }
        ++left;
      } else {
        if (height[right] >= rightMax) {
          rightMax = height[right];
        } else {
          ans += rightMax - height[right];
        }
        --right;
      }
    }
    return ans;
  }

}
