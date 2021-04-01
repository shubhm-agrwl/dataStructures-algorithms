package com.shubham.dataStructures.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TextJustification {

  public static void main(String[] args) {
    System.out.println(
        fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."},
            16));
  }


  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> res = new ArrayList<>();
    int wordLength = 0;
    List<String> ws = new ArrayList<>();
    for (String word : words) {
      if (wordLength + word.length() + ws.size() < maxWidth) {
        ws.add(word);
        wordLength = wordLength + word.length();
      } else {
        StringBuilder s = new StringBuilder();
        int spaceLength = maxWidth - wordLength;
        int indivualspaceLength = spaceLength / ws.size() + 1;
        int tempCount = 0;
        for (String w : ws) {
          s.append(w);
          if (tempCount != ws.size() - 1) {
            for (int i = 0; i < indivualspaceLength; i++) {
              s.append(" ");
            }
          }
          tempCount++;
        }
        res.add(s.toString());
        wordLength = word.length();
        ws = new ArrayList<>();
        ws.add(word);
      }
    }
    StringBuilder s = new StringBuilder();
    int spaceLength = maxWidth - wordLength;
    int indivualspaceLength = spaceLength / ws.size() + 1;
    int tempCount = 0;
    for (String w : ws) {
      s.append(w);
      //if (tempCount != ws.size() - 1) {
      for (int i = 0; i < indivualspaceLength; i++) {
        s.append(" ");
      }
      //}
      tempCount++;
    }
    res.add(s.toString());
    return res;
  }

  public List<String> fullJustifyWorking(String[] words, int maxWidth) {
    List<String> answer = new ArrayList<>();

    List<String> buffer = new ArrayList<>();

    // Sum of characters of words in the buffer
    int sumChars = 0;

    for (int i = 0; i < words.length; i++) {
      String word = words[i];

      // Build a new line when it exceeds the maxWidth if you append the current word to the buffer too.
      // buffer.size() represents the minimal number of spaces we need to build a line.
      if (word.length() + sumChars + buffer.size() > maxWidth) {
        // maxWidth - sumChars is the total number of spaces we need to build this line
        String line = buildLine(buffer, maxWidth - sumChars, false);
        answer.add(line);
        sumChars = 0;
        buffer.clear();
      }

      sumChars += word.length();
      buffer.add(word);

      // Build the last line if it is the last word
      if (i == words.length - 1) {
        String line = buildLine(buffer, maxWidth - sumChars, true);
        answer.add(line);
      }
    }

    return answer;
  }

  // Helper method that builds a line from a list of words and number of spaces to be distributed.
  private String buildLine(List<String> words, int spaces, boolean isLastLine) {
    StringBuilder builder = new StringBuilder();

    // Last line: separate the words with single spaces
    if (isLastLine) {
      for (Iterator<String> it = words.iterator(); it.hasNext(); ) {
        builder.append(it.next());

        if (it.hasNext()) {
          builder.append(" ");
          spaces--;
        }
      }
      // Otherwise, calculate necessary amount of spaces to be add in each iteration
    } else {
      for (int i = 0; i < words.size(); i++) {
        builder.append(words.get(i));

        if (i < words.size() - 1) {
          // If we still have N words in the list then we need to distribute the remaining spaces to N-1 slots.
          int divisor = (words.size() - i) - 1;
          int spacesForThisSlot = (spaces + divisor - 1) / divisor; // round up

          for (int j = 0; j < spacesForThisSlot; j++) {
            builder.append(" ");
            spaces--;
          }
        }
      }
    }

    // Fill the rest of the line with spaces when there are leftovers
    // This happens if it is the last line or the words list had only one element
    for (int i = 0; i < spaces; i++) {
      builder.append(" ");
    }

    return builder.toString();
  }

}
