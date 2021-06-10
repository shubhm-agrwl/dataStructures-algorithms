package com.shubham.dataStructures.string;

import java.math.BigInteger;

public class AddBinary {

  public static void main(String[] args) {
    System.out.println(addBinary("1010", "1011"));
    Math.sqrt(32);
  }

  public static String addBinary(String a, String b) {

    int firstStringPointer;
    int secondStringPointer;
    if (a.length() < b.length()) {
      secondStringPointer = a.length();
      firstStringPointer = b.length();
      String tmp = a;
      a = b;
      b = tmp;
    } else {
      firstStringPointer = a.length();
      secondStringPointer = b.length();
    }
    String res = "";
    int carry = 0;

    while (secondStringPointer > 0) {
      switch (b.charAt(secondStringPointer - 1)) {
        case '0':
          if ((a.charAt(firstStringPointer - 1) == '1') && (carry == 1)) {
            res = "0" + res;
            carry = 1;
          } else {
            if ((a.charAt(firstStringPointer - 1) == '1') || (carry == 1)) {
              res = "1" + res;
            } else {
              res = "0" + res;
            }
            carry = 0;
          }
          break;
        case '1':
          if (carry == 1) {
            carry = 1;
            if (a.charAt(firstStringPointer - 1) == '1') {
              res = "1" + res;
            } else {
              res = "0" + res;
            }
          } else {
            if (a.charAt(firstStringPointer - 1) == '1') {
              res = "0" + res;
              carry = 1;
            } else {
              res = "1" + res;
              carry = 0;
            }
          }
          break;
      }
      secondStringPointer--;
      firstStringPointer--;
    }

    while (firstStringPointer > 0) {
      if (carry == 1) {
        if (a.charAt(firstStringPointer - 1) == '1') {
          res = "0" + res;
          carry = 1;
        } else {
          res = "1" + res;
          carry = 0;
        }

      } else {
        res = a.charAt(firstStringPointer - 1) + res;
        carry = 0;
      }
      firstStringPointer--;
    }
    if (carry == 1) {
      return "1" + res;
    }
    return res;
  }

  public String addBinaryLC(String a, String b) {
    BigInteger x = new BigInteger(a, 2);
    BigInteger y = new BigInteger(b, 2);
    BigInteger zero = new BigInteger("0", 2);
    BigInteger carry, answer;
    while (y.compareTo(zero) != 0) {
      answer = x.xor(y);
      carry = x.and(y).shiftLeft(1);
      x = answer;
      y = carry;
    }
    return x.toString(2);
  }

}
