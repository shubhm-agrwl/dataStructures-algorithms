package com.shubham.dataStructures.array;

public class SearchInsertPosition {

  /*
  Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

  You may assume no duplicates in the array.

  Example 1:

  Input: [1,3,5,6], 5
  Output: 2

  Example 2:

  Input: [1,3,5,6], 2
  Output: 1

  Example 3:

  Input: [1,3,5,6], 7
  Output: 4

  Example 4:

  Input: [1,3,5,6], 0
  Output: 0

  */

  public static void main(String[] args) {
    int[] nums = {1, 3, 5, 6};
    System.out.println(searchInsert(nums, 0));
  }

  private static int searchInsert(int[] nums, int target) {
    return binarySearch(nums, 0, nums.length - 1, target);
  }

  private static int binarySearch(int arr[], int low, int high, int key) {
    if (high < low) {
      return low;
    }

    /* low + (high - low)/2; */
    int mid = (low + high) / 2;
    if (key == arr[mid]) {
      return mid;
    }
    if (key > arr[mid]) {
      return binarySearch(arr, (mid + 1), high, key);
    }
    return binarySearch(arr, low, (mid - 1), key);
  }

}
