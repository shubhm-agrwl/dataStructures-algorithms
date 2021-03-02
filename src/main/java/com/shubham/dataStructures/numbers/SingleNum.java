package com.shubham.dataStructures.numbers;

import java.util.HashMap;
import java.util.Map;

public class SingleNum {

  public int singleNumber(int[] nums) {
    Map<Integer, Integer> res = new HashMap<>();

    for (int num : nums) {
      if (res.containsKey(num)) {
        res.put(num, res.get(num) + 1);
      } else {
        res.put(num, 1);
      }
    }
//res.forEach((k,v) -> {
//  if (v==1){
//    return k;
//  }
//});

    for (Map.Entry mapElement : res.entrySet()) {
      int key = (int) mapElement.getKey();

      // Add some bonus marks
      // to all the students and print it
      int value = (int) mapElement.getValue();

      if (value == 1) {
        return key;
      }
    }

    return -1;

  }

}
