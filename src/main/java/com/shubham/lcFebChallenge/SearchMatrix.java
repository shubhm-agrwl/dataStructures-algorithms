package com.shubham.lcFebChallenge;

public class SearchMatrix {

  public boolean searchMatrix(int[][] matrix, int target) {

    int row = matrix.length;
    int col = matrix[0].length;

    int i = 0;
    int j = col - 1;
    while (i < row && j >= 0) {
      if (matrix[i][j] == target) {
        return true;
      } else if (matrix[i][j] < target) {
        i++; //everything in the previous row will be lesser so increment row pointer
      } else {
        j--;    //everything from the column will be greater so decrement the column pointer
      }
    }
    return false;
  }

}
