package com.shubham.dataStructures.array;

  /*
  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

  Example:

  Input: [0,1,0,3,12]
  Output: [1,3,12,0,0]

  Note:
      You must do this in-place without making a copy of the array.
      Minimize the total number of operations.
 */

public class MoveZeroes {

  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 3, 12};
    moveZeroes(nums);
  }

  private static void moveZeroes(int[] nums) {
    int i = 0;
    int j = 0;
    while (i < nums.length && j < nums.length) {
      while (j < nums.length && nums[j] == 0) {
        j++;
      }
      if (nums[i] == 0 && j < nums.length) {
        nums[i] = nums[j];
        nums[j] = 0;
      }
      i++;
      j++;
    }

    for (int num : nums) {
      System.out.println(num);
    }
  }

}
