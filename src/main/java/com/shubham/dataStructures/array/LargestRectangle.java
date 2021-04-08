package com.shubham.dataStructures.array;

import java.util.Stack;

public class LargestRectangle {

  public static void main(String[] args) {
    largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
  }

  public static int largestRectangleArea(int[] heights) {
    int omax = Integer.MIN_VALUE;
    Stack<Integer> st = new Stack<>();
    int n = heights.length;
    st.push(0);
    for (int i = 1; i < n; i++) {
      while (st.size() > 0 && heights[st.peek()] > heights[i]) {
        int nser = i;
        int idx = st.pop();
        int nsel = (st.size() == 0) ? -1 : st.peek();
        int width = nser - nsel - 1;
        int height = width * heights[idx];
        omax = Math.max(omax, height);
      }
      st.push(i);
    }
    while (st.size() > 0) {
      int nser = heights.length;
      int idx = st.pop();
      int nsel = (st.size() == 0) ? -1 : st.peek();
      int width = nser - nsel - 1;
      int height = width * heights[idx];
      omax = Math.max(omax, height);
    }
    return omax;
  }

}
