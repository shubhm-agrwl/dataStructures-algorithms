package com.shubham.dataStructures.numbers;

public class ValidNumber {

  public boolean isNumber(String s) {
    int i = 0, n = s.length();

    while (i < n && s.charAt(i) == ' ') {
      i++;
    }

    if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
      i++;
    }

    boolean isNumeric = false;
    while (i < n && Character.isDigit(s.charAt(i))) {
      ++i;
      isNumeric = true;
    }

    if (i < n && s.charAt(i) == '.') {
      i++;
      while (i < n && Character.isDigit(s.charAt(i))) {
        ++i;
        isNumeric = true;
      }
    }

    if (i < n && isNumeric && (s.charAt(i) == 'E' || s.charAt(i) == 'e')) {
      ++i;
      isNumeric = false;
      if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
        i++;
      }
      while (i < n && Character.isDigit(s.charAt(i))) {
        ++i;
        isNumeric = true;
      }

    }

    while (i < n && s.charAt(i) == ' ') {
      i++;
    }
    return isNumeric && i == n;
  }

}
