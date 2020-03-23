package com.shubham.dataStructures.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstring {

  public static int lengthOfLongestSubstring(String s) {

    List<Character> currStr = new ArrayList<Character>();
    int max = 0;
    for (int i = 0; i < s.length(); i++) {
      if (currStr.contains(s.charAt(i))) {
        currStr = currStr.subList(currStr.indexOf(s.charAt(i)) + 1, currStr.size());
      }
      currStr.add(s.charAt(i));
      if (currStr.size() > max)
        max = currStr.size();
    }
    return max;
  }

  public int lengthOfLongestSubstringHashMap(String s) {
    int n = s.length(), ans = 0;
    Map<Character, Integer> map = new HashMap<Character, Integer>(); // current index of character
    // try to extend the range [i, j]
    for (int j = 0, i = 0; j < n; j++) {
      if (map.containsKey(s.charAt(j))) {
        i = Math.max(map.get(s.charAt(j)), i);
      }
      ans = Math.max(ans, j - i + 1);
      map.put(s.charAt(j), j + 1);
    }
    return ans;
  }

  public static void longestSubstringMain() {
    /*
     * 
     * Problem 3: Given a string, find the length of the longest substring without repeating
     * characters.
     * 
     * Example 1:
     * 
     * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
     * 
     * Example 2:
     * 
     * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of 1.
     * 
     * Example 3:
     * 
     * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length of 3. Note that
     * the answer must be a substring, "pwke" is a subsequence and not a substring.
     * 
     * 
     */

    /*
     * Sample Inputs dvdf au
     * abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{
     * |}~
     * abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{
     * |}~ abcdefghijklmnopqrstuvwxyzABCD
     */

    System.out.println(LongestSubstring.lengthOfLongestSubstring("pwwkew"));
  }

}
