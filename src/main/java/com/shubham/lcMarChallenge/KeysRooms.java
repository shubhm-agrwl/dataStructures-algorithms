package com.shubham.lcMarChallenge;

import java.util.List;
import java.util.Stack;

public class KeysRooms {

  public boolean canVisitAllRooms(List<List<Integer>> rooms) {

    boolean seen[] = new boolean[rooms.size()];

    Stack<Integer> keys = new Stack<>();
    keys.push(0);
    seen[0] = true;

    while (!keys.isEmpty()) {
      int room = keys.pop();
//      seen[room] = true;

      for (int n : rooms.get(room)) {
        if (!seen[n]) {
          keys.push(n);
          seen[n] = true;
        }
      }
    }

    for (boolean visit : seen) {
      if (!visit) {
        return false;
      }
    }
    return true;
  }

}
