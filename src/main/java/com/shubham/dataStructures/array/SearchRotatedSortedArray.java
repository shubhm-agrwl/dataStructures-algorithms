package com.shubham.dataStructures.array;

  /*
  Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

  (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

  You are given a target value to search. If found in the array return its index, otherwise return -1.

  You may assume no duplicate exists in the array.

  Your algorithm's runtime complexity must be in the order of O(log n).

  Example 1:

  Input: nums = [4,5,6,7,0,1,2], target = 0
  Output: 4

  Example 2:

  Input: nums = [4,5,6,7,0,1,2], target = 3
  Output: -1

 */

public class SearchRotatedSortedArray {

  public static void SearchRotatedSortedArrayMain() {

    //int[] nums = {4, 5, 6, 7, 0, 1, 2};
    int[] nums = {1, 3};
    System.out.println(search(nums, 3));

  }

  public static int search(int[] nums, int target) {

    int pivot = findPivot(nums, 0, nums.length - 1);

    // If we didn't find a pivot, then
    // array is not rotated at all
    if (pivot == -1) {
      return binarySearch(nums, 0, nums.length - 1, target);
    }

    // If we found a pivot, then first
    // compare with pivot and then
    // search in two subarrays around pivot
    if (nums[pivot] == target) {
      return pivot;
    }
    if (nums[0] <= target) {
      return binarySearch(nums, 0, pivot - 1, target);
    }
    return binarySearch(nums, pivot + 1, nums.length - 1, target);
  }

  private static int findPivot(int[] nums, int low, int high) {
    if (high < low) {
      return -1;
    }
    if (high == low) {
      return low;
    }

    /* low + (high - low)/2; */
    int mid = (low + high) / 2;
    if (mid < high && nums[mid] > nums[mid + 1]) {
      return mid;
    }
    if (mid > low && nums[mid] < nums[mid - 1]) {
      return (mid - 1);
    }
    if (nums[low] >= nums[mid]) {
      return findPivot(nums, low, mid - 1);
    }
    return findPivot(nums, mid + 1, high);
  }

  private static int binarySearch(int arr[], int low, int high, int key) {
    if (high < low) {
      return -1;
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
