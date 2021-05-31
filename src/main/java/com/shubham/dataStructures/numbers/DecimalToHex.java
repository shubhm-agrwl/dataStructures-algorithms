package com.shubham.dataStructures.numbers;

public class DecimalToHex {

  private static char[] table = new char[]{'0', '1', '2', '3', '4', '5', '6', '7',
      '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

  public static void main(String[] args) {
    System.out.println(toHex(26));
  }

  public static String toHex(int num) {
    if (num == 0) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    for (; num != 0; num >>>= 4) {
      sb.append(table[num & 0xf]);
    }
    return sb.reverse().toString();
  }

}
