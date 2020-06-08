package com.shubham.dataStructures.array;

  /*
  Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

  Example 1:

  Input: matrix =
  [
    [0,1,1,1],
    [1,1,1,1],
    [0,1,1,1]
  ]
  Output: 15
  Explanation:
  There are 10 squares of side 1.
  There are 4 squares of side 2.
  There is  1 square of side 3.
  Total number of squares = 10 + 4 + 1 = 15.

  Example 2:

  Input: matrix =
  [
    [1,0,1],
    [1,1,0],
    [1,1,0]
  ]
  Output: 7
  Explanation:
  There are 6 squares of side 1.
  There is 1 square of side 2.
  Total number of squares = 6 + 1 = 7.

  */

import java.util.Stack;

public class CountSquareSubmatrices {

  public static void main(String[] args) {
    System.out.println(countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}}));
  }

  private static int countSquares(int[][] matrix) {
// Array to store required prefix count of
    // 1s from right to left for boolean array
    int[][] p_arr = new int[matrix.length][matrix.length];

    findPrefixCount(p_arr, matrix);

    // variable to store the final answer
    int ans = 0;

    /* Loop to evaluate each column of
        the prefix matrix uniquely.
        For each index of a column we will try to
        determine the number of sub-matrices
        starting from that index
        and has all 1s */
    for (int j = 0; j < matrix.length; j++) {
      int i = matrix.length - 1;

        /* Stack to store elements and the count
            of the numbers they popped

            First part of pair will be the
            value of inserted element.
            Second part will be the count
            of the number of elements pushed
            before with a greater value */
      Stack<pair> q = new Stack<pair>();

      // variable to store the number of
      // submatrices with all 1s
      int to_sum = 0;

      while (i >= 0) {
        int c = 0;

        while (q.size() != 0 &&
            q.peek().first > p_arr[i][j]) {
          to_sum -= (q.peek().second + 1) *
              (q.peek().first - p_arr[i][j]);

          c += q.peek().second + 1;
          q.pop();
        }

        to_sum += p_arr[i][j];

        ans += to_sum;

        q.add(new pair(p_arr[i][j], c));

        i--;
      }
    }
    return ans;
  }

  // Function to find required prefix-count for
// each row from right to left
  static void findPrefixCount(int p_arr[][],
      int arr[][]) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = arr.length - 1; j >= 0; j--) {
        if (arr[i][j] == 0) {
          continue;
        }

        if (j != arr.length - 1) {
          p_arr[i][j] += p_arr[i][j + 1];
        }

        p_arr[i][j] += arr[i][j] == 1 ? 1 : 0;
      }
    }
  }

  static class pair {

    int first, second;

    public pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}
