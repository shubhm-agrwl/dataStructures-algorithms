package com.shubham.lcMayChallenge;

public class MaxProductWordLength {

  public int maxProduct(String[] words) {
    int n = words.length;

    int[] wordsInt = new int[n];

    for (int i = 0; i < n; i++) {
      wordsInt[i] = getWordIntValue(words[i]);
    }

    int maximumProduct = 0;
    for (int i = 0; i < n - 1; i++) {
      for (int j = i + 1; j < n; j++) {
        //ignore word pair if there any common letter
        if ((wordsInt[i] & wordsInt[j]) > 0) {
          continue;
        }

        maximumProduct = Math.max(maximumProduct, words[i].length() * words[j].length());
      }
    }

    return maximumProduct;
  }

  private int getWordIntValue(String word) {

    int intValue = 0;
    for (char c : word.toCharArray()) {
      //set the bit at (c - 'a') position
      intValue |= (1 << (c - 'a'));
    }

    return intValue;
  }

}
