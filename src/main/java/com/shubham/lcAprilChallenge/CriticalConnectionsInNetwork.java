package com.shubham.lcAprilChallenge;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CriticalConnectionsInNetwork {

  /*
  Step 1: The graph is created from a hashmap and populated with the concerned values from the
   connections list of lists variable.

  Step 2: A list of list variable named ans is initialized to store the vertices combination which
   are critical connections.

  Step 3: An array variable rank is created to store the rank of the corresponding
   indices(i.e.., vertices) and initialized. (rank: According to Graph theory it is a difference
    between number of vertices and the connected components).

  Step 4: A boolean array is created to check the visited vertices.

  Step 5: A variables preNode, curNode and curRank are declared and initialized to -1, 0 and 0
   respectively.(Since the dfs will be started with the 0 as current node with rank of the current
    node as 0 and the previous node will be obviously -1).

  Step 6: The dfs is invoked and inside it the visited array and rank array for the current node
   will be updated.

  Step 7: Then the for loop iterates towards the graph for the neighbours of the current node via a
   graph. If the current node is the previous node then the iteration is skipped.

  Step 8: Then the dfs is again invoked with current node as a previous node and the current
   neighbour as a current node with current rank value incremented by 1.

  Step 9: Then from step 7 if the node is already visited then the minimum rank value of it in
   comparison with the neighbor node is considered.

  Step 10: Then if the rank of the neighbor is less than the rank of the current vertice then it
   means the current node is critically connected. Then the current node along with its neighbor to
    which its critically connected is added to the ans list.
   */

  public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<List<Integer>> ans = new LinkedList<>();
    for (List<Integer> connection : connections) {
      int a = connection.get(0);
      int b = connection.get(1);
      graph.putIfAbsent(a, new LinkedList<>());
      graph.putIfAbsent(b, new LinkedList<>());
      graph.get(a).add(b);
      graph.get(b).add(a);
    }
    int[] rank = new int[n];
    for (int i = 0; i < n; ++i) {
      rank[i] = i;
    }
    boolean[] visited = new boolean[n];
    int prevNode = -1, curNode = 0, curRank = 0;
    dfs(visited, rank, prevNode, curNode, curRank, graph, ans);
    return ans;
  }

  private void dfs(boolean[] visited, int[] rank, int prevNode, int curNode, int curRank,
      Map<Integer, List<Integer>> graph, List<List<Integer>> ans) {
    rank[curNode] = curRank;
    visited[curNode] = true;
    for (int neighbor : graph.get(curNode)) {
      if (neighbor == prevNode) {
        continue;
      }
      if (!visited[neighbor]) {
        dfs(visited, rank, curNode, neighbor, curRank + 1, graph, ans);
      }
      rank[curNode] = Math.min(rank[curNode], rank[neighbor]);
      if (rank[neighbor] == curRank + 1) {
        ans.add(Arrays.asList(curNode, neighbor));
      }
    }
  }
}
