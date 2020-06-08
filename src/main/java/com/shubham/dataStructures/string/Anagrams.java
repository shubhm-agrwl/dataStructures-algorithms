package com.shubham.dataStructures.string;

  /*
  Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

  Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

  The order of output does not matter.

  Example 1:

  Input:
  s: "cbaebabacd" p: "abc"

  Output:
  [0, 6]

  Explanation:
  The substring with start index = 0 is "cba", which is an anagram of "abc".
  The substring with start index = 6 is "bac", which is an anagram of "abc".

  Example 2:

  Input:
  s: "abab" p: "ab"

  Output:
  [0, 1, 2]

  Explanation:
  The substring with start index = 0 is "ab", which is an anagram of "ab".
  The substring with start index = 1 is "ba", which is an anagram of "ab".
  The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

import java.util.ArrayList;
import java.util.List;

public class Anagrams {

  static final int MAX = 256;

  public static void main(String[] args) {
    String txt = "BACDGABCDA";
    String pat = "ABCD";
    for (int i : findAnagrams(txt, pat)) {
      System.out.println(i);
    }
  }

  private static List<Integer> findAnagrams(String s, String p) {
    int M = p.length();
    int N = s.length();

    List<Integer> integerList = new ArrayList<>();
    if (N < M) {
      return integerList;
    }
    // countP[]:  Store count of all
    // characters of pattern
    // countTW[]: Store count of current
    // window of text
    char[] countP = new char[MAX];
    char[] countTW = new char[MAX];
    for (int i = 0; i < M; i++) {
      (countP[p.charAt(i)])++;
      (countTW[s.charAt(i)])++;
    }

    // Traverse through remaining characters
    // of pattern
    for (int i = M; i < N; i++) {
      // Compare counts of current window
      // of text with counts of pattern[]
      if (compare(countP, countTW)) {
        System.out.println("Found at Index " +
            (i - M));
        integerList.add(i - M);
      }

      // Add current character to current
      // window
      (countTW[s.charAt(i)])++;

      // Remove the first character of previous
      // window
      countTW[s.charAt(i - M)]--;
    }

    // Check for the last window in text
    if (compare(countP, countTW)) {
      System.out.println("Found at Index " +
          (N - M));
      integerList.add(N - M);
    }
    return integerList;
  }

  static boolean compare(char arr1[], char arr2[]) {
    for (int i = 0; i < MAX; i++) {
      if (arr1[i] != arr2[i]) {
        return false;
      }
    }
    return true;
  }
}
