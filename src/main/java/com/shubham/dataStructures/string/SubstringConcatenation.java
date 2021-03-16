package com.shubham.dataStructures.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SubstringConcatenation {

  public List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indices = new ArrayList<>();

    if (s == null || words == null || s.length() == 0 || words.length == 0) {
      return indices;
    }

    int wordLen = words[0].length(), wordsCount = words.length;

    Map<String, Integer> wordToCount = new HashMap<>();
    for (String word : words) {
      wordToCount.put(word, wordToCount.getOrDefault(word, 0) + 1);
    }

    for (int start = 0; start < wordLen; start++) {
      Queue<String> queue = new LinkedList<>();
      Map<String, Integer> substrWordToCount = new HashMap<>();
      for (int lo = start, hi = start; hi <= s.length() - wordLen; hi += wordLen) {
        String word = s.substring(hi, hi + wordLen);
        if (!wordToCount.containsKey(word)) {
          queue = new LinkedList<>();
          lo = hi + wordLen;
          substrWordToCount = new HashMap<>();
        } else {
          int substrWordCount = substrWordToCount.getOrDefault(word, 0);
          if (substrWordCount >= wordToCount.get(word)) {
            while (!queue.peek().equals(word)) {
              String wordToRemove = queue.poll();
              int count = substrWordToCount.get(wordToRemove);
              if (count == 1) {
                substrWordToCount.remove(wordToRemove);
              } else {
                substrWordToCount.put(wordToRemove, count - 1);
              }
              lo += wordLen;
            }
            lo += wordLen;
            queue.poll();
          } else {
            substrWordToCount.put(word, substrWordCount + 1);
          }
          queue.offer(word);
          if (queue.size() == wordsCount) {
            indices.add(lo);
          }
        }
      }
    }
    return indices;
  }

}
