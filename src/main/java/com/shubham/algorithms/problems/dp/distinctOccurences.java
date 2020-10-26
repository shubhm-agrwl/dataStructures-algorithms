package com.shubham.algorithms.problems.dp;

  /*
  Given two strings S and T, find count of distinct occurrences of T in S as a sub-sequence. Your task is to complete the function subsequenceCount which takes two strings as argument S and T and returns the count of the sub-sequences.

  Input:
  The first line of input contains an integer t denoting the no of test cases . Then t test cases follow. The first line of each test case contains 2 strings S and T.

  Output:
  For each test case in a new line print the count of distinct occurrences of T in S as a sub-sequence.
  Since the count can be quite large, return the count modulo 1e9 + 7.

  Expected Time Complexity: O(n*m).
  Expected Auxiliary Space: O(n*m).

  Constraints:
  1<=t<=100
  1<=length of(T)<=100
  1<=length of(S)<=8000

  Example(To be used only for expected output):
  Input
  2
  banana ban
  geeksforgeeks ge
  Output
  3
  6
 */

public class distinctOccurences {

  public static void main(String[] args) {
    System.out.println(subsequenceCount("banana", "ban"));
  }

  private static int subsequenceCount(String S, String T) {
    int m = T.length();
    int n = S.length();

    // T can't appear as a subsequence in S
    if (m > n) {
      return 0;
    }

    // mat[i][j] stores the count of
    // occurrences of T(1..i) in S(1..j).
    int mat[][] = new int[m + 1][n + 1];

    // Initializing first column with
    // all 0s. An emptystring can't have
    // another string as suhsequence
    for (int i = 1; i <= m; i++) {
      mat[i][0] = 0;
    }

    // Initializing first row with all 1s.
    // An empty string is subsequence of all.
    for (int j = 0; j <= n; j++) {
      mat[0][j] = 1;
    }

    // Fill mat[][] in bottom up manner
    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        // If last characters don't match,
        // then value is same as the value
        // without last character in S.
        if (T.charAt(i - 1) != S.charAt(j - 1)) {
          mat[i][j] = mat[i][j - 1];
        }

        // Else value is obtained considering two cases.
        // a) All substrings without last character in S
        // b) All substrings without last characters in
        // both.
        else {
          mat[i][j] = mat[i][j - 1] + mat[i - 1][j - 1];
        }
      }
    }

        /* uncomment this to print matrix mat
        for (int i = 1; i <= m; i++, cout << endl)
            for (int j = 1; j <= n; j++)
                System.out.println ( mat[i][j] +" "); */
    return mat[m][n];
  }

}
