package com.shubham.dataStructures.string;

public class ReverseWordsInString {

  public String reverseWords(String s) {
    String[] words = s.split(" ");
    StringBuilder reverse = new StringBuilder();
    for (int i = words.length - 1; i >= 0; i--) {
      reverse.append(words[i]);
      reverse.append(" ");
    }
    return reverse.toString().trim().replaceAll(" +", " ");
  }

}
