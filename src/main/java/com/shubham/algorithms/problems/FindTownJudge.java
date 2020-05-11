package com.shubham.algorithms.problems;

  /*
  In a town, there are N people labelled from 1 to N.  There is a rumor that one of these people is secretly the town judge.

  If the town judge exists, then:

      The town judge trusts nobody.
      Everybody (except for the town judge) trusts the town judge.
      There is exactly one person that satisfies properties 1 and 2.

  You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.

  If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.

  Example 1:

  Input: N = 2, trust = [[1,2]]
  Output: 2

  Example 2:

  Input: N = 3, trust = [[1,3],[2,3]]
  Output: 3

  Example 3:

  Input: N = 3, trust = [[1,3],[2,3],[3,1]]
  Output: -1

  Example 4:

  Input: N = 3, trust = [[1,2],[2,3]]
  Output: -1

  Example 5:

  Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
  Output: 3

  Note:

      1 <= N <= 1000
      trust.length <= 10000
      trust[i] are all different
      trust[i][0] != trust[i][1]
      1 <= trust[i][0], trust[i][1] <= N
 */

import java.util.HashMap;
import java.util.Map;

public class FindTownJudge {

  public static void main(String[] args) {
    System.out
        .println(findJudge(4,
            new int[][]{{1, 2}, {3, 2}, {1, 3}, {4, 1}, {3, 1}, {2, 1}, {2, 3}, {4, 3}, {4, 2},
                {3, 4}, {2, 4}}));
    //System.out.println(findJudge(3, new int[][]{{1, 3}, {2, 3}}));
  }

  private static int findJudge(int N, int[][] trust) {

    if (N == 1) {
      return N;
    }

    if (trust.length == 1 && N == 2) {
      return trust[0][1];
    }
    Map<Integer, Integer> trustCount = new HashMap<>();
    Map<Integer, Integer> count = new HashMap<>();
    int judge = -1;
    for (int i = 0; i < trust.length; i++) {

      int[] person = trust[i];
      count.put(person[0], 1);
      if (trustCount.containsKey(person[1])) {
        trustCount.put(person[1], trustCount.get(person[1]) + 1);
        if (trustCount.get(person[1]) == N - 1) {
          judge = person[1];
        }
      } else {
        trustCount.put(person[1], 1);
      }
    }
    if (count.containsKey(judge)) {
      return -1;
    }
    return judge;
  }

}
