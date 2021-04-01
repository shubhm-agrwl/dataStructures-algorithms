package com.shubham.lcMarChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSubsets {

  public static void main(String[] args) {
    WordSubsets subsets = new WordSubsets();
    List<String> r = subsets
        .wordSubsetsActual(new String[]{"amazon", "apple", "facebook", "google", "leetcode"},
            new String[]{"e", "oo"});
    System.out.println(r);
  }

  public List<String> wordSubsets(java.lang.String[] A, java.lang.String[] B) {

    Set<String> res = new HashSet<>();
    Map<String, Map<String, Integer>> occ = new HashMap<>();

    for (java.lang.String a : A) {
      Map<String, Integer> c = new HashMap<>();
      occ.put(a, c);
      for (int i = 0; i < a.length(); i++) {
        String s = String.valueOf(a.charAt(i));
        if (c.containsKey(s)) {
          c.put(s, c.get(s) + 1);
        } else {
          c.put(s, 1);
        }
      }
      occ.put(a, c);
    }
    for (Map.Entry mapElement : occ.entrySet()) {
      for (String b : B) {

        HashMap<String, Integer> w = (HashMap<String, Integer>) mapElement.getValue();
        if (w.containsKey(b)) {
          if (w.get(b) > 0) {
            w.put(b, w.get(b) - 1);
            res.add((String) mapElement.getKey());
          } else {
            res.remove(mapElement.getKey());
            break;
          }
        } else {
          res.remove(mapElement.getKey());
          break;
        }
      }
    }
    return new ArrayList<>(res);
  }

  public List<String> wordSubsetsActual(String[] A, String[] B) {
    int[] bmax = count("");
    for (String b : B) {
      int[] bCount = count(b);
      for (int i = 0; i < 26; ++i) {
        bmax[i] = Math.max(bmax[i], bCount[i]);
      }
    }

    List<String> ans = new ArrayList();
    search:
    for (String a : A) {
      int[] aCount = count(a);
      for (int i = 0; i < 26; ++i) {
        if (aCount[i] < bmax[i]) {
          continue search;
        }
      }
      ans.add(a);
    }

    return ans;
  }

  public int[] count(String S) {
    int[] ans = new int[26];
    for (char c : S.toCharArray()) {
      ans[c - 'a']++;
    }
    return ans;
  }

}
