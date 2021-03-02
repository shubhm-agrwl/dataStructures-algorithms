package com.shubham.dataStructures.tree;

import com.shubham.lcFebChallenge.TreeNode;

public class MinMaxDepth {

  public int maxDepth(TreeNode root) {
    return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }

  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int left = minDepth(root.left);
    int right = minDepth(root.right);

    if (left == 0 || right == 0) {
      return Math.max(left, right) + 1;
    } else {
      return Math.min(left, right) + 1;
    }
  }

}
