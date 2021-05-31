package com.shubham.lcWeekly;

public class SummationOfWords {

  public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
    return getIntValue(firstWord) + getIntValue(secondWord) == getIntValue(targetWord);
  }

  private int getIntValue(String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      result = result * 10 + (s.charAt(i) - 'a');
    }
    return result;
  }

}
