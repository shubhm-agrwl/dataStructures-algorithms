package com.shubham.dataStructures.numbers;

public class Numberof1Bits {

  public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
      sum++;
      n &= (n - 1);
    }
    return sum;
  }

}
