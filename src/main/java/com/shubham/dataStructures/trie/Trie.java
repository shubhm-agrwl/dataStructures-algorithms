package com.shubham.dataStructures.trie;

public class Trie {

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

  // Inserts a word into the trie.
  public void insert(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char currentChar = word.charAt(i);
      if (!node.containsKey(currentChar)) {
        node.put(currentChar, new TrieNode());
      }
      node = node.get(currentChar);
    }
    node.setEnd();
  }

  private TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      char curLetter = word.charAt(i);
      if (node.containsKey(curLetter)) {
        node = node.get(curLetter);
      } else {
        return null;
      }
    }
    return node;
  }

  // Returns if the word is in the trie.
  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  public boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }
}
