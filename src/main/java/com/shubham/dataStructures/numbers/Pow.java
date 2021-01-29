package com.shubham.dataStructures.numbers;

public class Pow {

  public static void main(String[] args) {
    System.out.println(myPow(34.00515, -3));
  }

  public static double myPow(double x, int n) {
    if (n == 0) {
      return 1;
    }

    if (n < 0) {
      x = 1 / x;
      n = Math.abs(n);
    }

    if (n % 2 == 0) {
      return myPow(x, n / 2) * myPow(x, n / 2);
    } else {
      return x * myPow(x, n / 2) * myPow(x, n / 2);

    }

//    if (n < 0) {
//      x = 1 / x;
//      n = Math.abs(n);
//    }
//
//    double res = 1;
//
//    for (int i = 1; i <= n; i++) {
//      res = res * x;
//    }
//
//    return res;

  }

}
