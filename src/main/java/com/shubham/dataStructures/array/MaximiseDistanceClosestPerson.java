package com.shubham.dataStructures.array;

public class MaximiseDistanceClosestPerson {

  public int maxDistToClosest(int[] seats) {

    int res = 0;

    for (int i = 0; i < seats.length; i++) {
      if (seats[i] == 0) {
        int j = i;
        int k = i;
        while (j >= 0 && seats[j] == 0) {
          j--;
        }
        while (k < seats.length && seats[k] == 0) {
          k++;
        }
        int temp_min = 0;
        if (j < 0) {
          temp_min = k - i;
        } else if (k == seats.length) {
          temp_min = i - j;
        } else {
          temp_min = Math.min(i - j, k - i);
        }
        res = Math.max(res, temp_min);
      }
    }
    return res;

  }

}
