package com.shubham.dataStructures.array;

  /*
  You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

  Example 1:

  Input: [1,1,2,3,3,4,4,8,8]
  Output: 2

  Example 2:

  Input: [3,3,7,7,10,11,11]
  Output: 10

  Note: Your solution should run in O(log n) time and O(1) space.
 */

public class SingleElementInSortedArray {

  public static void main(String[] args) {

    System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));

  }

  private static int singleNonDuplicate(int[] nums) {

    return search(nums, 0, nums.length - 1);
  }

  private static int search(int[] arr, int low, int high) {
    if (low > high) {
      return -1;
    }
    if (low == high) {
      return arr[low];
    }

    // Find the middle point
    int mid = (low + high) / 2;

    // If mid is even and element next to mid is
    // same as mid, then output element lies on
    // right side, else on left side
    if (mid % 2 == 0) {
      if (arr[mid] == arr[mid + 1]) {
        return search(arr, mid + 2, high);
      } else {
        return search(arr, low, mid);
      }
    } else {
      if (arr[mid] == arr[mid - 1]) {
        return search(arr, mid + 1, high);
      } else {
        return search(arr, low, mid - 1);
      }
    }
  }

}
