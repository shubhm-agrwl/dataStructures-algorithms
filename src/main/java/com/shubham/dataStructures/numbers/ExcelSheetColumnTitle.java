package com.shubham.dataStructures.numbers;

public class ExcelSheetColumnTitle {

  public String convertToTitle(int n) {
    String result = "";
    int rem;

    while (n > 0) {
      n--; // **this is the mathematical trickery which solves the problem of getting remainder 0 when dividing by 26**
      rem = n % 26; // get remainder
      n = (int) Math.floor(n / 26); // get new n for next division
      result = (char) (rem + 65)
          + result; // add to the string in reverse sequence basically; find ascii for 65 not 64 (to compensate for the n-- earlier)

    }
    return result;
  }

  public int titleToNumber(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }

    int position = s.length() - 1;
    int firstCharPos = s.charAt(0) - 'A' + 1;

    return firstCharPos * ((int) Math.pow(26, position)) + titleToNumber(s.substring(1));
  }

}
