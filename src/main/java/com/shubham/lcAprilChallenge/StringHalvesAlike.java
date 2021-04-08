package com.shubham.lcAprilChallenge;

public class StringHalvesAlike {

  public boolean halvesAreAlike(String s) {

    String s1 = s.substring(0, s.length() / 2).toLowerCase();
    String s2 = s.substring(s.length() / 2).toLowerCase();

    int counter = 0;
    for (int i = 0; i < s1.length(); i++) {
      if ((s1.charAt(i) == 'a') || (s1.charAt(i) == 'e') || (s1.charAt(i) == 'i') || (s1.charAt(i)
          == 'o') || (s1.charAt(i) == 'u')) {
        counter++;
      }
      if ((s2.charAt(i) == 'a') || (s2.charAt(i) == 'e') || (s2.charAt(i) == 'i') || (s2.charAt(i)
          == 'o') || (s2.charAt(i) == 'u')) {
        counter--;
      }
    }

    if (counter == 0) {
      return true;
    }

    return false;

  }

}
