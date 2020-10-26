package com.shubham.myexperience;

//23280666182645

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KDistinctSubstring {

  public static void main(String[] args) {

    // Print K distinct consecutive distinct characters

    List<String> ans = subStringsLessKDist("democracy", 5);
    for (String a : ans) {
      System.out.println(a);
    }

  }

  public static List<String> subStringsLessKDist(String inputString, int num) {
    // WRITE YOUR CODE HERE

    // distinct points out the current distinct elements in the set of SubString
    int distinct = 0;

    // pointer defines the current location while traversing the input String
    int pointer = 0;

    // Array to store which alphabet is stored in the substring
    int[] alphabetArray = new int[26];

    // Set of K-1 distinct characters in K substring
    Set<String> set = new HashSet<>();

    // Extracting the first K substring from the inputstring
    for (; pointer < num; pointer++) {
      if (alphabetArray[inputString.charAt(pointer) - 'a'] == 0) {
        // incrementing the distinct count if it is unique
        distinct += 1;
      }
      // incrementing the flag in the alphabet Array
      alphabetArray[inputString.charAt(pointer) - 'a'] += 1;
    }

    // if the substring has K-1 elements, then add to the resultset
    if (distinct == num - 1) {
      set.add(inputString.substring(pointer - num, pointer));
    }

    // traversing till the end of the input string
    while (pointer < inputString.length()) {
      if (alphabetArray[inputString.charAt(pointer) - 'a'] == 0) {
        // incrementing the distinct count if it is unique
        distinct += 1;
      }

      // incrementing the flag in the alphabet Array
      alphabetArray[inputString.charAt(pointer) - 'a'] += 1;

      // decrementing the flag of the first charcter in the substring in the alphabet Array
      alphabetArray[inputString.charAt(pointer - num) - 'a'] -= 1;
      if (alphabetArray[inputString.charAt(pointer - num) - 'a'] == 0) {
        distinct -= 1;
      }

      // if the substring has K-1 elements, then add to the resultset
      if (distinct == num - 1) {
        set.add(inputString.substring(pointer - num + 1, pointer + 1));
      }
      pointer += 1;
    }

    return new ArrayList<>(set);
  }

}
