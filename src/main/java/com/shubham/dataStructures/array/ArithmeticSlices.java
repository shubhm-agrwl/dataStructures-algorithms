package com.shubham.dataStructures.array;

public class ArithmeticSlices {

  public static void main(String[] args) {
    System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
  }

  public static int numberOfArithmeticSlices(int[] A) {

    if (A.length < 3) {
      return 0;
    }

    int res = 0, diff = A[1] - A[0];
    int sliceLength = 1;
    for (int i = 2; i < A.length; i++) {
      if (diff == (A[i] - A[i - 1])) {
        sliceLength++;
      } else {
        int k = 2;
        while (sliceLength + 1 - k >= 0) {
          res = res + (sliceLength + 1 - k);
          k++;
        }
        sliceLength = 1;
        diff = A[i] - A[i - 1];
      }
    }
    int k = 2;
    while (sliceLength + 1 - k >= 0) {
      res = res + (sliceLength + 1 - k);
      k++;
    }
    return res;
  }

  public int numberOfArithmeticSlicesDP(int[] A) {

    int[] dp = new int[A.length];
    int sum = 0;
    for (int i = 2; i < dp.length; i++) {
      if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
        dp[i] = 1 + dp[i - 1];
        sum += dp[i];
      }
    }
    return sum;
  }
}
