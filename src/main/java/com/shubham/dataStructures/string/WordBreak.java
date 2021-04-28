package com.shubham.dataStructures.string;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class WordBreak {

  public boolean wordBreak(String s, List<String> wordDict) {
    // for memoization
    HashMap<String, Boolean> map = new HashMap<>();
    return canConstruct(s, wordDict, map);
  }

  public boolean canConstruct(String target, List<String> words, HashMap<String, Boolean> map) {

    // if answer already cached, return it
    if (map.containsKey(target)) {
      return map.get(target);
    }

    // if target string is empty
    // it can always be constructed by taking no elements from dictionary
    if (target.isEmpty()) {
      return true;
    }

    // for all words in the dictionary
    for (String word : words) {
      // if the target starts with the given word
      if (target.startsWith(word)) {
        // and it is possible to construct the rest of the string
        // from the words in the dictionary
        if (canConstruct(target.substring(word.length()), words, map)) {

          // save and return true
          map.put(target, true);
          return true;
        }
      }
    }

    // if it was not possible to construct the target from words from the dictionary
    // save and return false to the previous call
    map.put(target, false);
    return false;
  }

  public List wordBreak2(String s, List wordDict) {
    List par = new LinkedList<>();
    List par1 = new LinkedList<>();
    helper(par, s, wordDict, par1);
    return par1;
  }

  void helper(List<String> par, String s, List dic, List par1) {

    if (s.length() == 0) {
      String temp = "";
      for (String ss : par) {
        temp += ss + " ";
      }
      par1.add(temp.trim());
      return;
    }

    for (int i = 1; i <= s.length(); i++) {
      if (dic.contains(s.substring(0, i))) {
        par.add(s.substring(0, i));
        helper(par, s.substring(i), dic, par1);
        par.remove(par.size() - 1);
      }

    }

  }

}
