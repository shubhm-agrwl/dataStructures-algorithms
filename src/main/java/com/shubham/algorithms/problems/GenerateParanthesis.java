package com.shubham.algorithms.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

  /*
   * Given n pairs of parentheses, write a function to generate all combinations of well-formed
   * parentheses.
   *
   * For example, given n = 3, a solution set is:
   *
   * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
   *
   */

  public static void main(String[] args) {
    System.out.println(generateParenthesisBruteForce(3));
    System.out.println(generateParenthesisBackTrack(3));
    System.out.println(generateParenthesisClosure(3));
  }

  private static List<String> generateParenthesisClosure(int n) {
    List<String> ans = new ArrayList<>();
    if (n == 0) {
      ans.add("");
    } else {
      for (int c = 0; c < n; ++c) {
        for (String left : generateParenthesisClosure(c)) {
          for (String right : generateParenthesisClosure(n - 1 - c)) {
            ans.add("(" + left + ")" + right);
          }
        }
      }
    }
    return ans;
  }

  private static List<String> generateParenthesisBackTrack(int n) {
    List<String> ans = new ArrayList<>();
    backtrack(ans, "", 0, 0, n);
    return ans;
  }

  private static void backtrack(List<String> ans, String cur, int open, int close, int max) {
    if (cur.length() == max * 2) {
      ans.add(cur);
      return;
    }

    if (open < max) {
      backtrack(ans, cur + "(", open + 1, close, max);
    }
    if (close < open) {
      backtrack(ans, cur + ")", open, close + 1, max);
    }
  }

  private static List<String> generateParenthesisBruteForce(int n) {
    List<String> combinations = new ArrayList<>();
    generateAll(new char[2 * n], 0, combinations);
    return combinations;
  }

  private static void generateAll(char[] current, int pos, List<String> result) {
    if (pos == current.length) {
      if (valid(current)) {
        result.add(new String(current));
      }
    } else {
      current[pos] = '(';
      generateAll(current, pos + 1, result);
      current[pos] = ')';
      generateAll(current, pos + 1, result);
    }
  }

  private static boolean valid(char[] current) {
    int balance = 0;
    for (char c : current) {
      if (c == '(') {
        balance++;
      } else {
        balance--;
      }
      if (balance < 0) {
        return false;
      }
    }
    return (balance == 0);
  }
}

