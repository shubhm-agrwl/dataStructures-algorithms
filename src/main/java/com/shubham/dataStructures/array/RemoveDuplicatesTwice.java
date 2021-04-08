package com.shubham.dataStructures.array;

public class RemoveDuplicatesTwice {

  public int removeDuplicates(int[] nums) {
    int j = 0;
    int f = 1;

    for (int i = 0; i < nums.length; i++) {

      if (i > 0 && nums[i] == nums[i - 1]) {
        f++;
      } else {
        f = 1;
      }

      if (f <= 2) {
        nums[j++] = nums[i];
      }

    }
    return j;
  }

}
