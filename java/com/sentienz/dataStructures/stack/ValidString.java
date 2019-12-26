package com.sentienz.dataStructures.stack;

import java.util.HashMap;
import java.util.Stack;

public class ValidString {

  /*
   * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the
   * input string is valid.
   * 
   * An input string is valid if:
   * 
   * Open brackets must be closed by the same type of brackets. Open brackets must be closed in the
   * correct order.
   * 
   * Note that an empty string is also considered valid.
   * 
   * Example 1:
   * 
   * Input: "()" Output: true
   * 
   * Example 2:
   * 
   * Input: "()[]{}" Output: true
   * 
   * Example 3:
   * 
   * Input: "(]" Output: false
   * 
   * Example 4:
   * 
   * Input: "([)]" Output: false
   * 
   * Example 5:
   * 
   * Input: "{[]}" Output: true
   * 
   * 
   */

  public static void validStringMain() {
    System.out.println(isValid("{[]}"));
  }

  private static boolean isValid(String s) {
    HashMap<Character, Character> mappings = new HashMap<Character, Character>();
    mappings.put(')', '(');
    mappings.put('}', '{');
    mappings.put(']', '[');

    // Initialize a stack to be used in the algorithm.
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      // If the current character is a closing bracket.
      if (mappings.containsKey(c)) {

        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        char topElement = stack.empty() ? '#' : stack.pop();

        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != mappings.get(c)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }

}
