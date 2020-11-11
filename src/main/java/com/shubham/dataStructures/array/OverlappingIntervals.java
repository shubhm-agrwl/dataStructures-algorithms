package com.shubham.dataStructures.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class OverlappingIntervals {

  /*
  Given a collection of Intervals, the task is to merge all of the overlapping Intervals.

  Example 1:

  Input:
  N = 4
  Intervals = {(1,3),(2,4),(6,8),(9,10)}
  Output: 1 4 6 8 9 10
  Explanation: Given intervals: [1,3],[2,4]
  [6,8],[9,10], we have only two overlapping
  intervals here,[1,3] and [2,4]. Therefore
  we will merge these two and return [1,4],
  [6,8], [9,10].

  Example 2:

  Input:
  N = 4
  Intervals = {(6,8),(1,9),(2,4),(4,7)}
  Output: 1 9
   */

  class pair {

    public int first;
    public int second;

    public pair(int first, int second) {
      this.first = first;
      this.second = second;
    }

  }

  public static void main(String[] args) {

  }

  private static ArrayList<pair> overlappedInterval(ArrayList<pair> vec, int n) {
    // code here

    // code here
    ArrayList<pair> res = new ArrayList<>();
    if (n <= 0) {
      return res;
    }

    // Create an empty stack of intervals
    Stack<pair> stack = new Stack<>();

    // sort the intervals in increasing order of start time
    Collections.sort(vec, new Comparator<pair>() {
      public int compare(pair i1, pair i2) {
        return i1.first - i2.first;
      }
    });

    // push the first interval to stack
    stack.push(vec.get(0));

    // Start from the next interval and merge if necessary
    for (int i = 1; i < n; i++) {
      // get interval from stack top
      pair top = stack.peek();

      // if current interval is not overlapping with stack top,
      // push it to the stack
      if (top.second < vec.get(i).first) {
        stack.push(vec.get(i));
      }

      // Otherwise update the ending time of top if ending of current
      // interval is more
      else if (top.second < vec.get(i).second) {
        top.second = vec.get(i).second;
        stack.pop();
        stack.push(top);
      }
    }

    // Print contents of stack
    //System.out.print("The Merged Intervals are: ");
    while (!stack.isEmpty()) {
      pair t = stack.pop();
      res.add(t);
    }

    Collections.sort(res, new Comparator<pair>() {
      public int compare(pair i1, pair i2) {
        return i1.first - i2.first;
      }
    });

    return res;

  }

}
