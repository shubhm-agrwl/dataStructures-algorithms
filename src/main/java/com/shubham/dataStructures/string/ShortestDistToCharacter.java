package com.shubham.dataStructures.string;

public class ShortestDistToCharacter {

  public static void main(String[] args) {
    //shortestToChar("loveleetcode", 'e');
    //shortestToChar("aaba",'b');
    shortestToChar("baaa", 'b');
  }

  public static int[] shortestToChar(String s, char c) {
    int[] res = new int[s.length()];
    for (int i = 0; i < res.length; i++) {
      int before = s.substring(0, i).lastIndexOf(c);
      if (before >= 0){
        before = Math.abs(i - before);
      }
      int after = s.substring(i).indexOf(c);
      if (after < 0) {
        res[i] = before;
      } else if (before < 0) {
        res[i] = after;
      } else {
        res[i] = Math.min(after, before);
      }
    }
    return res;
  }

}
