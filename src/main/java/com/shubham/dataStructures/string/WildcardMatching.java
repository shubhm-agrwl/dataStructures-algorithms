package com.shubham.dataStructures.string;

  /*
  Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

  '?' Matches any single character.
  '*' Matches any sequence of characters (including the empty sequence).

  The matching should cover the entire input string (not partial).

  Note:

      s could be empty and contains only lowercase letters a-z.
      p could be empty and contains only lowercase letters a-z, and characters like ? or *.

  Example 1:

  Input:
  s = "aa"
  p = "a"
  Output: false
  Explanation: "a" does not match the entire string "aa".

  Example 2:

  Input:
  s = "aa"
  p = "*"
  Output: true
  Explanation: '*' matches any sequence.

  Example 3:

  Input:
  s = "cb"
  p = "?a"
  Output: false
  Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

  Example 4:

  Input:
  s = "adceb"
  p = "*a*b"
  Output: true
  Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".

  Example 5:

  Input:
  s = "acdcb"
  p = "a*c?b"
  Output: false

  */

import java.util.Arrays;

public class WildcardMatching {

  public static void main(String[] args) {
    System.out.println(isMatch("acdcb", "*a*b"));
  }

  private static boolean isMatchOld(String s, String p) {

    if (p.length() == 0) {
      return (s.length() == 0);
    }

    // lookup table for storing results of
    // subproblems
    boolean[][] lookup = new boolean[s.length() + 1][p.length() + 1];

    // initailze lookup table to false
    for (int i = 0; i < s.length() + 1; i++) {
      Arrays.fill(lookup[i], false);
    }

    // empty pattern can match with empty string
    lookup[0][0] = true;

    // Only '*' can match with empty string
    for (int j = 1; j <= p.length(); j++) {
      if (p.charAt(j - 1) == '*') {
        lookup[0][j] = lookup[0][j - 1];
      }
    }

    // fill the table in bottom-up fashion
    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= p.length(); j++) {
        // Two cases if we see a '*'
        // a) We ignore '*'' character and move
        //    to next  character in the pattern,
        //     i.e., '*' indicates an empty sequence.
        // b) '*' character matches with ith
        //     character in input
        if (p.charAt(j - 1) == '*') {
          lookup[i][j] = lookup[i][j - 1] ||
              lookup[i - 1][j];
        }

        // Current characters are considered as
        // matching in two cases
        // (a) current character of pattern is '?'
        // (b) characters actually match
        else if (p.charAt(j - 1) == '?' ||
            s.charAt(i - 1) == p.charAt(j - 1)) {
          lookup[i][j] = lookup[i - 1][j - 1];
        }

        // If characters don't match
        else {
          lookup[i][j] = false;
        }
      }
    }

    return lookup[s.length()][p.length()];
  }


  public static boolean isMatch(String s, String p) {
    int sLen = s.length(), pLen = p.length();
    int sIdx = 0, pIdx = 0;
    int starIdx = -1, sTmpIdx = -1;

    while (sIdx < sLen) {
      // If the pattern caracter = string character
      // or pattern character = '?'
      if (pIdx < pLen && (p.charAt(pIdx) == '?' || p.charAt(pIdx) == s.charAt(sIdx))){
        ++sIdx;
        ++pIdx;
      }
      // If pattern character = '*'
      else if (pIdx < pLen && p.charAt(pIdx) == '*') {
        // Check the situation
        // when '*' matches no characters
        starIdx = pIdx;
        sTmpIdx = sIdx;
        ++pIdx;
      }
      // If pattern character != string character
      // or pattern is used up
      // and there was no '*' character in pattern
      else if (starIdx == -1) {
        return false;
      }
      // If pattern character != string character
      // or pattern is used up
      // and there was '*' character in pattern before
      else {
        // Backtrack: check the situation
        // when '*' matches one more character
        pIdx = starIdx + 1;
        sIdx = sTmpIdx + 1;
        sTmpIdx = sIdx;
      }
    }

    // The remaining characters in the pattern should all be '*' characters
    for(int i = pIdx; i < pLen; i++)
      if (p.charAt(i) != '*') return false;
    return true;
  }

}
