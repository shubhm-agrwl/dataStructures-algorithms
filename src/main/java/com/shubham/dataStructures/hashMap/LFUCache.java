package com.shubham.dataStructures.hashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LFUCache {

  class Node {

    public int key;
    public int val;
    public int freq;

    Node(int key, int val) {
      this.key = key;
      this.val = val;
      this.freq = 0;
    }
  }

  public int capacity;
  public HashMap<Integer, LinkedHashMap<Integer, Node>> freqMap;
  public HashMap<Integer, Node> cache;

  public LFUCache(int capacity) {
    this.capacity = capacity;
    this.cache = new HashMap<>();
    this.freqMap = new HashMap<>();
  }

  public int get(int key) {
    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      incrementFrequency(node);
      return node.val;
    }
    return -1;
  }

  private void removeFrequency(Node node) {
    LinkedHashMap<Integer, Node> lru = freqMap.get(node.freq);
    if (lru != null) {
      lru.remove(node.key);
      if (lru.isEmpty()) {
        freqMap.remove(node.freq);
      } else {
        freqMap.put(node.freq, lru);
      }
    }
  }

  private void addFrequency(Node node) {
    LinkedHashMap<Integer, Node> lru = freqMap.getOrDefault(node.freq, new LinkedHashMap<>());
    if (lru.containsKey(node.key)) {
      lru.remove(node.key);
    }
    lru.put(node.key, node);
    freqMap.put(node.freq, lru);
  }

  private void incrementFrequency(Node node) {
    removeFrequency(node);
    node.freq++;
    addFrequency(node);
  }

  private void removeLeastFrequent() {
    int minFreq = Integer.MAX_VALUE;
    for (int i : freqMap.keySet()) {
      minFreq = Math.min(minFreq, i);
    }
    if (minFreq != Integer.MAX_VALUE) {
      LinkedHashMap<Integer, Node> lru = freqMap.get(minFreq);
      if (lru != null) {
        for (Map.Entry<Integer, Node> entry : lru.entrySet()) {
          cache.remove(entry.getKey());
          lru.remove(entry.getKey());
          break;
        }
        if (lru.isEmpty()) {
          freqMap.remove(minFreq);
        }
      }
    }
  }

  public void put(int key, int value) {
    if (this.capacity == 0) {
      return;
    }

    if (cache.containsKey(key)) {
      Node node = cache.get(key);
      node.val = value;
      incrementFrequency(node);
    } else {
      Node node = new Node(key, value);
      if (cache.keySet().size() >= this.capacity) {
        removeLeastFrequent();
      }
      incrementFrequency(node);
      cache.put(key, node);
    }
  }

}
