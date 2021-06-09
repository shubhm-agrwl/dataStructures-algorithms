package com.shubham.dataStructures.string;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class IPAddress {

  public static void main(String[] args) {
    System.out.println(restoreIpAddresses("25525511135"));
  }

  public static List<String> restoreIpAddresses(String s) {
    List<String> results = new ArrayList<String>();
    step(s, 0, new int[4], 0, results);
    return results;
  }

  static void step(String s, int pos, int[] octets, int count, List<String> results) {
    if (count == 4 && pos == s.length()) {
      results.add(
          String.valueOf(
              new StringBuilder()
                  .append(octets[0])
                  .append('.')
                  .append(octets[1])
                  .append('.')
                  .append(octets[2])
                  .append('.')
                  .append(octets[3])));
    } else if (count < 4 && pos < 12) {
      int octet = 0;
      for (int i = 0; i < 3; i++) {
        if (pos + i < s.length()) {
          int digit = s.charAt(pos + i) - (int) '0';
          octet = octet * 10 + digit;
          if (octet < 256) {
            octets[count] = octet;
            step(s, pos + i + 1, octets, count + 1, results);
          }
          if (i == 0 && digit == 0) {
            break;
          }
        }
      }
    }
  }

  int n;
  String s;
  LinkedList<String> segments = new LinkedList<String>();
  ArrayList<String> output = new ArrayList<String>();

  public boolean valid(String segment) {
    /*
    Check if the current segment is valid :
    1. less or equal to 255
    2. the first character could be '0'
    only if the segment is equal to '0'
    */
    int m = segment.length();
    if (m > 3)
      return false;
    return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
  }

  public void update_output(int curr_pos) {
    /*
    Append the current list of segments
    to the list of solutions
    */
    String segment = s.substring(curr_pos + 1, n);
    if (valid(segment)) {
      segments.add(segment);
      output.add(String.join(".", segments));
      segments.removeLast();
    }
  }

  public void backtrack(int prev_pos, int dots) {
    /*
    prev_pos : the position of the previously placed dot
    dots : number of dots to place
    */
    // The current dot curr_pos could be placed
    // in a range from prev_pos + 1 to prev_pos + 4.
    // The dot couldn't be placed
    // after the last character in the string.
    int max_pos = Math.min(n - 1, prev_pos + 4);
    for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
      String segment = s.substring(prev_pos + 1, curr_pos + 1);
      if (valid(segment)) {
        segments.add(segment);  // place dot
        if (dots - 1 == 0)      // if all 3 dots are placed
          update_output(curr_pos);  // add the solution to output
        else
          backtrack(curr_pos, dots - 1);  // continue to place dots
        segments.removeLast();  // remove the last placed dot
      }
    }
  }

  public List<String> restoreIpAddressesLC(String s) {
    n = s.length();
    this.s = s;
    backtrack(-1, 3);
    return output;
  }

}
