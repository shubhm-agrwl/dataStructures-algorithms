package com.shubham.dataStructures.numbers;

public class Sqrt {

  public int mySqrt(int x) {
    long start = 1, end = x, ans = 0;
    if (x == 0 || x == 1) {
      return x;
    }
    while (start <= end) {
      long m = (start + end) / 2;
      if (m * m == x) {
        return (int) m;
      }
      if (m * m > x) {
        end = m - 1;

      } else {
        start = m + 1;
        ans = m;
      }
    }
    return (int) end;
  }

}
