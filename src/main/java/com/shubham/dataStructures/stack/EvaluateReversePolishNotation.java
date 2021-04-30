package com.shubham.dataStructures.stack;

import java.util.Stack;

public class EvaluateReversePolishNotation {

  public int evalRPN(String[] tokens) {
    Stack<Integer> st = new Stack<>();

    for (int i = 0; i < tokens.length; i++) {
      if (Character.isDigit(tokens[i].charAt(0))) {
        st.push(Integer.parseInt(tokens[i]));
      } else if (tokens[i].length() > 1 && (tokens[i].charAt(0) == '-' && Character
          .isDigit(tokens[i].charAt(1)))) {

        // For negative numbers
        st.push(Integer.parseInt(tokens[i]));
      } else {
        int x2 = st.pop();
        int x1 = st.pop();
        if (tokens[i].equals("-")) {
          int temp = x1 - x2;
          st.push(temp);
        } else if (tokens[i].equals("*")) {
          int temp = x1 * x2;
          st.push(temp);
        } else if (tokens[i].equals("/")) {
          int temp = x1 / x2;
          st.push(temp);
        } else {
          int temp = x1 + x2;
          st.push(temp);
        }
      }
    }

    return st.peek();

  }
}