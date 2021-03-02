package com.shubham.dataStructures.string;

public class LengthLastWord {

  public static void main(String[] args) {
    System.out.println(lengthOfLastWord("Hello World"));
  }

  public static int lengthOfLastWord(String s) {
    String[] words = s.split(" ");
    if (words.length==0)
      return 0;
    return words[words.length - 1].length();
  }

}
