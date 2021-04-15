package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class UniqueBST {

  public static void main(String[] args) {
    System.out.println(numTrees(3));
    System.out.println(generateTrees(3));
  }

  public static int numTrees(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;

    for (int i = 2; i <= n; i++) {

      int l = 0;
      int r = i - 1;
      while (l <= i - 1) {
        dp[i] += dp[l] * dp[r];
        l++;
        r--;
      }
    }

    return dp[n];
  }

  public static List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<TreeNode>();
    }
    List<TreeNode>[][] dp = new List[n + 1][n + 1];
    return helper(1, n, dp);
  }

  public static List<TreeNode> helper(int start, int end, List<TreeNode>[][] dp) {
    if (start > end) {
      List<TreeNode> tmp = new ArrayList<>();
      tmp.add(null);
      return tmp;
    }

    if (dp[start][end] != null) {
      return dp[start][end];
    }

    List<TreeNode> result = new ArrayList<>();
    for (int i = start; i <= end; i++) {
      List<TreeNode> left = helper(start, i - 1, dp);
      List<TreeNode> right = helper(i + 1, end, dp);
      for (TreeNode l : left) {
        for (TreeNode r : right) {
          TreeNode n = new TreeNode(i);
          n.left = l;
          n.right = r;
          result.add(n);
        }
      }
    }
    dp[start][end] = result;
    return result;
  }

}
