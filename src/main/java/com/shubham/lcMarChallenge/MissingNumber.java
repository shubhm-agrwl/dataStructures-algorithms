package com.shubham.lcMarChallenge;

public class MissingNumber {

  public int missingNumber(int[] nums) {
    int total = (nums.length*(nums.length+1))/2;
    int sum =0;
    for (int i=0;i<nums.length;i++){
      sum += nums[i];
    }
    return total -sum;
  }

  public int missingNumberXOR(int[] nums) {
    int missing = nums.length;
    for (int i = 0; i < nums.length; i++) {
      missing ^= i ^ nums[i];
    }
    return missing;
  }

}
