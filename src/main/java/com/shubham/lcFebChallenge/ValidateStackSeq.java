package com.shubham.lcFebChallenge;

import java.util.Stack;

public class ValidateStackSeq {

  public static void main(String[] args) {
//    validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
    validateStackSequences(new int[]{1, 0}, new int[]{1, 0});
  }

  public static boolean validateStackSequences(int[] pushed, int[] popped) {

    Stack<Integer> res = new Stack<>();

    int j = 0;
    for (int i = 0; i < pushed.length; i++) {
      if (res.size() > 0) {
        while (!res.isEmpty() && popped[j] == res.peek()) {
          res.pop();
          j++;
        }
      }
      res.push(pushed[i]);
    }
    if (res.size() > 0) {
      while (j <= popped.length - 1 && popped[j] == res.peek()) {
        res.pop();
        j++;
      }
    }

    if (res.isEmpty()) {
      return true;
    }
    return false;
  }

}
