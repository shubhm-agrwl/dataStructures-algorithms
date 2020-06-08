package com.shubham.dataStructures.array;

  /*
  Given an array of non-negative integers, you are initially positioned at the first index of the array.

  Each element in the array represents your maximum jump length at that position.

  Your goal is to reach the last index in the minimum number of jumps.

  Example:

  Input: [2,3,1,1,4]
  Output: 2
  Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */

public class JumpGame {

  public static void main(String[] args) {

    System.out.println(jump(new int[]{2, 3, 1, 1, 4}));

  }

  private static int jump(int[] nums) {
    if (nums.length <= 1) {
      return 0;
    }

    // Return -1 if not possible to jump
    if (nums[0] == 0) {
      return -1;
    }

    // initialization
    int maxReach = nums[0];
    int step = nums[0];
    int jump = 1;

    // Start traversing array
    for (int i = 1; i < nums.length; i++) {
      // Check if we have reached the end of the array
      if (i == nums.length - 1) {
        return jump;
      }

      // updating maxReach
      maxReach = Math.max(maxReach, i + nums[i]);

      // we use a step to get to the current index
      step--;

      // If no further steps left
      if (step == 0) {
        //  we must have used a jump
        jump++;

        //Check if the current index/position  or lesser index
        // is the maximum reach point from the previous indexes
        if (i >= maxReach) {
          return -1;
        }

        // re-initialize the steps to the amount
        // of steps to reach maxReach from position i.
        step = maxReach - i;
      }
    }

    return -1;
  }
}
