package com.shubham.algorithms.problems;

  /*
  Given a positive integer num, write a function which returns True if num is a perfect square else False.

  Note: Do not use any built-in library function such as sqrt.

  Example 1:

  Input: 16
  Output: true

  Example 2:

  Input: 14
  Output: false
 */

public class ValidPerfectSquare {

  public static void main(String[] args) {
    System.out.println(isPerfectSquare(2147483647));
  }

  private static boolean isPerfectSquare(int n) {
    for (int i = 1; i * i <= n; i++) {

      // If (i * i = n)
      if ((n % i == 0) && (n / i == i)) {
        return true;
      }
      if ((i + 1) * (i + 1) == 0) {
        return false;
      }
    }
    return false;
  }

  // This function returns true if n
  // is perfect square, else false
  static boolean isPerfectSquare2(int n) {
    // sum is sum of all odd numbers. i is
    // used one by one hold odd numbers
    for (int sum = 0, i = 1; sum < n; i += 2) {
      sum += i;
      if (sum == n) {
        return true;
      }
    }
    return false;
  }

}
