package com.shubham.dataStructures.string;

  /*
  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

  Examples:

  s = "leetcode"
  return 0.

  s = "loveleetcode",
  return 2.

  Note: You may assume the string contain only lowercase letters.
 */

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

  public static void main(String[] args) {
    System.out.println(firstUniqChar("loveleetcode"));
  }

  private static int firstUniqChar(String s) {

    if (s.isEmpty()) {
      return -1;
    }

    Map<Character, Integer> chars = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (chars.containsKey(s.charAt(i))) {
        chars.put(s.charAt(i), chars.get(s.charAt(i)) + 1);
      } else {
        chars.put(s.charAt(i), 1);
      }
    }

    int index = Integer.MAX_VALUE;
    for (int k = 0; k < s.length(); k++) {
      if (chars.get(s.charAt(k)) == 1) {
        if (index > k) {
          index = k;
        }
      }
    }

    if (index == Integer.MAX_VALUE) {
      return -1;
    }

    return index;
  }

}
