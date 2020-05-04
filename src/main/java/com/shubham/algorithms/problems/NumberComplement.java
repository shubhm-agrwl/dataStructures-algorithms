package com.shubham.algorithms.problems;

  /*
  Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.

  Example 1:

  Input: 5
  Output: 2
  Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.

  Example 2:

  Input: 1
  Output: 0
  Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
   */

public class NumberComplement {

  public static void main(String[] args) {
    System.out.println(findComplement(1));
  }

  private static int findComplement(int num) {
    // Find number of bits in the
    // given integer
    int numberOfBits =
        (int) (Math.floor(Math.log(num) /
            Math.log(2))) + 1;

    // XOR the given integer with poe(2,
    // numberOfBits-1 and print the result
    return ((1 << numberOfBits) - 1) ^ num;
  }

}
