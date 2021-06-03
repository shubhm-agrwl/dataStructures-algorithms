package com.shubham.algorithms.problems;

public class Devide2Integers {

  /*
  Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

  Return the quotient after dividing dividend by divisor.

  The integer division should truncate toward zero.

  Example 1:

  Input: dividend = 10, divisor = 3
  Output: 3

  Example 2:

  Input: dividend = 7, divisor = -3
  Output: -2
   */

  public static void main(String[] args) {
    System.out.println(divide(-2147483648, -1));

  }

  private static int divide(int dividend, int divisor) {

    if (dividend == 0) {
      return 0;
    }

    int quotient = 0;

    int d = Math.abs(divisor);
    int dd = dividend;

    if (dividend > 0) {
      while (dividend > 0) {
        quotient++;
        dividend -= d;
      }
    } else {
      while (dividend < 0) {
        quotient++;
        dividend += d;
      }
    }

    boolean flag = false;
    if ((quotient > Integer.MAX_VALUE) || (quotient < Integer.MIN_VALUE)) {
      flag = true;
    }

    if (((divisor < 0) && (dd < 0)) || ((divisor > 0) && (dd > 0))) {
      if (flag) {
        return Integer.MAX_VALUE;
      }
      if (quotient == Integer.MIN_VALUE) {
        return Integer.MAX_VALUE;
      }
      if (dividend == 0) {
        return quotient;
      }
      return quotient - 1;
    }

    if (flag) {
      return Integer.MIN_VALUE;
    }
    if (dividend == 0) {
      return -quotient;
    }
    return -quotient + 1;

  }

}
