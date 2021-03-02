package com.shubham.dataStructures.numbers;

public class FactorialTrailingZeros {

  public int trailingZeroes(int n) {
    int res = 0;
    int f = 1;
    while (Math.pow(5, f) < n) {
      res = res + (int) (n / Math.pow(5, f));
      f++;
    }
    return res;
  }

}
