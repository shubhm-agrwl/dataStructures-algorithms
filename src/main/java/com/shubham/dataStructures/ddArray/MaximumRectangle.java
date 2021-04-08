package com.shubham.dataStructures.ddArray;

import com.shubham.dataStructures.array.LargestRectangle;

public class MaximumRectangle {

  public int maximalRectangle(char[][] matrix) {
    if (matrix.length == 0) {
      return 0;
    }

    int arr[] = new int[matrix[0].length];

    int overall = Integer.MIN_VALUE;

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          arr[j] += 1;
        } else {
          arr[j] = 0;
        }
      }
      int ans = LargestRectangle.largestRectangleArea(arr);
      overall = Math.max(overall, ans);
    }
    return overall;
  }

}
