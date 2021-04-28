package com.shubham.dataStructures.hashMap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

  public int leastBricks(List<List<Integer>> wall) {
    Map<Integer, Integer> cnt = new HashMap<>();

    for (List<Integer> row : wall) {
      int n = row.size(), width = 0;
      for (int i = 0; i < n - 1; i++) {
        width += row.get(i);
        cnt.put(width, cnt.getOrDefault(width, 0) + 1);
      }
    }

    int num_row = wall.size(), max = 0;
    for (int key : cnt.keySet()) {
      max = Math.max(cnt.get(key), max);
    }
    return num_row - max;
  }
}
