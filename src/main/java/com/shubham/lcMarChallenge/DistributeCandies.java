package com.shubham.lcMarChallenge;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

  public int distributeCandies(int[] candyType) {

    Set<Integer> diffCandies = new HashSet<>();
    int max = candyType.length;

    for (int candy : candyType) {
      diffCandies.add(candy);
    }

    return Math.min(max / 2, diffCandies.size());

  }

}
