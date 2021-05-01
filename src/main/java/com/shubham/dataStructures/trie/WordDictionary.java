package com.shubham.dataStructures.trie;

import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

  private Trie root;

  private final char DOT = '.';

  /**
   * Initialize your data structure here.
   */
  public WordDictionary() {
    this.root = new Trie();
  }

  public void addWord(String word) {
    if (!isValid(word)) {
      return;
    }
    char charRead;
    Trie current = this.root;
    for (int index = 0; index < word.length(); index++) {
      charRead = word.charAt(index);
      Trie node = current.children.get(charRead);
      if (node == null) {
        node = new Trie();
        current.children.put(charRead, node);
      }
      current = node;
    }
    current.isEndOfWord = true;
  }

  public boolean search(String word) {
    if (!isValid(word)) {
      return false;
    }
    return search(this.root, word);
  }

  private boolean search(Trie current, String word) {
    char charRead;
    for (int index = 0; index < word.length(); index++) {
      charRead = word.charAt(index);
      if (!current.children.containsKey(charRead)) {
        if (charRead == DOT) {
          for (char ch : current.children.keySet()) {
            if (search(current.children.get(ch), word.substring(index + 1))) {
              return true;
            }
          }
        }
        return false;
      } else {
        current = current.children.get(charRead);
      }
    }
    return current.isEndOfWord;
  }

  private boolean isValid(String word) {
    return word != null && word.trim().length() > 0;
  }

  private class Trie {

    Map<Character, Trie> children;

    boolean isEndOfWord;

    public Trie() {
      this.children = new HashMap();
      this.isEndOfWord = false;
    }
  }
}
