package com.shubham.dataStructures.array;

  /*
  You are given an array A, of N elements. You need to find minimum distance between given two integers x and y.

  Distance: The distance (index-based) between two elements of the array.

  Input Format:
  The first line of input contains an integer T, denoting the number of test cases. Then T test cases follow. Each test case consists of three lines. The first line of each test case contains an integer N denoting size array. Then in the next line are N space separated values of the array A. The last line of each test case contains two integers  x and y.

  Output Format:
  For each test case, print the required answer .

  Your Task:
  Your task is to complete the function minDist which returns  an integer denoting the minimum distance between two integers x and y in the array. If no such distance is possible then return -1.
  Expected Time Complexity: O(N).
  Expected Auxiliary Space: O(1).

  Constraints:
  1 <= T <= 100
  1 <= N <= 105
  0 <= A, x, y <= 105

  Example:
  Input:
  2
  4
  1 2 3 2
  1 2
  7
  86 39 90 67 84 66 62
  42 12
  Output:
  1
  -1
 */

public class MinimumDistance {

  public static void main(String[] args) {
//    System.out.println(minDist(new long[]{1L, 2L, 3L, 2L}, 4, 1, 2));
    System.out.println(minDist(
        new long[]{96L, 82L, 48L, 76L, 34L, 19L, 7L, 80L, 36L, 57L, 77L, 34L, 19L, 35L, 5L, 57L,
            16L, 66L, 42L, 62L, 89L, 19L, 60L, 19L, 25L, 16L, 20L, 51L, 77L, 75L, 12L, 73L, 8L, 11L,
            100L, 93L, 81L, 58L, 72L, 17L, 14L, 48L, 2L, 33L, 82L, 6L, 41L, 49L, 72L, 34L, 10L, 12L,
            53L, 21L, 30L, 77L, 36L, 49L, 79L, 13L, 75L, 42L}, 62, 36, 33));
  }

  private static long minDist(long arr[], long n, long x, long y) {
    long dist = Long.MAX_VALUE, prev = Long.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (arr[i] == x || arr[i] == y) {
        if (prev != Long.MIN_VALUE && arr[i] != arr[(int) prev]) {
          dist = Math.min(dist, i - prev);
        }
        prev = i;
      }
    }
    if (dist != Long.MAX_VALUE) {
      return dist;
    }
    return -1;
  }
}
