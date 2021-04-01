package com.shubham.dataStructures.array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

  public static void main(String[] args) {
    insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
  }

  public static int[][] insert(int[][] intervals, int[] newInterval) {
    int[][] res = new int[intervals.length][2];
    int j = 0;
    int un = 0;
    for (int i = 0; i < intervals.length - 1; i++) {
      if (intervals[i][1] < newInterval[0]) {
        res[i][0] = intervals[i][0];
        res[i][1] = intervals[i][1];
        j = i;
      } else {
        res[i][0] = intervals[i][0];
        un = i;
        int sn = newInterval[1];
        int flag = 0;
        while (i < intervals.length - 1 && sn >= intervals[i + 1][0]) {
          //res[i][1] = intervals[i + 1][1];
          flag = 1;
          i++;
        }
        if (flag == 1) {
          res[un][1] = intervals[i + 1][1];
        } else {
          res[un][1] = newInterval[1];
        }

        j = i;
        break;
      }
    }

    //System.out.println(j);

    for (int i = j + 1; i < intervals.length; i++) {
      res[i][0] = intervals[i][0];
      res[i][1] = intervals[i][1];
    }

    int[][] r = new int[res.length][2];
    int k = 0;
    for (int i = 0; i < res.length; i++) {
      if (res[i][0] == 0 && res[i][1] == 0) {
        continue;
      }
      r[k][0] = res[i][0];
      r[k][1] = res[i][1];
      k++;
    }

    return r;
  }

  public int[][] insertWorking(int[][] intervals, int[] newInterval) {
    List<int[]> arr = new ArrayList<>();
    for (int[] interval : intervals) {
      if (newInterval == null || interval[1] < newInterval[0]) {
        arr.add(interval);
      } else if (newInterval[1] < interval[0]) {
        arr.add(newInterval);
        newInterval = null;
        arr.add(interval);
      } else {
        newInterval[0] = Math.min(newInterval[0], interval[0]);
        newInterval[1] = Math.max(newInterval[1], interval[1]);
      }
    }
    if (newInterval == null) {
      return arr.toArray(new int[arr.size()][]);
    } else {
      arr.add(newInterval);
      return arr.toArray(new int[arr.size()][]);
    }
  }

}
