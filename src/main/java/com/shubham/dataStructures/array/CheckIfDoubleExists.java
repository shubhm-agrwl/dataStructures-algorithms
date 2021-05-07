package com.shubham.dataStructures.array;

import java.util.HashSet;
import java.util.Set;

public class CheckIfDoubleExists {

  public boolean checkIfExist(int[] arr) {
    Set<Double> res = new HashSet<>();
    int zerocount = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        res.add((double) arr[i]);
        if (res.contains((double) arr[i] * 2) || res.contains((double) arr[i] / 2)) {
          return true;
        }
      } else {
        zerocount++;
      }
    }
    if (zerocount > 1) {
      return true;
    }
    return false;
  }

}
