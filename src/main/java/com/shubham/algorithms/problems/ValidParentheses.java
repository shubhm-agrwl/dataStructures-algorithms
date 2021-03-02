package com.shubham.algorithms.problems;

import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    System.out.println(isValid("()[]{}"));
  }

  public static boolean isValid(String s) {

    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      if ((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '[')) {
        stack.push(s.charAt(i));
      } else {
        if (stack.isEmpty()) {
          return false;
        }
        switch (s.charAt(i)) {
          case ')':
            if (!stack.pop().equals('(')) {
              return false;
            }
            break;
          case '}':
            if (!stack.pop().equals('{')) {
              return false;
            }
            break;
          case ']':
            if (!stack.pop().equals('[')) {
              return false;
            }
            break;
          default:
            return false;
        }
      }
    }
    if (!stack.isEmpty()) {
      return false;
    }
    return true;
  }

  public String minRemoveToMakeValid(String s) {
    char[] c = s.toCharArray();
    int count = 0;
    String result = "";

    for (int i = 0; i < c.length; i++) {
      if (c[i] == '(') {
        count++;
      } else if (c[i] == ')' && count == 0) {
        c[i] = '0';
      } else if (c[i] == ')' && count > 0) {
        count--;
      }
    }
    count = 0;
    for (int j = c.length - 1; j >= 0; j--) {
      if (c[j] == ')') {
        count++;
      } else if (c[j] == '(' && count == 0) {
        c[j] = '0';
      } else if (c[j] == '(' && count > 0) {
        count--;
      }
    }
    for (int i = 0; i < c.length; i++) {
      if (c[i] != '0') {
        result += c[i];
      }
    }
    return result;
  }

}
