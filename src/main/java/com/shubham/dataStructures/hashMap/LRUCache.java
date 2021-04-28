package com.shubham.dataStructures.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;

public class LRUCache {

  int capacity;
  Map<Integer, Integer> map;
  LinkedHashSet<Integer> set;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    map = new HashMap();
    set = new LinkedHashSet();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    }
    set.remove(key);
    set.add(key);
    return map.get(key);
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      set.remove(key);
      set.add(key);
      map.put(key, value);
      return;
    }

    if (map.size() == capacity) {
      Iterator it = set.iterator();
      map.remove(it.next());
      it.remove();
    }

    set.add(key);
    map.put(key, value);
  }

}
