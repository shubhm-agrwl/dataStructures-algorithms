package com.shubham.dataStructures.ddArray;

public class generateMatrix {

  public int[][] generateMatrix(int n) {
    int counter = 1;
    int[][] matrix = new int[n][n];

    int r1 = 0, r2 = matrix.length - 1;
    int c1 = 0, c2 = matrix[0].length - 1;
    while (r1 <= r2 && c1 <= c2) {
      for (int c = c1; c <= c2; c++) {
        matrix[r1][c] = counter++;
      }
      for (int r = r1 + 1; r <= r2; r++) {
        matrix[r][c2] = counter++;
      }
      if (r1 < r2 && c1 < c2) {
        for (int c = c2 - 1; c > c1; c--) {
          matrix[r2][c] = counter++;
        }
        for (int r = r2; r > r1; r--) {
          matrix[r][c1] = counter++;
        }
      }
      r1++;
      r2--;
      c1++;
      c2--;
    }
    return matrix;
  }

}
