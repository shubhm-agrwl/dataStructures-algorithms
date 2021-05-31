package com.shubham.dataStructures.numbers;

public class SumOf2Integers {

  public int getSum(int a, int b) {
    // carry !=0
    // using half adder logic
    while (b != 0) {
      int carry = a & b; // by doing And operation get the carry
      a = a ^ b; // XOR will give the sum [ excluding any carry ]
      carry <<= 1; // left shift 1
      b = carry; //  so that it can be added to next significant bit
    }
    return a;
  }

}
