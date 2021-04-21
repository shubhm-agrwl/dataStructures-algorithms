package com.shubham.dataStructures.array;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

  /*
  Given a non-empty array of integers, every element appears twice except for one. Find that single one.

  Note:

  Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

  Example 1:

  Input: [2,2,1]
  Output: 1

  Example 2:

  Input: [4,1,2,1,2]
  Output: 4
   */

  public static void main(String[] args) {
    int nums[] = {2, 2, 1};
    System.out.println(singleNumber(nums));
  }

  private static int singleNumber(int[] nums) {
    int res = nums[0];
    for (int i = 1; i < nums.length; i++) {
      res = res ^ nums[i];
    }
    return res;
  }

  public int singleNumber2(int[] nums) {

    int seen_once = 0, seen_twice = 0;

        /*
        Assume there are 3 x's
        Let's say we have a variable, seen_twice s.t. if count==2 seen_twice = x and 0 for count == 1
        If we have such a property then we already get a mod 3 logic by using XOR gates.
        But if we have plain XOR then it will be mod 2 logic not mod 3. To create this mod 3 logic we
        use another variable seen_once s.t. seen_once = x when count == 1
        Notice that in row 1 and row 2 when we have x the other should be 0.
        We implement this in logic as (~x) & x = 0
        +-------+-----------+------------+
        | count | seen_once | seen_twice |
        +-------+-----------+------------+
        |   0   |     0     |      0     |
        +-------+-----------+------------+
        |   1   |     x     |      0     |
        +-------+-----------+------------+
        |   2   |     0     |      x     |
        +-------+-----------+------------+
        |   3   |     0     |      0     |
        +-------+-----------+------------+
        */

    for (int n : nums) {
      seen_once = (~seen_twice) & (seen_once ^ n);
      seen_twice = (~seen_once) & (seen_twice ^ n);
    }

    return seen_once;

  }

  public int[] singleNumber3(int[] nums) {
    Set<Integer> res = new HashSet<>();
    for (int num : nums) {
      if (res.contains(num)) {
        res.remove(num);
      } else {
        res.add(num);
      }
    }

    int arr[] = new int[res.size()];
    int i = 0;
    for (int r : res) {
      arr[i] = r;
      i++;
    }
    return arr;
  }

}
