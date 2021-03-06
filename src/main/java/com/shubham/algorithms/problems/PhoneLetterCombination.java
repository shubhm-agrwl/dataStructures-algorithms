package com.shubham.algorithms.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneLetterCombination {

  /*
   * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
   * that the number could represent.
   *
   * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1
   * does not map to any letters.
   *
   * Example:
   *
   * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
   *
   * Note:
   *
   * Although the above answer is in lexicographical order, your answer could be in any order you
   * want.
   *
   */

  private static Map<String, String> phone = new HashMap<String, String>() {
    {
      put("2", "abc");
      put("3", "def");
      put("4", "ghi");
      put("5", "jkl");
      put("6", "mno");
      put("7", "pqrs");
      put("8", "tuv");
      put("9", "wxyz");
    }
  };

  static List<String> output = new ArrayList<>();

  public static void main(String[] args) {
    System.out.println(letterCombinations("23"));
  }

  private static List<String> letterCombinations(String digits) {
    if (digits.length() != 0) {
      backtrack("", digits);
    }
    return output;
  }

  private static void backtrack(String combination, String nextDigits) {
    // if there is no more digits to check
    if (nextDigits.length() == 0) {
      // the combination is done
      output.add(combination);
    }
    // if there are still digits to check
    else {
      // iterate over all letters which map
      // the next available digit
      String digit = nextDigits.substring(0, 1);
      String letters = phone.get(digit);
      for (int i = 0; i < letters.length(); i++) {
        String letter = phone.get(digit).substring(i, i + 1);
        // append the current letter to the combination
        // and proceed to the next digits
        backtrack(combination + letter, nextDigits.substring(1));
      }
    }
  }
}
