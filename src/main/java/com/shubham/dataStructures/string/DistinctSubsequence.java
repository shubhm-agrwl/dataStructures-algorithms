package com.shubham.dataStructures.string;

import java.util.Arrays;

public class DistinctSubsequence {

  public static void main(String[] args) {
    System.out.println(numDistinct("rabbbit", "rabbit"));
  }

  public static int numDistinct(String s, String t) {
      /*
	  memo[][], Rows- String T, Cols- String S.
	  memo[i][j] = Number of subsequences of s.substring(0,j) which equals t.substring(0,i).
	  */
    int n = t.length(), N = s.length(), memo[][] = new int[n + 1][N + 1];
    //If T="", then only subsequnce present in S i.e., choosing no character.
    Arrays.fill(memo[0], 1);

    for (int i = 0; i < n; i++) {
      for (int j = i; j < N; j++) {
        memo[i + 1][j + 1] = (t.charAt(i) != s.charAt(j) ? memo[i + 1][j] :
            memo[i][j] + memo[i + 1][j]);
      }
    }

    return memo[n][N];

  }

}
