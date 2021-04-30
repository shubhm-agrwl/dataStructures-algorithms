package com.shubham.dataStructures.string;

import java.util.ArrayList;
import java.util.List;

public class KeyboardRow {

  public static void main(String[] args) {
    String[] inp = {"Hello", "Alaska", "Dad", "Peace"};
    System.out.println(findWords(inp));
  }

  public static String[] findWords(String[] words) {
    String[] keyboard = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
    List<String> res = new ArrayList<>();
    int k = 0;
    for (String word : words) {
      if (word.length() == 1) {
        res.add(word);
        continue;
      }

      String temp = word.toLowerCase();
      int key = 0;
      for (int i = 0; i < keyboard.length; i++) {
        if (keyboard[i].contains(Character.toString(temp.charAt(0)))) {
          key = i;
          break;
        }
      }
      for (int i = 1; i < word.length(); i++) {
        if (!keyboard[key].contains(Character.toString(temp.charAt(i)))) {
          break;
        }
        if (i == word.length() - 1) {
          res.add(word);
        }
      }
    }
    String[] itemsArray = new String[res.size()];
    return res.toArray(itemsArray);
  }

}
