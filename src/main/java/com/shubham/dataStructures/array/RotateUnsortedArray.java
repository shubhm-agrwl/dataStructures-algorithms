package com.shubham.dataStructures.array;

  /*
  Given an unsorted array arr[] of size N, rotate it by D elements in the counter-clockwise direction.

  Input:
  The first line of the input contains T denoting the number of test cases. The first line of each test case contains two space-separated elements, N denoting the size of the array and an integer D denoting the number size of the rotation. The subsequent line will contain N space-separated array elements.

  Output:
  For each test case, in a new line, print the rotated array.

  Your Task:
  Complete the function rotateArr() which takes the array, D and N as input parameters and rotates the array by D elements.

  Expected Time Complexity: O(N).
  Expected Auxiliary Space: O(1).

  Constraints:
  1 <= T <= 200
  1 <= N <= 107
  1 <= D <= N
  0 <= arr[i] <= 105

  Example:
  Input:
  2
  5 2
  1 2 3 4 5
  10 3
  2 4 6 8 10 12 14 16 18 20

  Output:
  3 4 5 1 2
  8 10 12 14 16 18 20 2 4 6
 */

public class RotateUnsortedArray {

  public static void main(String[] args) {
    rotateArr(new int[]{1, 2, 3, 4, 5}, 2, 5);
  }

  private static void rotateArr(int arr[], int d, int n) {
    d = d % n;
    int i, j, k, temp;
    int g_c_d = gcd(d, n);
    for (i = 0; i < g_c_d; i++) {
      /* move i-th values of blocks */
      temp = arr[i];
      j = i;
      while (true) {
        k = j + d;
        if (k >= n) {
          k = k - n;
        }
        if (k == i) {
          break;
        }
        arr[j] = arr[k];
        j = k;
      }
      arr[j] = temp;
    }
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return gcd(b, a % b);
    }
  }
}
