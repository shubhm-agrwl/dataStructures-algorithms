package com.shubham.dataStructures.array;

import java.util.HashMap;

public class LargestSubArrayEqual01 {

  public static void main(String[] args) {
    int arr[] = {1, 1, 1};
    int size = arr.length;

    System.out.println(maxLen(arr, size));
  }

  private static int maxLen(int[] arr, int N) {
    HashMap<Integer, Integer> hM
        = new HashMap<Integer, Integer>();

    // Initialize sum of elements
    int sum = 0;

    // Initialize result
    int max_len = 0;
    int ending_index = -1;
    int start_index = 0;

    for (int i = 0; i < N; i++) {
      arr[i] = (arr[i] == 0) ? -1 : 1;
    }

    // Traverse through the given array

    for (int i = 0; i < N; i++) {
      // Add current element to sum

      sum += arr[i];

      // To handle sum=0 at last index

      if (sum == 0) {
        max_len = i + 1;
        ending_index = i;
      }

      // If this sum is seen before,
      // then update max_len if required
      if (hM.containsKey(sum + N)) {
        if (max_len < i - hM.get(sum + N)) {
          max_len = i - hM.get(sum + N);
          ending_index = i;
        }
      } else // Else put this sum in hash table
      {
        hM.put(sum + N, i);
      }
    }

    for (int i = 0; i < N; i++) {
      arr[i] = (arr[i] == -1) ? 0 : 1;
    }

    int end = ending_index - max_len + 1;
    System.out.println(end + " to " + ending_index);

    return max_len;
  }

}
