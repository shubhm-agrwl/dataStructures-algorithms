package com.shubham.dataStructures.string;

public class ImplementStrStr {

  public static void main(String[] args) {

  }

  public int strStr(String haystack, String needle) {
    if (needle.isEmpty()) {
      return 0;
    }
    return haystack.indexOf(needle);
  }

  public int strStr2(String haystack, String needle) {
    if (needle.length() == 0) {
      return 0;
    }
    if (haystack.length() == needle.length() && haystack.equals(needle)) {
      return 0;
    }
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      if (haystack.substring(i, i + needle.length()).equals(needle)) {
        return i;
      }
    }

    return -1;
  }
}
