package com.shubham.dataStructures.numbers;

public class BeautifulArrangement {

  int count = 0;

  public int countArrangement(int N) {
    boolean[] visited = new boolean[N + 1];
    calculate(N, 1, visited);
    return count;
  }

  public void calculate(int N, int pos, boolean[] visited) {
    if (pos > N) {
      count++;
    }
    for (int i = 1; i <= N; i++) {
      if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
        visited[i] = true;
        calculate(N, pos + 1, visited);
        visited[i] = false;
      }
    }
  }

  public int[] constructArray(int n, int k) {
    int[] ans = new int[n];
    int c = 0;
    for (int v = 1; v < n - k; v++) {
      ans[c++] = v;
    }
    for (int i = 0; i <= k; i++) {
      ans[c++] = (i % 2 == 0) ? (n - k + i / 2) : (n - i / 2);
    }
    return ans;
  }

}
