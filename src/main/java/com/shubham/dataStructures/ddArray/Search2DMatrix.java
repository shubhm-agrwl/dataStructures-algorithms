package com.shubham.dataStructures.ddArray;

public class Search2DMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    for (int i = 0; i < m; i++) {
      if (matrix[i][0] > target) {
        continue;
      }
      int low = 0;
      int high = n - 1;

      while (low <= high) {
        int mid = (high + low) / 2;
        if (matrix[i][mid] == target) {
          return true;
        }
        if (matrix[i][mid] > target) {
          high = mid - 1;
        }
        if (matrix[i][mid] < target) {
          low = mid + 1;
        }
      }
    }
    return false;
  }
}

