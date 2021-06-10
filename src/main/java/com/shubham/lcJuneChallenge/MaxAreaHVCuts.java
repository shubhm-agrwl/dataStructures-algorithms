package com.shubham.lcJuneChallenge;

import java.util.Arrays;

public class MaxAreaHVCuts {

  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    long maxHC = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);

    for (int i = 1; i < horizontalCuts.length; i++) {
      maxHC = Math.max(maxHC, Math.abs(horizontalCuts[i] - horizontalCuts[i - 1]));
    }
    long maxVC = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);
    for (int i = 1; i < verticalCuts.length; i++) {
      maxVC = Math.max(maxVC, Math.abs(verticalCuts[i] - verticalCuts[i - 1]));
    }
    return (int) ((maxHC * maxVC) % (1e9 + 7));
  }

}
