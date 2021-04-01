package com.shubham.dataStructures.array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {

  public static void main(String[] args) {

  }

  public int[][] merge(int[][] intervals) {
    int flag = 1;
    int size = intervals.length;
    while (flag == 1) {
      int[][] res = new int[size][2];
      int j = 0;
      int count = 0;
      for (int i = 0; i < size; i++) {
        int start = intervals[i][0];
        int end = intervals[i][1];
        while (i < size - 1 && ((((intervals[i + 1][0] >= start
            && intervals[i + 1][0] <= end) || (intervals[i + 1][1] >= start
            && intervals[i + 1][1] <= end))) || ((start >= intervals[i + 1][0]
            && start <= intervals[i + 1][1]) || (end >= intervals[i + 1][0]
            && end <= intervals[i + 1][1])))) {

          if (start > intervals[i + 1][0]) {
            count++;
            start = intervals[i + 1][0];
          }
          if (end < intervals[i + 1][1]) {
            count++;
            end = intervals[i + 1][1];
          }
          i++;
        }
        res[j][0] = start;
        res[j][1] = end;
        j++;
      }

      int[][] r = new int[j][2];
      int k = 0;
      for (int i = 0; i < j; i++) {
        r[i][0] = res[k][0];
        r[i][1] = res[k][1];
        k++;
      }
      size = j;
      if (count == 0) {
        flag = 0;
        return r;
      }
    }
    return null;
  }

  public int[][] mergeWorking(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    LinkedList<int[]> merged = new LinkedList<>();
    for (int[] interval : intervals) {
      // if the list of merged intervals is empty or if the current
      // interval does not overlap with the previous, simply append it.
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      }
      // otherwise, there is overlap, so we merge the current and previous
      // intervals.
      else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }
    return merged.toArray(new int[merged.size()][]);
  }

}
