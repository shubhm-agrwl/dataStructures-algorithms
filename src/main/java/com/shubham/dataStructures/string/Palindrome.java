package com.shubham.dataStructures.string;

public class Palindrome {

  public static void main(String[] args) {
    System.out.println(isPalindrome("."));
  }

  public static boolean isPalindrome(String s) {

    s = s.toLowerCase().trim();

    int i = 0;
    int j = s.length() - 1;
    int chars = 0;

    while (i <= j) {

      while (!(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
        i++;
        if (i >= s.length()) {
          break;
        }
      }

      while (!(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')) {
        j--;
        if (j <= 0) {
          break;
        }
      }

      chars++;
      if ((i <= j) && (s.charAt(i++) != s.charAt(j--))) {
        return false;
      }
    }

    if (chars == 1) {
      return false;
    }

    return true;

  }

  public boolean isPalindrome2(String s) {
    int i = 0, j = s.length() - 1;
    while (i < j) {
      //increment the vlue of 'i' till character is not valid letter or digit
      // make sure 'i' is always less than 'j' othewise it will throw arrayIndexOutOfBoundException
      while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
        i++;
      }
      //decrement the value of 'j' till character is not valid letter or digit
      // make sure 'i' is always less than 'j' othewise it will throw arrayIndexOutOfBoundException
      while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
        j--;
      }

      //we can return false if both character at index 'i' and 'j' are not same
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        return false;
      }
      //repeat the process till i < j
      i++;
      j--;
    }
    return true;
  }

}
