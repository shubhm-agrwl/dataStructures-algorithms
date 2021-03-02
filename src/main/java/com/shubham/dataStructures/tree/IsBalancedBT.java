package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;

public class IsBalancedBT {

  public boolean isBalanced(TreeNode root) {
    if (root == null) {
      return true;
    }
    return helper(root) >= 0;
  }

  public int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int a = helper(root.left) + 1;
    int b = helper(root.right) + 1;
    if (a < 0 || b < 0 || Math.abs(a - b) >= 2) {
      return Integer.MIN_VALUE;
    }
    return Math.max(a, b);
  }

}
