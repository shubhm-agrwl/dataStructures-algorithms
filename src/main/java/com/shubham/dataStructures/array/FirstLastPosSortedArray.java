package com.shubham.dataStructures.array;

public class FirstLastPosSortedArray {

  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    int pos = binarySearch(nums, 0, nums.length - 1, target);
    if (pos == -1) {
      res[0] = -1;
      res[1] = -1;
      return res;
    } else {
      int checkBefore = pos;
      while (checkBefore > 0) {
        if (nums[checkBefore - 1] == target) {
          checkBefore--;
        } else {
          break;
        }
      }
      res[0] = checkBefore;
      int checkAfter = pos;

      while (checkAfter < nums.length - 1) {
        if (nums[checkAfter + 1] == target) {
          checkAfter++;
        } else {
          break;
        }
      }
      res[1] = checkAfter;

      return res;
    }
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
