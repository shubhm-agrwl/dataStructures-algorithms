package com.shubham.dataStructures.string;

import java.util.Stack;
import javafx.util.Pair;

public class RemoveAdjacentDuplicates {

  public static void main(String[] args) {
    System.out.println(removeDuplicates("abbaca", 2));
  }

  public static String removeDuplicates(String S) {

    StringBuilder sb = new StringBuilder();
    for (char ch : S.toCharArray()) {
      if (sb.length() != 0 && sb.charAt(sb.length() - 1) == ch) {
        sb.deleteCharAt(sb.length() - 1);
      } else {
        sb.append(ch);
      }
    }
    return sb.toString();

  }

  public static String removeDuplicates(String s, int k) {
    Stack<Pair<Character, Integer>> st = new Stack<>();
    for (char c : s.toCharArray()) {
      if (st.isEmpty() || st.peek().getKey() != c) {
        st.push(new Pair<>(c, 1));
      } else {
        // matching case
        Pair<Character, Integer> head = st.pop();
        st.push(new Pair<>(head.getKey(), head.getValue() + 1));

        if (st.peek().getValue() == k) {
          st.pop();
        }
      }
    }

    String ans = "";
    while (!st.isEmpty()) {
      Pair<Character, Integer> head = st.pop();
      int freq = head.getValue();
      while (freq-- > 0) {
        ans = head.getKey() + ans;
      }
    }

    return ans;
  }

}
