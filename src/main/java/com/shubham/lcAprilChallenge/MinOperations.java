package com.shubham.lcAprilChallenge;

public class MinOperations {

  public static void main(String[] args) {
    System.out.println(minOperations(3));
  }

  public static int minOperations(int n) {
    int arr[] = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i++) {
      arr[i] = 2 * i + 1;
      sum += arr[i];
    }
    int target = sum / n;

    int x = 0;
    int y = n - 1;
    int res = 0;
    while (x < y) {
      while (arr[x] != target && arr[y] != target) {
        arr[x] += 1;
        arr[y] -= 1;
        res++;
      }
      x++;
      y--;
    }
    return res;
  }

  public int minOperationsBetter(int n) {
    if (n % 2 == 1) {
      // n is odd
      n = n / 2;
      return n * (n + 1);
    } else {
      // n is even
      n = n / 2;
      return n * n;
    }
  }

}
