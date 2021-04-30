package com.shubham.dataStructures.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CommonChars {

  public List<String> commonChars(String[] A) {
    List<String> li = new ArrayList<>();
    HashMap<Character, List<Integer>> map = new HashMap<>();
    for (String s : A) {
      HashMap<Character, Integer> map1 = new HashMap<>();
      Set<Character> set = new HashSet<>();
      for (char ch : s.toCharArray()) {
        map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        set.add(ch);
      }
      for (char ch : set) {
        map.put(ch, map.getOrDefault(ch, new ArrayList()));
        map.get(ch).add(map1.get(ch));
      }
    }
    for (Map.Entry<Character, List<Integer>> d : map.entrySet()) {
      if (d.getValue().size() == A.length) {
        for (int i = 0; i < Collections.min(d.getValue()); ++i) {
          li.add(String.valueOf(d.getKey()));
        }
      }
    }
    return li;
  }

  public List<String> commonCharsDDArrayMethod(String[] A) {

    ArrayList<String> al = new ArrayList<String>();
    int[][] map = new int[A.length][26];
    for (int itr = 0; itr < A.length; itr++) {
      for (int i = 0; i < A[itr].length(); i++) {
        map[itr][A[itr].charAt(i) - 'a']++;
      }
    }

    for (int j = 0; j < 26; j++) {
      int min = 101;
      for (int i = 0; i < A.length; i++) {
        min = min < map[i][j] ? min : map[i][j];
        if (min == 0) {
          break;
        }
      }
      if (min != 0) {
        while (min-- > 0) {
          //al.add(Character.toString(j + 'a'));
        }
      }
    }

    return al;
  }

}
