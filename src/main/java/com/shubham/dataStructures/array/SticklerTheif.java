package com.shubham.dataStructures.array;

public class SticklerTheif {

  public static void main(String[] args) {

  }

  private static int FindMaxSum(int arr[], int n) {
    // Your code here
    if (n == 0) {
      return 0;
    }

    int value1 = arr[0];
    if (n == 1) {
      return value1;
    }

    int value2 = Math.max(arr[0], arr[1]);
    if (n == 2) {
      return value2;
    }

    // contains maximum stolen value at the end
    int max_val = 0;

    // Fill remaining positions
    for (int i = 2; i < n; i++) {
      max_val = Math.max(arr[i] + value1, value2);
      value1 = value2;
      value2 = max_val;
    }

    return max_val;
  }

}
