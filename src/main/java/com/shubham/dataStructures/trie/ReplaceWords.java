package com.shubham.dataStructures.trie;

import java.util.List;

public class ReplaceWords {

  public String replaceWords(List<String> roots, String sentence) {

    TrieNodeReplaceChildren trie = new TrieNodeReplaceChildren();
    for (String root : roots) {
      TrieNodeReplaceChildren cur = trie;
      for (char letter : root.toCharArray()) {
        if (cur.children[letter - 'a'] == null) {
          cur.children[letter - 'a'] = new TrieNodeReplaceChildren();
        }
        cur = cur.children[letter - 'a'];
      }
      cur.word = root;
    }

    StringBuilder ans = new StringBuilder();

    for (String word : sentence.split("\\s+")) {
      if (ans.length() > 0) {
        ans.append(" ");
      }

      TrieNodeReplaceChildren cur = trie;
      for (char letter : word.toCharArray()) {
        if (cur.children[letter - 'a'] == null || cur.word != null) {
          break;
        }
        cur = cur.children[letter - 'a'];
      }
      ans.append(cur.word != null ? cur.word : word);
    }
    return ans.toString();
  }
}

class TrieNodeReplaceChildren {

  TrieNodeReplaceChildren[] children;
  String word;

  TrieNodeReplaceChildren() {
    children = new TrieNodeReplaceChildren[26];
  }
}
